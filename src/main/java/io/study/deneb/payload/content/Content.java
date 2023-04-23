package io.study.deneb.payload.content;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AtContent.class, name = "at"),
    @JsonSubTypes.Type(value = LmsContent.class, name = "lms")
})
public interface Content {
}
