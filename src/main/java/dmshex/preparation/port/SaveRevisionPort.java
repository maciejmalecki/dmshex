package dmshex.preparation.port;

import dmshex.preparation.Revision;

public interface SaveRevisionPort {
    Long saveRevision(Revision revision);
}
