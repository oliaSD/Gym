package scripts.server.database.Repository;

import org.springframework.data.repository.CrudRepository;

import scripts.server.model.AbstractEntity;

public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Integer>{
    
}
 