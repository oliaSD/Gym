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
import scripts.model.Client;
import scripts.model.Employee;
import scripts.service.EmployeeService;
import scripts.service.ScheduleService;

@RequiredArgsConstructor
@RequestMapping("/employee")
@RestController
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ScheduleService scheduleService;

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getSchedule")
    public ResponseEntity<?> getSchedule(@RequestParam Integer id) {
        return scheduleService.getScheduleEmployee(id);
    }

    @GetMapping("/getInfo")
    public ResponseEntity<?> getInfo(@RequestParam Integer id) {
        return employeeService.getEmployee(id);
    }
 
    @PostMapping("/saveEmployee")
    public ResponseEntity<?> saveClient(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }


    @GetMapping("/getEmployeeByUserName")
    public ResponseEntity<?> getEmployeeByUserName(@RequestParam String userName) {        
        return employeeService.getEmployeeIdByUserModelUsername(userName);
    }
    

}
