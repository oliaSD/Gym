package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.service.GroupService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {
    
    private final GroupService groupService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllGroups(){
        return groupService.getAllgroups();
    }

     @GetMapping("/groupSchedule")
    public ResponseEntity<?> getGroupSchedule(@RequestParam Integer id){
        return groupService.getGroupSchedule(id);
    }


    @GetMapping("/addClientToGroup")
    public ResponseEntity<?> addClientToGroup(@RequestParam Integer clientId, @RequestParam Integer groupId){
        return groupService.addClientToGroup(clientId,groupId);
    }

    @GetMapping("/deleteClientGroup")
    public ResponseEntity<?> deleteClientFromGroup(@RequestParam Integer clientId, @RequestParam Integer groupId){
        return groupService.deleteClientFromGroup(clientId,groupId);
    }

}
