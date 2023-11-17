package scripts.server.database.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import scripts.server.model.UserModel;


@Repository
public interface UserRepository extends CommonRepository<UserModel> {

    public List<UserModel> findByNameAndPassword(String name, String password);
}
