package scripts.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scripts.model.Schedule;


@Repository
public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

        public Collection<Schedule> findByEmployeeId(Integer id);

        public Collection<Schedule> findByGroupId(Integer id);

        public Collection<Schedule> findByGroupClientsId(Integer id);

        @Transactional
        @Modifying
        @Query(value = "UPDATE schedule " +
                        "SET group_id = (" +
                        "SELECT id FROM group_training " +
                        "JOIN group_training_clients ON group_training.id = group_training_clients.group_trainings_id "
                        +
                        "WHERE group_type = 0 AND group_training_clients.clients_id = :clientId " +
                        "LIMIT 1) " +
                        "WHERE id = :scheduleId", nativeQuery = true)
        public int updateSchedule(@Param("clientId") Integer clientId, @Param("scheduleId") Integer scheduleId);

}
