package dmshex.preparation.api;

import lombok.Value;

@Value
public class RevisionQueryModel {
    long revisionId;
    long documentId;
    String title;
    String content;
}
