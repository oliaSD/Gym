package scripts.service;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.model.Client;
import scripts.repository.ClientRepository;
import scripts.repository.UserRepository;
import java.awt.image.BufferedImage;
import java.io.IOException;
@Service
@RequiredArgsConstructor
public class ClientService {

    private final UserRepository userRepository;
    private final ClientRepository clientRepository;

    public Client createNewClient(Client client) {
        userRepository.save(client.getUserModel());
        return clientRepository.save(client);
    }

    public ResponseEntity<?> deleteClientById(Integer id) {
        var client = clientRepository.findById(id);
        if (!client.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Client not found"),
                    HttpStatus.BAD_REQUEST);
        }
        clientRepository.deleteById(id);
        userRepository.deleteById(client.get().getId());
        return ResponseEntity.ok(String.format("$Client %d has been delete", id));
    }

    public ResponseEntity<?> getClient(Integer id) {
        var client = clientRepository.findById(id);
         if (!client.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Client not found"),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(client.get());
    }

    public ResponseEntity<?> getClientIdByUserId(Integer id) {
        return ResponseEntity.ok(clientRepository.findByUserModelId(id).get());
    }

    public ResponseEntity<?> saveClient(Client client) {
        var user = clientRepository.findById(client.getId());
        client.setUserModel(user.get().getUserModel());
        client.setGroupTrainings(user.get().getGroupTrainings());
        client.setPathToAvatar(user.get().getPathToAvatar());
        var clientSave = clientRepository.save(client);
        return ResponseEntity.ok(clientSave);
    }

    public ResponseEntity<?> getClientIdByUserName(String userName) {
        return ResponseEntity.ok(clientRepository.findByUserModelName(userName).get());
    }

    public ResponseEntity<?> getClientAvatar(Integer id) throws IOException {
        var client = clientRepository.findById(id);
        if (!client.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Image not found"),
                    HttpStatus.BAD_REQUEST);
        }
        var s = ClientService.class.getResourceAsStream(client.get().getPathToAvatar());
        BufferedImage bufferedImage = ImageIO.read(s);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(baos.toByteArray());
    }

    public String updateImage(String originalFilename, String username) {
        var client = clientRepository.findByUserModelName(username);
        if(!client.isPresent()){
            return null;
        }
        var path = client.get().getPathToAvatar();
        client.get().setPathToAvatar(String.format("/pictures/"+originalFilename));
        clientRepository.save(client.get());
        return path;
    }
}
