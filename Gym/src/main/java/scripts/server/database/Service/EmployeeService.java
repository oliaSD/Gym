package scripts.server.database.Service;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.Employee;


@Service
public class EmployeeService extends AbstractService<Employee,CommonRepository<Employee>>{

    public EmployeeService(CommonRepository<Employee> repository) {
        super(repository);
    }
    
}
