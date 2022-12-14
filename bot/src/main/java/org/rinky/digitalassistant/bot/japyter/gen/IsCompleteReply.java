
package org.rinky.digitalassistant.bot.japyter.gen;

import java.util.HashMap;
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
    "indent"
})
public class IsCompleteReply
    extends Reply
{

    @JsonProperty("status")
    private IsCompleteReply.Status status;
    @JsonProperty("indent")
    private String indent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public IsCompleteReply.Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(IsCompleteReply.Status status) {
        this.status = status;
    }

    public IsCompleteReply withStatus(IsCompleteReply.Status status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The indent
     */
    @JsonProperty("indent")
    public String getIndent() {
        return indent;
    }

    /**
     * 
     * @param indent
     *     The indent
     */
    @JsonProperty("indent")
    public void setIndent(String indent) {
        this.indent = indent;
    }

    public IsCompleteReply withIndent(String indent) {
        this.indent = indent;
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

    public IsCompleteReply withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(status).append(indent).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof IsCompleteReply) == false) {
            return false;
        }
        IsCompleteReply rhs = ((IsCompleteReply) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(status, rhs.status).append(indent, rhs.indent).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        COMPLETE("complete"),
        INCOMPLETE("incomplete"),
        INVALID("invalid"),
        UNKNOWN("unknown");
        private final String value;
        private static Map<String, IsCompleteReply.Status> constants = new HashMap<String, IsCompleteReply.Status>();

        static {
            for (IsCompleteReply.Status c: values()) {
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
        public static IsCompleteReply.Status fromValue(String value) {
            IsCompleteReply.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
