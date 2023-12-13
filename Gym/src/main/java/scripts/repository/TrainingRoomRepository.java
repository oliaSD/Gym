package scripts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.TrainingRoom;

@Repository
public interface TrainingRoomRepository extends CrudRepository<TrainingRoom, Integer>{
     
}
