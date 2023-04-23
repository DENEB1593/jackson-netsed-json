package io.study.deneb.payload.content;

import io.study.deneb.payload.content.imple.AtContent;
import io.study.deneb.payload.content.imple.LmsContent;

import java.util.List;

public class ContentMock {
   public static AtContent.Button AT_COTNENT_BUTTON = AtContent.Button.builder()
          .name("button_01")
        .type("AL")
        .scheme_android("android_url")
        .scheme_ios("android_ios")
        .build();

   public static AtContent AT_CONTENT = AtContent.builder()
       .senderkey("12345")
        .templatecode("template")
        .message("메세지 내용")
        .button(List.of(AT_COTNENT_BUTTON))
       .build();

   public static LmsContent LMS_CONTENT = LmsContent.builder()
       .subject("LMS subject")
        .message("LMS message")
        .build();

}
