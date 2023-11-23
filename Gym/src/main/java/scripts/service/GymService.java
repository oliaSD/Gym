package scripts.service;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.model.Gym;
import scripts.model.UserRole;
import scripts.repository.GymRepository;

@Service
@RequiredArgsConstructor
public class GymService {

    private final GymRepository gymRepository;

    public Collection<Gym> findByName(String name) {
        return gymRepository.findByName(name);
    }

    public ResponseEntity<?> getAllGym() {
        List<Gym> gym = new ArrayList<Gym>();
        gymRepository.findAll().forEach(gym::add);
        gym.forEach(x->x.setTrainingRooms(null));
        gym.forEach(x->x.setPathToImage(null));
        return ResponseEntity.ok(gym);
    }

    public ResponseEntity<?> getImage(Integer id) throws IOException {

        var gym = gymRepository.findById(id);
        if (!gym.isPresent()) {
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "$Image not found"),
                    HttpStatus.BAD_REQUEST);
        }
        var s = GymService.class.getResourceAsStream(gym.get().getPathToImage());
        BufferedImage bufferedImage = ImageIO.read(s);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(baos.toByteArray());
    }

    public record ResponseGym(Collection<Gym> response) {
    }
}
