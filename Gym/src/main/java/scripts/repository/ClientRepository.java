package scripts.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.Client;



@Repository
public interface ClientRepository  extends CrudRepository<Client, Integer> {


}
