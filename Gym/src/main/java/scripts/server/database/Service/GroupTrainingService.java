package scripts.server.database.Service;

import scripts.server.model.GroupTraining;

import java.util.Optional;

import org.springframework.stereotype.Service;

import scripts.server.database.Repository.CommonRepository;

@Service
public class GroupTrainingService extends AbstractService<GroupTraining, CommonRepository<GroupTraining>> {

    public GroupTrainingService(CommonRepository<GroupTraining> repository) {
        super(repository);
        //TODO Auto-generated constructor stub
    }
    
}
