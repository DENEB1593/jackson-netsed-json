package io.study.deneb.payload.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.payload.config.TestConfig;
import io.study.deneb.payload.content.imple.AtContent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.SoftAssertions.assertSoftly;


class AtContentTest {

  private ObjectMapper om;

  @BeforeEach
  void set() {
    om = TestConfig.objectMapper();
  }

  @Test
  void serializeAtButton() throws Exception {
    AtContent.Button button = ContentMock.AT_COTNENT_BUTTON;

    String result = om.writeValueAsString(button);

    assertSoftly(bundle ->{
      bundle.assertThat(result).isNotNull();
      bundle.assertThat(result.contains("scheme_android")).isTrue();
      bundle.assertThat(result.contains("scheme_ios")).isTrue();
      bundle.assertThat(result.contains("url_pc")).isFalse();
      bundle.assertThat(result.contains("url_mobile")).isFalse();
      bundle.assertAll();
    });
  }

  @Test
  void serializeAtContent() throws Exception {
    AtContent.Button button = ContentMock.AT_COTNENT_BUTTON;
    AtContent content = AtContent.builder()
        .senderkey("12345")
        .templatecode("template")
        .message("메세지 내용")
        .button(List.of(button))
        .build();


    String result = om.writeValueAsString(content);

    assertSoftly(bundle -> {
      bundle.assertThat(result).isNotNull();
      bundle.assertThat(result.contains("senderkey")).isTrue();
      bundle.assertThat(result.contains("templatecode")).isTrue();
      bundle.assertThat(result.contains("message")).isTrue();
      bundle.assertAll();
    });
  }

}