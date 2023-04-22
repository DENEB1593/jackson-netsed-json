package io.study.deneb.payload.content;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsContent implements Content {
  private String message;
}
