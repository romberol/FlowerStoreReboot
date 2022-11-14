package ua.edu.ucu.apps.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class AppUserController {
    private AppUserService service;

    @Autowired
    public AppUserController(AppUserService service) {
        this.service = service;
    }

    @GetMapping
    public List<AppUser> getAppUsers(){
        return service.getAppUsers();
    }

    @PostMapping
    public void addAppUser(@RequestBody AppUser user){
        service.addAppUser(user);
    }

}
