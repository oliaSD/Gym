package scripts.server.database.Service;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.CommonRepository;
import scripts.server.model.Client;

@Service
public class ClientService extends AbstractService<Client, CommonRepository<Client>> {


    public ClientService(CommonRepository<Client> repository){
        super(repository);
    }

  
    
}
