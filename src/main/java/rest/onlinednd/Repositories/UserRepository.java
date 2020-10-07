package rest.onlinednd.Repositories;

import org.springframework.data.repository.CrudRepository;
import rest.onlinednd.Entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
