
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
    "execution_count",
    "data",
    "metadata"
})
public class ExecuteResult
    extends Broadcast
{

    @JsonProperty("execution_count")
    private Integer executionCount;
    @JsonProperty("data")
    private Data_ data;
    @JsonProperty("metadata")
    private Metadata__ metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The executionCount
     */
    @JsonProperty("execution_count")
    public Integer getExecutionCount() {
        return executionCount;
    }

    /**
     * 
     * @param executionCount
     *     The execution_count
     */
    @JsonProperty("execution_count")
    public void setExecutionCount(Integer executionCount) {
        this.executionCount = executionCount;
    }

    public ExecuteResult withExecutionCount(Integer executionCount) {
        this.executionCount = executionCount;
        return this;
    }

    /**
     * 
     * @return
     *     The data
     */
    @JsonProperty("data")
    public Data_ getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    @JsonProperty("data")
    public void setData(Data_ data) {
        this.data = data;
    }

    public ExecuteResult withData(Data_ data) {
        this.data = data;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata__ getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata__ metadata) {
        this.metadata = metadata;
    }

    public ExecuteResult withMetadata(Metadata__ metadata) {
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

    public ExecuteResult withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(executionCount).append(data).append(metadata).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ExecuteResult) == false) {
            return false;
        }
        ExecuteResult rhs = ((ExecuteResult) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(executionCount, rhs.executionCount).append(data, rhs.data).append(metadata, rhs.metadata).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
