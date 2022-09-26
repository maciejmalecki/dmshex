package dmshex.preparation.adapters.in.web;

import dmshex.preparation.api.CreateRevisionCommand;
import dmshex.preparation.api.RevisionQueryModel;
import dmshex.preparation.usecase.CreateRevisionUseCase;
import dmshex.preparation.usecase.QueryRevisionByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RevisionRestController {
    private final CreateRevisionUseCase createRevisionUseCase;
    private final QueryRevisionByIdUseCase queryRevisionByIdUseCase;

    @GetMapping("/revisions")
    public List<RevisionQueryModel> getRevisions() {
        return new ArrayList<>();
    }

    @PostMapping("/revisions")
    public ResponseEntity<String> createRevision(@RequestBody CreateRevisionCommand command) {
        final var revisionId = createRevisionUseCase.apply(command);
        return new ResponseEntity<>(String.valueOf(revisionId), HttpStatus.CREATED);
    }

    @GetMapping("/revisions/{revisionId}")
    public RevisionQueryModel getRevision(@PathVariable Long revisionId) {
        return Optional.ofNullable(revisionId)
                .flatMap(queryRevisionByIdUseCase::queryBy)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
