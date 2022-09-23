package dmshex.preparation;

import dmshex.preparation.port.SaveRevisionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateRevisionUseCase {

    private final SaveRevisionPort saveRevisionPort;
}
