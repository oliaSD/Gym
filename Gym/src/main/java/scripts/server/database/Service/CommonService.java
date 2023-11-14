package scripts.server.database.Service;

import java.util.Optional;

import scripts.server.model.AbstractEntity;

public interface CommonService<E extends AbstractEntity> {
    
    Optional<E> save(E entity);

    Iterable<E> findAll();

    Optional<E> findById(Integer id);

    void deleteById(Integer id);
    
}
