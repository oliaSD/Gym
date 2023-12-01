package scripts.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.model.GroupTraining;
import scripts.model.enums.GroupType;
import scripts.repository.GroupRepository;
import scripts.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class GroupService {

    private final GroupRepository groupRepository;
    private final ScheduleRepository scheduleRepository;

    public ResponseEntity<?> getClientGroups(Integer id){
        // var groups = groupRepository.findByClientsId(id);
        // groups.forEach(e -> e.setClients(null));
        return ResponseEntity.ok(groupRepository.findByClientsId(id));
    }

    public ResponseEntity<?> getAllgroups(){
        var s = new ArrayList<GroupTraining>();
        groupRepository.findByGroupTypeNot(GroupType.Solo).forEach(s::add);
        return ResponseEntity.ok(s);
    }

    public ResponseEntity<?> getGroupSchedule(Integer id){
        return ResponseEntity.ok(scheduleRepository.findByGroupId(id));
    }

}
