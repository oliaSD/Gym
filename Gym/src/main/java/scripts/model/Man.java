package scripts.model;


import java.sql.Date;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scripts.model.enums.Gender;


@MappedSuperclass 
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access =  AccessLevel.PUBLIC)
public abstract class Man  extends AbstractEntity{
  @OneToOne
    // @JoinColumn(name = "user_model_id", 
    //    referencedColumnName = "user_id", 
    //    insertable = false, updatable = false, 
    //    foreignKey = @jakarta.persistence
    //      .ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    protected UserModel userModel;

    protected String firstName;

    protected String secondName;

    protected String phoneNumber;

    protected Date birthDay;

    protected Gender gender;
}
