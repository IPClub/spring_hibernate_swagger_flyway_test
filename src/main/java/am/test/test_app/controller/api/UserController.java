package am.test.test_app.controller.api;

import am.test.test_app.model.AppUser;
import am.test.test_app.repo.AppUserRepo;
import am.test.test_app.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    AppUserService appUserService;

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String test() {
//        return "Barev";
//    }
//
//    @RequestMapping("/dummy")
//    public ResponseEntity<AppUser> dummyUser() {
//        return new ResponseEntity<>(
//                new AppUser("uuu", "asds@asda.sd", 34),
//                HttpStatus.OK);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
        AppUser savedUser = appUserService.saveUser(user);
        if (savedUser != null) {
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<AppUser>> getUsers() {
        return new ResponseEntity<>(appUserService.getAllUsers(), HttpStatus.OK);
    }


}

