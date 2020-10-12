package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;
import rest.onlinednd.Entities.User;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Integer> {

    //find by ID
    @Query(value = "select * from user u  where u.userid = :userid"
            ,nativeQuery = true)
    User findUserByID(@Param("userid") int userid);


}
