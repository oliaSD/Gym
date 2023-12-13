package scripts.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import scripts.service.ScheduleService;





@RestController
@RequestMapping(path="/schedule")
@CrossOrigin
@RequiredArgsConstructor
public class ScheduleController {
    
    private final ScheduleService scheduleService;

    @GetMapping("client/delete")
    public ResponseEntity<?> deleteSchedule(@RequestParam Integer id){
        return scheduleService.deleteRecordClient(id);
    } 

    @GetMapping("client/add")
    public ResponseEntity<?> addClientRecord(@RequestParam Integer clientId, @RequestParam Integer scheduleId){
        return scheduleService.addClientRecord(clientId, scheduleId);
    }

}
