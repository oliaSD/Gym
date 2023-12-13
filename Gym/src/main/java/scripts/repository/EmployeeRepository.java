package scripts.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import scripts.model.Employee;


@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    


    public Optional<Employee> findByUserModelId(Integer id);

    public Optional<Employee> findByUserModelName(String name);
}
