package scripts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.TrainingApparatus;


@Repository
public interface TrainingAparatusRepository extends CrudRepository<TrainingApparatus, Integer>{
    
}
