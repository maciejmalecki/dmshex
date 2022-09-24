package dmshex.preparation.api;

import lombok.Data;

@Data
public class CreateRevisionCommand {
    private String title;
    private String content;
}
