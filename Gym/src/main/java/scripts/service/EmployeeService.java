package scripts.service;



import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.model.Employee;

import scripts.repository.EmployeeRepository;
import scripts.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class EmployeeService  {
    
    
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;

    public void createNewEmployer(Employee employee){
        userRepository.save(employee.getUserModel());
        employeeRepository.save(employee);
    }

    public ResponseEntity<?> getAllEmployee() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    public ResponseEntity<?> getEmployee(Integer id) {
        return ResponseEntity.ok(employeeRepository.findById(id));
    }

    public ResponseEntity<?> saveEmployee(Employee employee) {
        var user = employeeRepository.findById(employee.getId());
        employee.setUserModel(user.get().getUserModel());
        //employee.setGroupTrainings(user.get().getGroupTrainings());
        employee.setPathToAvatar(user.get().getPathToAvatar());
        var employeeSave = employeeRepository.save(employee);
        return ResponseEntity.ok(employeeSave);
    }


    // public ResponseEntity<?> getEmployeeIdByUserId(String username) {
    //     return ResponseEntity.ok(employeeRepository.findByUserModelId(id).get());
    // }

    public ResponseEntity<?> getEmployeeIdByUserModelUsername(String userName) {
        return ResponseEntity.ok(employeeRepository.findByUserModelName(userName).get());
    }

}
