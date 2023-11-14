package scripts.server.database.Service;

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

    @Override
    public Optional<UserModel> save(UserModel entity) {
        return Optional.of(this.repository.save(entity));
    }

    @Override
    public Iterable<UserModel> findAll() {
        // TODO Auto-generated method stub
        return this.repository.findAll();
    }

    @Override
    public Optional<UserModel> findById(Integer id) {
        // TODO Auto-generated method stub
        return this.repository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {
        // TODO Auto-generated method stub
        this.repository.deleteById(id);
    }
    
}
