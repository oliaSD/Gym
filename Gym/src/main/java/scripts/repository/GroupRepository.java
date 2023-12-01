package scripts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import scripts.model.GroupTraining;
import scripts.model.enums.GroupType;
import scripts.model.Client;

import java.util.Collection;

import java.util.Set;



@Repository
public interface GroupRepository  extends    CrudRepository<GroupTraining, Integer>
{
    public Collection<GroupTraining>  findByClients(Client clients);

    public Collection<GroupTraining> findByClientsId(Integer id);

    public Collection<GroupTraining> findByGroupTypeNot(GroupType GroupType);
}
