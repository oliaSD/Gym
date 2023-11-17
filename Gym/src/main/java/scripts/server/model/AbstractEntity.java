package scripts.server.model;

import java.io.Serializable;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class AbstractEntity implements Serializable{
    

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    //@Column(insertable=false, updatable=false)
    protected Integer id;
}
