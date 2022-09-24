package dmshex.preparation;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
public class Revision {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    private RevisionStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Document document;

    public void lock() {
        if (status != RevisionStatus.EDITABLE) {
            throw new RevisionNotEditableException(id, status);
        }
        status = RevisionStatus.LOCKED;
    }

    public static Revision createNew(@NonNull String title, @NonNull String content) {
        final var revision = new Revision();
        revision.content = content;
        revision.status = RevisionStatus.EDITABLE;
        revision.document = Document.createNew(title);
        return revision;
    }
}
