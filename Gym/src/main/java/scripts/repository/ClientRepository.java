package scripts.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.Client;



@Repository
public interface ClientRepository  extends CrudRepository<Client, Integer> {


    public Optional<Client> findByUserModelId(Integer id);

    public Optional<Client> findByUserModelName(String name);

}
