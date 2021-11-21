package solucionreto1.Reto1.repository.crud;

import org.springframework.data.repository.CrudRepository;
import solucionreto1.Reto1.model.User;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Miguel Ramos
 */

public interface UserCrudRepository extends CrudRepository<User, Integer> {
    public Optional<User> findByName(String name);

    public Optional<User> findByEmail(String email);

    public List<User> findByNameOrEmail(String name, String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
}