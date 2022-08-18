
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
    "restart"
})
public class ShutdownRequest
    extends Request
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("restart")
    private Boolean restart;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The restart
     */
    @JsonProperty("restart")
    public Boolean getRestart() {
        return restart;
    }

    /**
     * 
     * (Required)
     * 
     * @param restart
     *     The restart
     */
    @JsonProperty("restart")
    public void setRestart(Boolean restart) {
        this.restart = restart;
    }

    public ShutdownRequest withRestart(Boolean restart) {
        this.restart = restart;
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

    public ShutdownRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(restart).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ShutdownRequest) == false) {
            return false;
        }
        ShutdownRequest rhs = ((ShutdownRequest) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(restart, rhs.restart).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
