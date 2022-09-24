package dmshex.preparation.usecases;

import dmshex.preparation.api.RevisionQueryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QueryRevisionByIdUseCase {

    private final QueryRevisionByIdUseCase queryRevisionByIdUseCase;

    public Optional<RevisionQueryModel> queryBy(long revisionId) {
        return queryRevisionByIdUseCase.queryBy(revisionId);
    }
}
