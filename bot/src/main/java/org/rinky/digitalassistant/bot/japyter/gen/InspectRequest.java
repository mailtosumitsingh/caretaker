
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
    "code",
    "cursor_pos",
    "detail_level"
})
public class InspectRequest
    extends Request
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("code")
    private String code;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("cursor_pos")
    private Integer cursorPos;
    @JsonProperty("detail_level")
    private Integer detailLevel = 0;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     * @return
     *     The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * (Required)
     * 
     * @param code
     *     The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public InspectRequest withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     * @return
     *     The cursorPos
     */
    @JsonProperty("cursor_pos")
    public Integer getCursorPos() {
        return cursorPos;
    }

    /**
     * 
     * (Required)
     * 
     * @param cursorPos
     *     The cursor_pos
     */
    @JsonProperty("cursor_pos")
    public void setCursorPos(Integer cursorPos) {
        this.cursorPos = cursorPos;
    }

    public InspectRequest withCursorPos(Integer cursorPos) {
        this.cursorPos = cursorPos;
        return this;
    }

    /**
     * 
     * @return
     *     The detailLevel
     */
    @JsonProperty("detail_level")
    public Integer getDetailLevel() {
        return detailLevel;
    }

    /**
     * 
     * @param detailLevel
     *     The detail_level
     */
    @JsonProperty("detail_level")
    public void setDetailLevel(Integer detailLevel) {
        this.detailLevel = detailLevel;
    }

    public InspectRequest withDetailLevel(Integer detailLevel) {
        this.detailLevel = detailLevel;
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

    public InspectRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(code).append(cursorPos).append(detailLevel).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InspectRequest) == false) {
            return false;
        }
        InspectRequest rhs = ((InspectRequest) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(code, rhs.code).append(cursorPos, rhs.cursorPos).append(detailLevel, rhs.detailLevel).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
