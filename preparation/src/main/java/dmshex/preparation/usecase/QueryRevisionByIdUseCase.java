package dmshex.preparation.usecase;

import dmshex.preparation.api.RevisionQueryModel;
import dmshex.preparation.usecase.port.QueryRevisionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryRevisionByIdUseCase {

    private final QueryRevisionPort queryRevisionPort;

    public Optional<RevisionQueryModel> queryBy(long revisionId) {
        return queryRevisionPort.queryById(revisionId);
    }
}
