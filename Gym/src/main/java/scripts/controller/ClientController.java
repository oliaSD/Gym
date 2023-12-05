package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.dto.ManDTO;
import scripts.model.Client;
import scripts.model.Schedule;
import scripts.service.ClientService;
import scripts.service.GroupService;
import scripts.service.ScheduleService;
import scripts.service.UserService;
import scripts.utils.ConverterDTOtoModel;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
@CrossOrigin
public class ClientController {
    

    private final ClientService clientService;
    private final ScheduleService scheduleService;
    private final GroupService groupService;
    private final UserService userService;

    @GetMapping("/schedule")
    public ResponseEntity<?> getSchedule(@RequestParam Integer id){
        return scheduleService.getScheduleClient(id);
    }

    @GetMapping("/groups")
    public ResponseEntity<?> getGroups(@RequestParam Integer id){
        return groupService.getClientGroups(id);
    }

    @GetMapping("/getUserId")
    public ResponseEntity<?> getUserIdByName(@RequestParam String name){
        return userService.getIdByName(name);
    }

    @GetMapping("/getClient")
    public ResponseEntity<?> getClientIdByUserId(@RequestParam Integer id){
        return clientService.getClientIdByUserId(id);
    }

    @PostMapping("/saveClient")
    public ResponseEntity<?> saveClient(@RequestBody Client manDTO){
        return clientService.saveClient(manDTO);
    }

    @PostMapping("/delete")
    public ResponseEntity<?> deleteClient(@RequestParam Integer id){
        return clientService.deleteClientById(id);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getClientInfo(@RequestParam Integer id){
        return clientService.getClient(id);
    }

    @GetMapping("/getClientIdByUserName")
    public ResponseEntity<?> getClientIdByUserName(@RequestParam String userName){
        return clientService.getClientIdByUserName(userName);
    }
}
