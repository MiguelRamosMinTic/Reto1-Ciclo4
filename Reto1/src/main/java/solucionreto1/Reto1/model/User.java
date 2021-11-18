package solucionreto1.Reto1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Miguel Ramos
 */

@Data                   // ---- Genera por defecto set and getter
@AllArgsConstructor     // ---- El constructor con argumentos 
@NoArgsConstructor      // ---- El constructor sin argumentos 
@Entity
@Table(name="Usuarios")
public class User implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="user_email", unique = true, length = 50,nullable = false)
    private String email;
    @Column(name="user_password", length = 50,nullable = false)
    private String password;
    @Column(name="user_name", length = 80,nullable = false)
    private String name;
    
//    public User(){
//        
//    }
//    public User(Integer id, String email, String user, String password){       Acostumbrarse a poner estos 2 en general
//        this.id=id;
//        this.email=email;
//        this.user=user;
//        this.password=password;
//    }
    
    
    
}
