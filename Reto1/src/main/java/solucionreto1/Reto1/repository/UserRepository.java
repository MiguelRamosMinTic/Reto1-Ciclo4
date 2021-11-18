package solucionreto1.Reto1.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import solucionreto1.Reto1.model.User;
import solucionreto1.Reto1.repository.crud.UserCrudRepository;

/**
 *
 * @author Miguel Ramos
 */

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository repository;
    
    public List<User> getAll() {
        return (List<User>) repository.findAll();
    }

    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    public User save(User u) {
        return repository.save(u);
    }

    public void delete(User u) {
        repository.delete(u);
    }
    
    public List<User> chequearEmail(String email){
        return repository.findByEmail(email);
    }
    
}
