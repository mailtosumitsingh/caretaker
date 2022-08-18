
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
    "found",
    "data",
    "metadata"
})
public class InspectReply
    extends Reply
{

    @JsonProperty("status")
    private InspectReply.Status status;
    @JsonProperty("found")
    private Boolean found;
    @JsonProperty("data")
    private Data__ data;
    @JsonProperty("metadata")
    private Metadata___ metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public InspectReply.Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(InspectReply.Status status) {
        this.status = status;
    }

    public InspectReply withStatus(InspectReply.Status status) {
        this.status = status;
        return this;
    }

    /**
     * 
     * @return
     *     The found
     */
    @JsonProperty("found")
    public Boolean getFound() {
        return found;
    }

    /**
     * 
     * @param found
     *     The found
     */
    @JsonProperty("found")
    public void setFound(Boolean found) {
        this.found = found;
    }

    public InspectReply withFound(Boolean found) {
        this.found = found;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public Data__ getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    public void setData(Data__ data) {
        this.data = data;
    }

    public InspectReply withData(Data__ data) {
        this.data = data;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata___ getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata___ metadata) {
        this.metadata = metadata;
    }

    public InspectReply withMetadata(Metadata___ metadata) {
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

    public InspectReply withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(status).append(found).append(data).append(metadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InspectReply) == false) {
            return false;
        }
        InspectReply rhs = ((InspectReply) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(status, rhs.status).append(found, rhs.found).append(data, rhs.data).append(metadata, rhs.metadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

    @Generated("org.jsonschema2pojo")
    public static enum Status {

        OK("ok"),
        ERROR("error");
        private final String value;
        private static Map<String, InspectReply.Status> constants = new HashMap<String, InspectReply.Status>();

        static {
            for (InspectReply.Status c: values()) {
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
        public static InspectReply.Status fromValue(String value) {
            InspectReply.Status constant = constants.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
