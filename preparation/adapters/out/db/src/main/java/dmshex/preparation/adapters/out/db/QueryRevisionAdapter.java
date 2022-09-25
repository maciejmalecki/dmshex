package dmshex.preparation.adapters.out.db;

import dmshex.preparation.api.RevisionQueryModel;
import dmshex.preparation.usecase.port.QueryRevisionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class QueryRevisionAdapter implements QueryRevisionPort {

    private final RevisionRepository revisionRepository;

    @Override
    public Optional<RevisionQueryModel> queryById(long revisionId) {
        final var revisions = revisionRepository.queryById(revisionId);
        return revisions.isEmpty() ? Optional.empty() : Optional.of(revisions.get(0));
    }
}
