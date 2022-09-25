package dmshex.preparation.usecase;

import dmshex.preparation.Revision;
import dmshex.preparation.api.CreateRevisionCommand;
import dmshex.preparation.usecase.port.SaveRevisionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRevisionUseCase {

    private final SaveRevisionPort saveRevisionPort;

    public long apply(CreateRevisionCommand command) {
        final var revision = Revision.createNew(command.getTitle(), command.getContent());
        return saveRevisionPort.saveRevision(revision);
    }
}
