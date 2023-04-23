package io.study.deneb.payload.content.imple;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.study.deneb.payload.content.Content;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SmsContent implements Content {
  private String message;
}
