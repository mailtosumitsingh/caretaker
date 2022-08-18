
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
    "prompt",
    "password"
})
public class InputRequest
    extends Request
{

    @JsonProperty("prompt")
    private String prompt;
    @JsonProperty("password")
    private Boolean password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The prompt
     */
    @JsonProperty("prompt")
    public String getPrompt() {
        return prompt;
    }

    /**
     * 
     * @param prompt
     *     The prompt
     */
    @JsonProperty("prompt")
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public InputRequest withPrompt(String prompt) {
        this.prompt = prompt;
        return this;
    }

    /**
     * 
     * @return
     *     The password
     */
    @JsonProperty("password")
    public Boolean getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    @JsonProperty("password")
    public void setPassword(Boolean password) {
        this.password = password;
    }

    public InputRequest withPassword(Boolean password) {
        this.password = password;
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

    public InputRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(prompt).append(password).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InputRequest) == false) {
            return false;
        }
        InputRequest rhs = ((InputRequest) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(prompt, rhs.prompt).append(password, rhs.password).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
