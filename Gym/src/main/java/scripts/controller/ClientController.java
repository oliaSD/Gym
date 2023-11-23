package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.service.ClientService;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class ClientController {
    

    private final ClientService clientService;


    @PostMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam Integer id){
        return clientService.deleteClientById(id);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getClientInfo(@RequestParam Integer id){
        return clientService.getClient(id);
    }

}
