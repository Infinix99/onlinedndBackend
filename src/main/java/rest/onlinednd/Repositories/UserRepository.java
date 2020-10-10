package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;
import rest.onlinednd.Entities.User;

import java.util.Set;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "Select * from Charactersheets c WHERE c.userid = :UserID"
            , nativeQuery = true )
    Set<Charactersheet> findAllCharactersheets(@Param("UserID") int UserID);



}
