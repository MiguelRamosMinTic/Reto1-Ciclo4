package solucionreto1.Reto1.repository.crud;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import solucionreto1.Reto1.model.User;

/**
 *
 * @author Miguel Ramos
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    
    public List<User> findByEmail(String email);
    
//    public Optional<User> findByPasswordEmail(String email, String password);
    
    public List<User> findByNameOrEmail(String name, String email);
}
