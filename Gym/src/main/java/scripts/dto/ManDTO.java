package scripts.dto;

import java.sql.Date;

import lombok.Data;
import scripts.model.enums.Gender;

@Data
public class ManDTO {

    private String firstName;

    private String secondName;

    private String phoneNumber;

    private Date birthDay;

    private Gender gender;
}
