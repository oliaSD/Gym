
package scripts.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import scripts.server.database.Service.UserService;
import scripts.server.model.UserModel;


@Controller
@RequestMapping(path="/user")
public class UserController {


    @Autowired 
    private UserService userRepository;


    @PostMapping(path="/add")
    public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email
      , @RequestParam String password) {


        UserModel n = new UserModel();
        n.setEmail( email);
        n.setName(name);
        n.setPassword(password);
        userRepository.save(n);
        return "index";
    }


    @GetMapping(path="/all")
    public @ResponseBody Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path="/delete")
    public @ResponseBody String deleteUserById(@RequestParam Integer Id) {
        
        userRepository.deleteById(Id);

        return "Index";
    }



}