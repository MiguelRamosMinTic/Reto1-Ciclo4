package solucionreto1.Reto1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import solucionreto1.Reto1.model.User;
import solucionreto1.Reto1.service.UserService;

/**
 *
 * @author Miguel Ramos
 */


@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User u){
        return service.save(u);
    }

    @GetMapping("/{email}")
    public boolean existsEmail(@PathVariable("email") String email){
        return service.getUserByEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User existsUser(@PathVariable("email") String email, @PathVariable("password") String password) {
        return service.getByEmailPass(email, password);
    }
}
