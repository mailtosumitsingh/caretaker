
package org.rinky.digitalassistant.bot.japyter.gen;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "source",
    "data",
    "metadata"
})
public class DisplayData
    extends Broadcast
{

    @JsonProperty("source")
    private String source;
    @JsonProperty("data")
    private Data data;
    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The source
     */
    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    public DisplayData withSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public Data getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    public void setData(Data data) {
        this.data = data;
    }

    public DisplayData withData(Data data) {
        this.data = data;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    public DisplayData withMetadata(Metadata_ metadata) {
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

    public DisplayData withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(source).append(data).append(metadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DisplayData) == false) {
            return false;
        }
        DisplayData rhs = ((DisplayData) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(source, rhs.source).append(data, rhs.data).append(metadata, rhs.metadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
