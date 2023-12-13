package scripts.service;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import scripts.dto.AppError;
import scripts.dto.ManDTO;
import scripts.dto.RegistrationUserDto;
import scripts.dto.UserDTO;
import scripts.model.Client;
import scripts.model.Employee;
import scripts.model.GroupTraining;
import scripts.model.UserModel;
import scripts.model.enums.GroupType;
import scripts.repository.GroupRepository;
import scripts.utils.ConverterDTOtoModel;

@Service
@RequiredArgsConstructor
public class RegistrationService {
    
    private final UserService userService;
    private final ClientService clientService;
    private final EmployeeService employeeService;
    private final GroupRepository groupRepository;



    public ResponseEntity<?> registartionClient(RegistrationUserDto registrationUserDto,  ManDTO manDTO){
        if(userService.findByName(registrationUserDto.getName()).isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        UserModel user = ConverterDTOtoModel.fromRegistationUserDTOToUserModel(registrationUserDto);
        Client client = ConverterDTOtoModel.fromManDTOToClient(manDTO);
        GroupTraining group = new GroupTraining();
        BCryptPasswordEncoder ds = new BCryptPasswordEncoder();
        user.setPassword(ds.encode(user.getPassword()));
        client.setUserModel(userService.createNewUser(user));
        group.setClients(Set.of(clientService.createNewClient(client)));
        group.setGroupType(GroupType.Solo);
        group.setGroupNumber(user.getName()+"Solo");
        groupRepository.save(group);
        return ResponseEntity.ok(new UserDTO(user.getId(), user.getName(), user.getEmail()));
    }

    public ResponseEntity<?> registartionEmployee(RegistrationUserDto registrationUserDto, ManDTO manDTO){
        if(userService.findByName(registrationUserDto.getName()).isPresent()){
            return new ResponseEntity<>(new AppError(HttpStatus.BAD_REQUEST.value(), "Пользователь с указанным именем уже существует"), HttpStatus.BAD_REQUEST);
        }
        UserModel user = ConverterDTOtoModel.fromRegistationUserDTOToUserModel(registrationUserDto);
        Employee employee = ConverterDTOtoModel.fromManDTOToEmployee(manDTO);
        employee.setUserModel(userService.createNewUser(user));
        employeeService.createNewEmployer(employee);
        return ResponseEntity.ok(new UserDTO(user.getId(), user.getName(), user.getEmail()));
    }

}
