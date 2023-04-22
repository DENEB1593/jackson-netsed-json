package io.study.deneb.payload.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.payload.config.TestConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class AtContentTest {

  private ObjectMapper om;

  @BeforeEach
  void set() {
    om = TestConfig.objectMapper();
  }

  @Test
  void serializeAtButton() throws Exception {
    AtContent.Button button = givenAtButton();

    String result = om.writeValueAsString(button);

    SoftAssertions assertions = new SoftAssertions();
    assertions.assertThat(result).isNotNull();
    assertions.assertThat(result.contains("scheme_android")).isTrue();
    assertions.assertThat(result.contains("scheme_ios")).isTrue();
    assertions.assertThat(result.contains("url_pc")).isFalse();
    assertions.assertThat(result.contains("url_mobile")).isFalse();
    assertions.assertAll();
  }

  @Test
  void serializeAtContent() throws Exception {
    AtContent.Button button = givenAtButton();
    AtContent content = AtContent.builder()
        .senderkey("12345")
        .templatecode("template")
        .message("메세지 내용")
        .button(List.of(button))
        .build();


    String result = om.writeValueAsString(content);


    SoftAssertions assertions = new SoftAssertions();
    assertions.assertThat(result).isNotNull();
    assertions.assertThat(result.contains("senderkey")).isTrue();
    assertions.assertThat(result.contains("templatecode")).isTrue();
    assertions.assertThat(result.contains("message")).isTrue();
    assertions.assertAll();
  }

  private static AtContent.Button givenAtButton() {
    return AtContent.Button.builder()
        .name("button_01")
        .type("AL")
        .scheme_android("android_url")
        .scheme_ios("android_ios")
        .build();
  }

}