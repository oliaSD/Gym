package scripts.server.database.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.AbstractEntity;

public abstract class AbstractService<E extends AbstractEntity, R extends CommonRepository<E>> implements CommonService<E>{
    
    protected final R repository;

    @Autowired
    public AbstractService(R repository){
        this.repository = repository;
    }


    @Override
    public Optional<E> save(E entity){
        return Optional.of(repository.save(entity));
    }

    @Override
    public Iterable<E> findAll(){
        return repository.findAll();
    }
    @Override
    public Optional<E> findById(Integer id){
        return repository.findById(id);
    }
    @Override
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
    

}
