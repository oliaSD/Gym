package scripts.server.database.Service;

import java.util.List;
import java.util.Optional;

import javax.swing.text.html.parser.Entity;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.UserRepository;
import scripts.server.model.UserModel;


@Service
public class UserService extends AbstractService<UserModel, UserRepository> {

    public UserService(UserRepository repository){
        super(repository);
    }

    public List<UserModel> findByNameAndPassword(String name, String password){
        return repository.findByNameAndPassword(name,password);
    }
}
