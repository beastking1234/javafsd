package exceptions;
import org.springframework.data.repository.CrudRepository;

import com.example.Authentication.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByName(String name);
}
Footer
© 2022 GitHub, Inc.
Footer navigation
Terms
Privacy
Se