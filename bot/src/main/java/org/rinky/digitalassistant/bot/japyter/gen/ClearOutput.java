
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
    "wait"
})
public class ClearOutput
    extends Broadcast
{

    @JsonProperty("wait")
    private Boolean wait;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The wait
     */
    @JsonProperty("wait")
    public Boolean getWait() {
        return wait;
    }

    /**
     * 
     * @param wait
     *     The wait
     */
    @JsonProperty("wait")
    public void setWait(Boolean wait) {
        this.wait = wait;
    }

    public ClearOutput withWait(Boolean wait) {
        this.wait = wait;
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

    public ClearOutput withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(wait).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClearOutput) == false) {
            return false;
        }
        ClearOutput rhs = ((ClearOutput) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(wait, rhs.wait).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
