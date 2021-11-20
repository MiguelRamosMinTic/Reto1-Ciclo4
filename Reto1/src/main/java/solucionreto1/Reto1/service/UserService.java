package solucionreto1.Reto1.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
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
        return repository.getUserById(id);
    }

    public User save(User u){
        if(u.getName() == null || u.getEmail() == null || u.getPassword() == null){
            return u;
        }else{
            List<User> existUser = repository.getUsersByNameOrEmail(u.getName(), u.getEmail());
            if(existUser.isEmpty()){
                if(u.getId()==null){
                    return repository.save(u);
                }else{
                    Optional<User> existUser2 = repository.getUserById(u.getId());
                    if(existUser2.isEmpty()){
                        return repository.save(u);
                    }else{
                        return u;
                    }
                }
            }else{
                return u;
            }
        }
    }
    
    public User update(User o) {
        if (o.getId() != null) {
            Optional<User> g = repository.getUserById(o.getId());
            if (!g.isEmpty()) {
                if (o.getEmail() != null) {
                    g.get().setEmail(o.getEmail());
                }
                if (o.getPassword() != null) {
                    g.get().setPassword(o.getPassword());
                }
                if (o.getName() != null) {
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

    public boolean verificarEmail(String email) {
        if (repository.chequearEmail(email).isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

//    public User verificarEmailPassword(String email, String password) {
//        Optional<User> existe = repository.getUserEmailAndPassword(email, password);
//        if (existe.isPresent()) {
//            return existe.get();
//        }else{
//            return new User(id:null, email, password, name:"NO DEFINIDO");
//        }
//    }

//    public User verificarEmailPassword(String email, String password){
//        Optional<User> existe = repository.getUserEmailAndPassword(email, password);
//        if(existe.isPresent()){
//            return existe.get();
//        }else{
//            String name = "NO DEFINIDO";
//            int id = 0;
//            return new User(id,email,password,name);
//        }
//    }
}
