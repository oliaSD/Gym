package scripts.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import scripts.service.ImageService;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@CrossOrigin
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/get/client")
    public ResponseEntity<?> getClientAvatar(@RequestParam Integer id) throws IOException {
        return imageService.getClientAvatar(id);
    }

    @GetMapping("/get/employee")
    public ResponseEntity<?> getEmployeeAvatar(@RequestParam Integer id) throws IOException {
        return imageService.getEmplyeeAvatar(id);
    }

    @PostMapping("/post/client")
    public String uploadImage(@RequestParam("image") MultipartFile image, @RequestParam String username)
            throws IOException {
        return imageService.updateImage(username, image);

    }

}
