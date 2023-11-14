package scripts.server.database.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.Employee;


@Service
public class EmployeeService extends AbstractService<Employee,CommonRepository<Employee>>{

    public EmployeeService(CommonRepository<Employee> repository) {
        super(repository);
        //TODO Auto-generated constructor stub
    }

    @Override
    public Optional<Employee> save(Employee entity) {
        // TODO Auto-generated method stub
        return Optional.of(this.repository.save(entity));
    }

    @Override
    public Iterable<Employee> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }



    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }
    
}
