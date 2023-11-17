package scripts.server.database.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import scripts.server.model.AbstractEntity;
@Repository
public interface CommonRepository<E extends AbstractEntity> extends CrudRepository<E, Integer>{


}
 