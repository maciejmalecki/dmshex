package dmshex.preparation.adapters.out.db;

import dmshex.preparation.Revision;
import dmshex.preparation.api.RevisionQueryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
    @Query("SELECT new dmshex.preparation.api.RevisionQueryModel(rev.id, doc.id, doc.title, rev.content) " +
            "FROM Revision rev " +
            "JOIN rev.document doc " +
            "WHERE rev.id = :id")
    List<RevisionQueryModel> queryById(@Param("id") Long id);
}
