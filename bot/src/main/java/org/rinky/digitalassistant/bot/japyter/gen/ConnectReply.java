
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
    "control",
    "hb",
    "shell",
    "iopub",
    "stdin"
})
public class ConnectReply
    extends Reply
{

    @JsonProperty("control")
    private Integer control;
    @JsonProperty("hb")
    private Integer hb;
    @JsonProperty("shell")
    private Integer shell;
    @JsonProperty("iopub")
    private Integer iopub;
    @JsonProperty("stdin")
    private Integer stdin;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The control
     */
    @JsonProperty("control")
    public Integer getControl() {
        return control;
    }

    /**
     * 
     * @param control
     *     The control
     */
    @JsonProperty("control")
    public void setControl(Integer control) {
        this.control = control;
    }

    public ConnectReply withControl(Integer control) {
        this.control = control;
        return this;
    }

    /**
     * 
     * @return
     *     The hb
     */
    @JsonProperty("hb")
    public Integer getHb() {
        return hb;
    }

    /**
     * 
     * @param hb
     *     The hb
     */
    @JsonProperty("hb")
    public void setHb(Integer hb) {
        this.hb = hb;
    }

    public ConnectReply withHb(Integer hb) {
        this.hb = hb;
        return this;
    }

    /**
     * 
     * @return
     *     The shell
     */
    @JsonProperty("shell")
    public Integer getShell() {
        return shell;
    }

    /**
     * 
     * @param shell
     *     The shell
     */
    @JsonProperty("shell")
    public void setShell(Integer shell) {
        this.shell = shell;
    }

    public ConnectReply withShell(Integer shell) {
        this.shell = shell;
        return this;
    }

    /**
     * 
     * @return
     *     The iopub
     */
    @JsonProperty("iopub")
    public Integer getIopub() {
        return iopub;
    }

    /**
     * 
     * @param iopub
     *     The iopub
     */
    @JsonProperty("iopub")
    public void setIopub(Integer iopub) {
        this.iopub = iopub;
    }

    public ConnectReply withIopub(Integer iopub) {
        this.iopub = iopub;
        return this;
    }

    /**
     * 
     * @return
     *     The stdin
     */
    @JsonProperty("stdin")
    public Integer getStdin() {
        return stdin;
    }

    /**
     * 
     * @param stdin
     *     The stdin
     */
    @JsonProperty("stdin")
    public void setStdin(Integer stdin) {
        this.stdin = stdin;
    }

    public ConnectReply withStdin(Integer stdin) {
        this.stdin = stdin;
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

    public ConnectReply withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().appendSuper(super.hashCode()).append(control).append(hb).append(shell).append(iopub).append(stdin).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ConnectReply) == false) {
            return false;
        }
        ConnectReply rhs = ((ConnectReply) other);
        return new EqualsBuilder().appendSuper(super.equals(other)).append(control, rhs.control).append(hb, rhs.hb).append(shell, rhs.shell).append(iopub, rhs.iopub).append(stdin, rhs.stdin).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
