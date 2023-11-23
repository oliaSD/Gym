package scripts.controller;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import scripts.dto.RegistrationUserDto;
import scripts.model.UserModel;
import scripts.model.UserRole;
import scripts.service.UserService;


@Controller
@RequestMapping(path="/user")
@RequiredArgsConstructor
public class UserController {



    private final UserService userRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestBody RegistrationUserDto registartion) {
            var user = new UserModel();
            user.setPassword(new BCryptPasswordEncoder().encode(registartion.getPassword()));
            user.setName(registartion.getName());
            user.setEmail(registartion.getEmail());
            user.setUserRole(List.of(new UserRole("ROLE_USER")));
            userRepository.createNewUser(user);
            return "Sec";
    }

}