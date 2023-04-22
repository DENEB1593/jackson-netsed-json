package io.study.deneb.payload.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LmsContent implements Content {
  private String subject;
  private String message;
}
