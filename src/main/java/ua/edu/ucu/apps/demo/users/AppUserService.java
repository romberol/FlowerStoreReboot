package ua.edu.ucu.apps.demo.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepository repository;

    public AppUserService(AppUserRepository repository) {
        this.repository = repository;
    }

    public List<AppUser> getAppUsers() {
        return repository.findAll();
    }

    public void addAppUser(AppUser user) {
        if (repository.findAppUserByEmail(user.getEmail()).isEmpty()) {
            repository.save(user);
        }
    }

    public void updateUser(int id) {
        Optional<AppUser> userOptional = repository.findById(id);
        if (userOptional.isPresent()) {
            AppUser user = userOptional.get();
            user.update();
            repository.save(user);
        }
    }
}
