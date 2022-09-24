package dmshex.preparation.usecases.port;

import dmshex.preparation.Revision;

public interface SaveRevisionPort {
    long saveRevision(Revision revision);
}
