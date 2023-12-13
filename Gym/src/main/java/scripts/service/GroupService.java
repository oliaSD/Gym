package scripts.service;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @PersistenceContext
    private final EntityManager entityManager;

    public ResponseEntity<?> getClientGroups(Integer id) {
        // var groups = groupRepository.findByClientsId(id);
        // groups.forEach(e -> e.setClients(null));
        return ResponseEntity.ok(groupRepository.findByClientsId(id));
    }

    public ResponseEntity<?> getAllgroups() {
        var s = new ArrayList<GroupTraining>();
        groupRepository.findByGroupTypeNot(GroupType.Solo).forEach(s::add);
        return ResponseEntity.ok(s);
    }

    public ResponseEntity<?> getGroupSchedule(Integer id) {
        return ResponseEntity.ok(scheduleRepository.findByGroupId(id));
    }

    public ResponseEntity<?> addClientToGroup(Integer clientId, Integer groupId) {

        try {
            groupRepository.addGroupAndClient(clientId, groupId);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.ok("not add client group");
        }
        return ResponseEntity.ok("add client group");
    }

   

    public ResponseEntity<?> deleteClientFromGroup(Integer clientId, Integer groupId) {
        try {
            groupRepository.deleteClientGroup(clientId, groupId);
        } catch (Exception e) {
            return ResponseEntity.ok("not delete client group");
        }
        return ResponseEntity.ok("delete client group");
    }

   

}
