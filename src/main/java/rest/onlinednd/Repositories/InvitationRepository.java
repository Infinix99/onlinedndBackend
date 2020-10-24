package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Invitation;
import rest.onlinednd.Entities.Group;
import rest.onlinednd.Entities.User;

import java.util.Set;

public interface InvitationRepository extends CrudRepository<Invitation, Integer> {

    //find by ID
    @Query(value = "select * from invitation u  where u.invid= :invid"
            ,nativeQuery = true)
    Invitation findInvByID(@Param("invid") int invid);

    //find by ID by UserID
    @Query(value = "select * from invitation u WHERE u.invited_user_userid = :userid "
            ,nativeQuery = true)
    Set<Invitation> findInvitationByUserID(@Param("userid") int userid);


}
