package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Charactersheet;
import rest.onlinednd.Entities.Charactersheet.Notes;
import rest.onlinednd.Entities.User;

import java.util.ArrayList;
import java.util.Set;

public interface UserRepository extends CrudRepository<User, Integer> {

    //find by ID
    @Query(value = "select * from user u  where u.userid = :userid"
            ,nativeQuery = true)
    User findUserByID(@Param("userid") int userid);

    //get latest user
    @Query(value = "select * from user u order by u.userid desc limit 1", nativeQuery = true)
    User latestUser ();

    //find by Name
    @Query(value = "select * from user u  where u.name = :name", nativeQuery = true)
    User findUserByName(@Param("name") String username);

    //change Email
    @Query(value = "update user set email=:newemail where userid=:userid", nativeQuery = true)
    User  updateEmail(@Param("newemail") String newemail, @Param("userid")int userid);

    //change Password
    @Query(value = "update user set password=:newpassword where userid=:userid", nativeQuery = true)
    User  updatePassword(@Param("newpassword") String newpassword, @Param("userid")int userid);

    //findByEmail
    @Query(value = "select * from user where email=:email", nativeQuery = true)
    User findUserByEmail(@Param("email") String email);
}
