
package org.rinky.digitalassistant.bot.japyter.gen;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "keys"
})
public class DataPub
    extends Broadcast
{

    @JsonProperty("keys")
    @JsonDeserialize(as = java.util.LinkedHashSet.class)
    private Set<String> keys = new LinkedHashSet<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The keys
     */
    @JsonProperty("keys")
    public Set<String> getKeys() {
        return keys;
    }

    /**
     * 
     * @param keys
     *     The keys
     */
    @JsonProperty("keys")
    public void setKeys(Set<String> keys) {
        this.keys = keys;
    }

    public DataPub withKeys(Set<String> keys) {
        this.keys = keys;
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

    public DataPub withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(keys).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DataPub) == false) {
            return false;
        }
        DataPub rhs = ((DataPub) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(keys, rhs.keys).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
