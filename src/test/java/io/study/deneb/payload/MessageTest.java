package io.study.deneb.payload;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.payload.config.TestConfig;
import io.study.deneb.payload.content.ContentMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;


class MessageTest {

  private ObjectMapper om;

  @BeforeEach
  void setUp() {
    om = TestConfig.objectMapper();
  }

  @Test
  void serializeMessageIncludeAtContent() throws Exception {
    Message message = givenContentIncludeAtContent();

    String result = om.writeValueAsString(message);

    assertSoftly(bundle -> {
      bundle.assertThat(result).isNotNull();
      bundle.assertThat(result.contains("senderkey")).isTrue();
      bundle.assertThat(result.contains("templatecode")).isTrue();
      bundle.assertThat(result.contains("message")).isTrue();
      bundle.assertAll();
    });
  }



  @Test
  void serializeMessageIncludeLmsContent() throws Exception {
    Message message = givenContentIncludeLmsContent();

    String result = om.writeValueAsString(message);

    assertSoftly(bundle -> {
      bundle.assertThat(result.contains("LMS subject")).isTrue();
      bundle.assertThat(result.contains("LMS message")).isTrue();
    });
  }

  static Message givenContentIncludeLmsContent() {
    return Message.builder()
        .account("test")
        .to("01012341234")
        .type("lms")
        .content(ContentMock.LMS_CONTENT)
        .build();
  }

  static Message givenContentIncludeAtContent() {
    return Message.builder()
        .account("test")
        .to("01012341234")
        .type("lms")
        .content(ContentMock.AT_CONTENT)
        .build();
  }



}