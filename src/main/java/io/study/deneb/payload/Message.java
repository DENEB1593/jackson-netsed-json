package io.study.deneb.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.study.deneb.payload.content.Content;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Message {
  private String account;
  private String refkey;
  private String type;
  private String from;
  private String to;

  private Content content;


}
