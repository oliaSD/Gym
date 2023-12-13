package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.dto.JwtRequest;
import scripts.service.AuthService;

@RestController
@RequestMapping(path = "/login")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600)
public class LoginController {

	private final AuthService authService;

	@PostMapping("/auth")
	@CrossOrigin(originPatterns = {"http://localhost:3000/*", "http://localhost*"})
	public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
		return authService.createAuthToken(authRequest);
	}

}