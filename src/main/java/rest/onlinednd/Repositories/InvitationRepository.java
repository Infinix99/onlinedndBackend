package rest.onlinednd.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Invitation;
import rest.onlinednd.Entities.User;

public interface InvitationRepository extends CrudRepository<Invitation, Integer> {


}
