package scripts.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.service.GymService;

@RestController
@RequestMapping(path = "/gym")
@CrossOrigin
@RequiredArgsConstructor
public class GymController {

    private final GymService gymService;

    @PostMapping("/image")
    public ResponseEntity<?> getImage(@RequestBody GymDTORecord data) throws IOException {
        return gymService.getImage(data.id);
    }


    @GetMapping("/gym/all")
    public ResponseEntity<?> getAllGym(){
        return gymService.getAllGym();
    }


    public record GymDTORecord(Integer id) {
    }

}
