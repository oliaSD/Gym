package scripts.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scripts.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    public List<UserModel> findByName(String name);

    @Transactional
    @Query(value = "select cl.path_to_avatar from user_model as um " +
            "join client as cl on cl.user_model_id = um.id " +
            "where um.name = :username " +
            "union all " +
            "select em.path_to_avatar from user_model as um " +
            "join employee as em on em.user_model_id = um.id " +
            "where um.name = :username " +
            "limit 1", nativeQuery = true)
    public Optional<String> getPathToImage(@Param("username") String userName);

    @Transactional
    @Modifying
    @Query(value = "update client as cl " +
            "set path_to_avatar = :new_path " +
            "where cl.user_model_id in ( " +
            "select id from user_model " +
            "where user_model.name = :username ); ", nativeQuery = true)
    public Object updatePathToImageClient(@Param("username") String username, @Param("new_path") String new_path);

    @Transactional
    @Modifying
    @Query(value = "update employee as cl " +
            "set path_to_avatar = :new_path " +
            "where cl.user_model_id in ( " +
            "select id from user_model " +
            "where user_model.name = :username ); ", nativeQuery = true)
    public Object updatePathToImageEmployee(@Param("username") String username, @Param("new_path") String new_path);
}
