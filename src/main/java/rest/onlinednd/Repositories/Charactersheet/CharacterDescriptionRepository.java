package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.repository.CrudRepository;
import rest.onlinednd.Entities.Charactersheet.CharacterDescription;
import rest.onlinednd.Entities.Charactersheet.Skills;

public interface CharacterDescriptionRepository extends CrudRepository<CharacterDescription, Integer> {




}
