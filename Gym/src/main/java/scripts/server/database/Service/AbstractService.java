package scripts.server.database.Service;

import org.springframework.beans.factory.annotation.Autowired;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.AbstractEntity;

public abstract class AbstractService<E extends AbstractEntity, 
                                      R extends CommonRepository<E>> implements CommonService<E>{
    
    protected final R repository;

    @Autowired
    public AbstractService(R repository){
        this.repository = repository;
    }

    

}
