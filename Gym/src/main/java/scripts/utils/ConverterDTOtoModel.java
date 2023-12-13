package scripts.utils;

import scripts.dto.ManDTO;
import scripts.dto.RegistrationUserDto;
import scripts.model.Client;
import scripts.model.Employee;
import scripts.model.UserModel;

public class ConverterDTOtoModel {



    public static Client fromManDTOToClient(ManDTO manDTO){
        Client client = new Client();
        client.setBirthDay(manDTO.getBirthDay());
        client.setFirstName(manDTO.getFirstName());
        client.setPhoneNumber(manDTO.getPhoneNumber());
        client.setSecondName(manDTO.getSecondName());
        client.setGender(manDTO.getGender());
        return client;
    }

    public static Employee fromManDTOToEmployee(ManDTO manDTO){
        Employee employee = new Employee();
        employee.setBirthDay(manDTO.getBirthDay());
        employee.setFirstName(manDTO.getFirstName());
        employee.setPhoneNumber(manDTO.getPhoneNumber());
        employee.setSecondName(manDTO.getSecondName());
        employee.setGender(manDTO.getGender());
        return employee;
    }

    public static UserModel fromRegistationUserDTOToUserModel(RegistrationUserDto registrationUserDto){
        UserModel user = new UserModel();
        user.setEmail(registrationUserDto.getEmail());
        user.setName(registrationUserDto.getName());
        user.setPassword(registrationUserDto.getPassword());
        user.setUserRole(registrationUserDto.getUserRole());
        return user;
    }
    
}
