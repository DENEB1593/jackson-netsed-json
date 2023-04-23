package io.study.deneb.payload.content;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.study.deneb.payload.config.TestConfig;
import io.study.deneb.payload.content.impl.LmsContent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

class LmsContentTest {

  private ObjectMapper om;

  @BeforeEach
  void set() {
    om = TestConfig.objectMapper();
  }

  @Test
  void serializeLmsContent() throws Exception {
    LmsContent content = ContentMock.LMS_CONTENT;

    String result = om.writeValueAsString(content);

    assertSoftly(bundle -> {
      bundle.assertThat(result.contains("LMS subject")).isTrue();
      bundle.assertThat(result.contains("LMS message")).isTrue();
    });
  }


}