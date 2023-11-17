package scripts.server.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import scripts.server.database.Service.UserService;

@Controller
@RequestMapping(path = "/login")
public class LoginController {

	private final AuthenticationManager authenticationManager;

	@Autowired 
	private  UserService uService;

	public LoginController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@GetMapping("/sigin")
    public String getLogin(){
        return "login";
    }

	@PostMapping("/loginsubmit")
	public @ResponseBody String login(@RequestParam  String password,@RequestParam  String username ) {
		var temp =true;
	
	    if(!uService.findByNameAndPassword(username, password).isEmpty())
		{
			Authentication authenticationRequest =
			UsernamePasswordAuthenticationToken.unauthenticated(username, password);
			Authentication authenticationResponse =
			this.authenticationManager.authenticate(authenticationRequest);
			return  "index";
		}
		return "login";		
	}

public record LoginRequest(String username, String password){
	}

}