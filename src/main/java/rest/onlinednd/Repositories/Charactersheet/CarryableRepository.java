package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Carryable;
import rest.onlinednd.Entities.Charactersheet.Equippable;

import java.util.Set;

public interface CarryableRepository extends CrudRepository<Carryable, Integer> {

    @Query(value = "Select * from carryable c WHERE c.charactersheet_charactersheetid = :charactersheetid"
            , nativeQuery = true )
    Set<Carryable> findAllCarryablesFromSheet(@Param("charactersheetid") int charactersheetid);

    @Query(value = "Select * from carryable c WHERE c.charactersheet_charactersheetid = :charactersheetid AND c.carryableid = :carryableid"
            , nativeQuery = true)
    Carryable findACarryableByIds(@Param("charactersheetid") int charactersheetid, @Param("carryableid") int carryableid);

}
