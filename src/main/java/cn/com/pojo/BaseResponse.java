package cn.com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type BaseResponse.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class BaseResponse {
    @JsonProperty("Status")
    private Integer status;

    @JsonProperty("Message")
    private Integer message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getMessage() {
        return message;
    }

    public void setMessage(Integer message) {
        this.message = message;
    }
}
