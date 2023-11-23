package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.dto.ManDTO;
import scripts.dto.RegistrationUserDto;
import scripts.service.RegistrationService;

@RestController
@RequestMapping(path = "/registaration")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping("/client")
    @CrossOrigin(originPatterns = {"http://localhost:3000/*", "http://localhost*"})
    public ResponseEntity<?> registartionClient(@RequestBody Reg reg){     
        return registrationService.registartionClient(reg.registrationUserDto, reg.manDTO);
    }

    @PostMapping("/employee")
    @CrossOrigin(originPatterns = {"http://localhost:3000/*", "http://localhost*"})
    public ResponseEntity<?> registartionEmployee(@RequestBody RegistrationUserDto registrationUserDto,@RequestBody ManDTO manDTO){
        return registrationService.registartionEmployee(registrationUserDto, manDTO);
    }

    public record Reg(RegistrationUserDto registrationUserDto,ManDTO manDTO){}
}
