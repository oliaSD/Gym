package scripts.repository;


import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.Schedule;


import scripts.model.Employee;
import scripts.model.GroupTraining;



@Repository
public interface ScheduleRepository  extends CrudRepository<Schedule, Integer>{
    
    
        public Collection<Schedule> findByEmployeeId(Integer id);

        public Collection<Schedule>  findByGroupId(Integer id);

        public Collection<Schedule> findByGroupClientsId(Integer id);

}
