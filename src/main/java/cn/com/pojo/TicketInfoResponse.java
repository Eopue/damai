package cn.com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type TICKET_INFO_URL.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class TicketInfoResponse extends BaseResponse {
    @JsonProperty("Data")
    private TicketInfo data;

    public TicketInfo getData() {
        return data;
    }

    public void setData(TicketInfo data) {
        this.data = data;
    }
}
