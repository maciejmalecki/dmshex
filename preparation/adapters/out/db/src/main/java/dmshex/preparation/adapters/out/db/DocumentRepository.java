package dmshex.preparation.adapters.out.db;

import dmshex.preparation.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}
