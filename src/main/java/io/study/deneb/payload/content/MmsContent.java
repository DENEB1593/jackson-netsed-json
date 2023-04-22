package io.study.deneb.payload.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MmsContent implements Content {
  private String subject;
  private String message;
  private List<File> file;

  @Data
  @Builder
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class File {
    private String type;
    private String key;
  }
}
