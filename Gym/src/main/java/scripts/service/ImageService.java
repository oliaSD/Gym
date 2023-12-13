package scripts.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.model.Employee;
import scripts.repository.ClientRepository;
import scripts.repository.EmployeeRepository;
import scripts.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public ResponseEntity<?> getClientAvatar(Integer id) throws IOException {
        var client = clientRepository.findById(id);
        if (!client.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Image not found"),
                    HttpStatus.BAD_REQUEST);
        }

        ByteArrayOutputStream baos = getBaos(client.get().getPathToAvatar());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(baos.toByteArray());
    }

    public String updateImage(String username, MultipartFile image) {
        try {
            var newFileName = addNewPicture(image);
            var oldFilePath = userRepository.getPathToImage(username);
            userRepository.updatePathToImageClient(username, newFileName);
            userRepository.updatePathToImageEmployee(username, newFileName);
            System.out.println(oldFilePath + newFileName + username);
            if (oldFilePath.isPresent() && oldFilePath.get() != null) {
                if (deleteImage(oldFilePath.get(), newFileName)) {
                    return "success";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "error";
    }

    private String addNewPicture(MultipartFile image) throws IOException {
        String fileName = "pictures/" + StringUtils.cleanPath(image.getOriginalFilename());
        Path filePath = Path.of(fileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return fileName;
    }

    private boolean deleteImage(String fileNameOld, String fileNameNew) throws IOException {
        if (!fileNameNew.equals(fileNameOld)) {
            var oldFilePath = Path.of(fileNameOld);
            return Files.deleteIfExists(oldFilePath);
        }
        return true;
    }

    public ResponseEntity<?> getEmplyeeAvatar(Integer id) throws IOException {
        var employee = employeeRepository.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Image not found"),
                    HttpStatus.BAD_REQUEST);
        }
        ByteArrayOutputStream baos = getBaos(employee.get().getPathToAvatar());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(baos.toByteArray());
    }

    private ByteArrayOutputStream getBaos(String path) throws IOException {
        var s = ImageService.class.getResourceAsStream(path);
        BufferedImage bufferedImage = ImageIO.read(s);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return baos;
    }

}
