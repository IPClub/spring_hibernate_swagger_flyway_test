package am.test.test_app.service;

import am.test.test_app.model.AppUser;
import am.test.test_app.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    AppUserRepo appUserRepo;

    public AppUser saveUser(AppUser appUser) {
        if (isValid(appUser)) {
            return appUserRepo.save(appUser);
        }
        return null;
    }

    private boolean isValid(AppUser appUser) {
        return appUser.getEmail() != null && appUser.getUsername() != null;
    }

    public List<AppUser> getAllUsers(){
        return appUserRepo.findAll();
    }
}
