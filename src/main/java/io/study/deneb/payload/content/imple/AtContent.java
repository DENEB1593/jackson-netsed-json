package io.study.deneb.payload.content.imple;

import com.fasterxml.jackson.annotation.*;
import io.study.deneb.payload.content.Content;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AtContent implements Content {
  private String senderkey;
  private String templatecode;
  private String message;
  private List<Button> button;

  @Data
  @Builder
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public static class Button {
    private String name;
    private String type;
    private String url_pc;
    private String url_mobile;
    private String scheme_android;
    private String scheme_ios;
  }
}
