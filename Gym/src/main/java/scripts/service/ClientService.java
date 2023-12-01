package scripts.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.model.Client;
import scripts.repository.ClientRepository;
import scripts.repository.UserRepository;

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
        var clientSave = clientRepository.save(client);
        return ResponseEntity.ok(clientSave);
    }
}
