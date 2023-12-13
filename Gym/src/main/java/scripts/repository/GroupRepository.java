package scripts.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import scripts.model.Client;
import scripts.model.GroupTraining;
import scripts.model.enums.GroupType;



@Repository
public interface GroupRepository  extends    CrudRepository<GroupTraining, Integer>
{
    public Collection<GroupTraining>  findByClients(Client clients);

    public Collection<GroupTraining> findByClientsId(Integer id);

    public Collection<GroupTraining> findByGroupTypeNot(GroupType GroupType);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO group_training_clients (clients_id,group_trainings_id ) VALUES (?1,?2)" ,nativeQuery = true)
    public int addGroupAndClient(@Param("clients_id") Integer clientId,@Param("group_trainings_id") Integer groupId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM group_training_clients where clients_id = ?1 and group_trainings_id = ?2" ,nativeQuery = true)
    public int deleteClientGroup(@Param("clients_id") Integer clientId,@Param("group_trainings_id") Integer groupId);
    
}
