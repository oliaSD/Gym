package scripts.service;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.model.Schedule;
import scripts.repository.ScheduleRepository;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    // private final EmployeeRepository employeeRepository;
    // private final GroupRepository groupRepository;
    // private final ClientRepository clientRepository;

    public ResponseEntity<?> getScheduleClient(Integer id) {
        // var group = groupRepository.findByClientsId(id);
        // if(group.isEmpty()){
        // return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
        // "$Grop clint's not found"),
        // HttpStatus.NO_CONTENT);
        // }
        // var schedule = new ArrayList<Schedule>();
        // group.forEach((e)-> {
        // scheduleRepository.findByGroupId(e.getId()).forEach(schedule::add);
        // });
        return ResponseEntity.ok(scheduleRepository.findByGroupClientsId(id));

    }

    public ResponseEntity<?> getScheduleEmployee(Integer id) {
        // var employee = employeeRepository.findById(id);
        // if(!employee.isPresent()){
        // return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(),
        // "$Empployee schedule not found"),
        // HttpStatus.BAD_REQUEST);
        // }
        var schedule = scheduleRepository.findByEmployeeId(id);
        if (schedule.isEmpty()) {
            return new ResponseEntity<>(
                    new AppError(HttpStatus.BAD_REQUEST.value(), "$Рассписание сотрудника не найдено"),
                    HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(schedule);
    }

    public ResponseEntity<?> deleteRecordClient(Integer idRecord) {
        Optional<Schedule> schedule = scheduleRepository.findById(idRecord);
        if (!schedule.isPresent()) {
            return ResponseEntity.ok("Записи и не было");
        }
        schedule.get().setGroup(null);
        scheduleRepository.save(schedule.get());
        return ResponseEntity.ok("Запись успешно удалена");
    }

    public ResponseEntity<?> addClientRecord(Integer clientId, Integer scheduleId) {
        try{
            scheduleRepository.updateSchedule(clientId, scheduleId);
        }catch (Exception e){
            System.err.println(e);
            return ResponseEntity.ok("Записи и не было");
        }
        return ResponseEntity.ok("Запись успешноь добавлена");
    }

}
