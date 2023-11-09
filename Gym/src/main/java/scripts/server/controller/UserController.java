
package scripts.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import scripts.server.database.UserRepository;
import scripts.server.model.User;


@RestController
@RequestMapping(path="/user")
public class UserController {


    @Autowired 
    private UserRepository userRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email
      , @RequestParam String password) {


        User n = new User();
        n.setEmail( email);
        n.setName(name);
        n.setPassword(password);
        userRepository.save(n);
        return "Saved";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/delete")
    public @ResponseBody String deleteUserById(@RequestParam Integer Id) {
        
        userRepository.deleteById(Id);

        return "User delete";
    }



}