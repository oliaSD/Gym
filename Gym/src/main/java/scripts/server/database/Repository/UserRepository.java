package scripts.server.database.Repository;

import org.springframework.stereotype.Repository;

import scripts.server.model.UserModel;


@Repository
public interface UserRepository extends CommonRepository<UserModel> {
    
}
