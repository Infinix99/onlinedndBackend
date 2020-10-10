package rest.onlinednd.Repositories.Charactersheet;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import rest.onlinednd.Entities.Charactersheet.Notes;

import java.util.Set;

public interface NotesRepository extends CrudRepository<Notes, Integer> {

    @Query(value = "Select * from notes n WHERE n.charactersheet_charactersheetid = :charactersheetid"
            , nativeQuery = true )
        Set<Notes> findAllNotesFromSheet(@Param("charactersheetid") int charactersheetid);

    @Query(value = "Select * from notes n WHERE n.charactersheet_charactersheetid = :charactersheetid AND n.notesid = :notesid"
            , nativeQuery = true)
        Notes findNoteByIds(@Param("charactersheetid") int charactersheetid, @Param("notesid") int notesid);



}
