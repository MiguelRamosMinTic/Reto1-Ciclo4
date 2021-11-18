package solucionreto1.Reto1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import solucionreto1.Reto1.model.User;
import solucionreto1.Reto1.repository.UserRepository;

/**
 *
 * @author Miguel Ramos
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    
    public List<User> getAll() {
        return repository.getAll();
    }

    public Optional<User> getUser(int id) {
        return repository.getUser(id);
    }

    public User save(User c) {
        if (c.getId() == null) {
            return repository.save(c);
        } else {
            Optional<User> caux = repository.getUser(c.getId());
            if (caux.isEmpty()) {
                return repository.save(c);
            } else {
                return c;
            }
        }
    }

    public User update(User o) {
        if (o.getId() != null) {
            Optional<User> g = repository.getUser(o.getId());
            if (!g.isEmpty()) {
                if (o.getEmail()!= null) {
                    g.get().setEmail(o.getEmail());
                }
                if (o.getPassword()!= null) {
                    g.get().setPassword(o.getPassword());
                }
                if (o.getName()!= null) {
                    g.get().setName(o.getName());
                }
                return repository.save(g.get());
            }
        }
        return o;
    }

    public boolean deleteUser(int UserId) {
        Boolean d = getUser(UserId).map(user -> {
            repository.delete(user);
            return true;
        }).orElse(false);
        return d;
    }
    
    public boolean verificarEmail(String email){
        if(repository.chequearEmail(email).isEmpty()){
            return false;
        }else{
            return true;
        }
    }
    
}
