package am.test.test_app.repo;

import am.test.test_app.model.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepo extends CrudRepository<AppUser, Integer> {
    List<AppUser> findAll();
}
