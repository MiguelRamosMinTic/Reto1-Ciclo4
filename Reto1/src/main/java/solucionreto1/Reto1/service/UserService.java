package solucionreto1.Reto1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public boolean getUserByEmail(String email) {
        return repository.getUserByEmail(email).isPresent();
    }

    public User getByEmailPass(String email, String password){
        Optional<User> userExist = repository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User(null, email, password, "NO DEFINIDO");
        }
    }
}
