package solucionreto1.Reto1.repository.crud;

import org.springframework.data.repository.CrudRepository;
import solucionreto1.Reto1.model.User;

/**
 *
 * @author Miguel Ramos
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    
}
