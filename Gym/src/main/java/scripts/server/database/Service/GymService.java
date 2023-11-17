package scripts.server.database.Service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.Gym;

@Service
public class GymService  extends AbstractService<Gym, CommonRepository<Gym>>{

    public GymService(CommonRepository<Gym> repository) {
        super(repository);
        //TODO Auto-generated constructor stub
    }

   
    
}
