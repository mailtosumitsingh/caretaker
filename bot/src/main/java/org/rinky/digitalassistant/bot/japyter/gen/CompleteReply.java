
package org.rinky.digitalassistant.bot.japyter.gen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "status",
    "matches",
    "cursor_start",
    "cursor_end",
    "metadata"
})
public class CompleteReply
    extends Reply
{

    @JsonProperty("status")
    private CompleteReply.Status status;
    @JsonProperty("matches")
    private List<String> matches = new ArrayList<String>();
    @JsonProperty("cursor_start")
    private Integer cursorStart;
    @JsonProperty("cursor_end")
    private Integer cursorEnd;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public CompleteReply.Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(CompleteReply.Status status) {
        this.status = status;
    }

    public CompleteReply withStatus(CompleteReply.Status status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The matches
     */
    @JsonProperty("matches")
    public List<String> getMatches() {
        return matches;
    }

    /**
     * 
     * @param matches
     *     The matches
     */
    @JsonProperty("matches")
    public void setMatches(List<String> matches) {
        this.matches = matches;
    }

    public CompleteReply withMatches(List<String> matches) {
        this.matches = matches;
        return this;
    }

    /**
     * 
     * @return
     *     The cursorStart
     */
    @JsonProperty("cursor_start")
    public Integer getCursorStart() {
        return cursorStart;
    }

    /**
     * 
     * @param cursorStart
     *     The cursor_start
     */
    @JsonProperty("cursor_start")
    public void setCursorStart(Integer cursorStart) {
        this.cursorStart = cursorStart;
    }

    public CompleteReply withCursorStart(Integer cursorStart) {
        this.cursorStart = cursorStart;
        return this;
    }

    /**
     * 
     * @return
     *     The cursorEnd
     */
    @JsonProperty("cursor_end")
    public Integer getCursorEnd() {
        return cursorEnd;
    }

    /**
     * 
     * @param cursorEnd
     *     The cursor_end
     */
    @JsonProperty("cursor_end")
    public void setCursorEnd(Integer cursorEnd) {
        this.cursorEnd = cursorEnd;
    }

    public CompleteReply withCursorEnd(Integer cursorEnd) {
        this.cursorEnd = cursorEnd;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public CompleteReply withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public CompleteReply withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(status).append(matches).append(cursorStart).append(cursorEnd).append(metadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CompleteReply) == false) {
            return false;
        }
        CompleteReply rhs = ((CompleteReply) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(status, rhs.status).append(matches, rhs.matches).append(cursorStart, rhs.cursorStart).append(cursorEnd, rhs.cursorEnd).append(metadata, rhs.metadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        OK("ok"),
        ERROR("error");
        private final String value;
        private static Map<String, CompleteReply.Status> constants = new HashMap<String, CompleteReply.Status>();

        static {
            for (CompleteReply.Status c: values()) {
                constants.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static CompleteReply.Status fromValue(String value) {
            CompleteReply.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
