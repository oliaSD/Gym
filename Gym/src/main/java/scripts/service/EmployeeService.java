package scripts.service;



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
}
