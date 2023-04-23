package io.study.deneb.payload.content.imple;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.study.deneb.payload.content.Content;
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
