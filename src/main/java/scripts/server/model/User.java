package scripts.server.model;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString(callSuper = true, exclude = {"password"})
public class User {

    @Id  
    @GeneratedValue(strategy=GenerationType.AUTO)
    private   Integer id;

    private String name;

    private String email;

    private String password;
 

    // public Integer getId() {
    //     return id;
    // }

    // public String getName(){
    //     return name;
    // }

    // public String getEmail(){
    //     return email;
    // }
    
    // public void setName(String name){
    //     this.name = name;
    // }

    // public void setEmail(String email){
    //     this.email = email;
    // }

    // public void  setId(Integer id){
    //     this.id = id;
    // }
}
