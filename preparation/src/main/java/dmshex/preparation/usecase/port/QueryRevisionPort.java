package dmshex.preparation.usecase.port;

import dmshex.preparation.api.RevisionQueryModel;

import java.util.Optional;

public interface QueryRevisionPort {
    Optional<RevisionQueryModel> queryById(long revisionId);
}
