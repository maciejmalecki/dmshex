package dmshex.preparation.adapters.out.db;

import dmshex.preparation.Revision;
import dmshex.preparation.usecase.port.SaveRevisionPort;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SaveRevisionAdapter implements SaveRevisionPort {

    private final RevisionRepository revisionRepository;

    @Override
    public long saveRevision(@NonNull Revision revision) {
        final var savedRevision = revisionRepository.save(revision);
        return savedRevision.getId();
    }
}
