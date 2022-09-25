package dmshex.preparation.usecase.port;

import dmshex.preparation.Revision;

public interface SaveRevisionPort {
    long saveRevision(Revision revision);
}
