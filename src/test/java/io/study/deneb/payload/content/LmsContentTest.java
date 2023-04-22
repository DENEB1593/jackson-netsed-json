package io.study.deneb.payload.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.payload.config.TestConfig;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LmsContentTest {

  private ObjectMapper om;

  @BeforeEach
  void set() {
    om = TestConfig.objectMapper();
  }

  @Test
  void serializeLmsContent() throws Exception {
    LmsContent content = givenLmsContent();

    String result = om.writeValueAsString(content);

    SoftAssertions.assertSoftly(softly -> {
      softly.assertThat(result.contains("LMS subject")).isTrue();
      softly.assertThat(result.contains("LMS message")).isTrue();
    });
  }

  private static LmsContent givenLmsContent() {
    return LmsContent.builder()
        .subject("LMS subject")
        .message("LMS message")
        .build();
  }

}