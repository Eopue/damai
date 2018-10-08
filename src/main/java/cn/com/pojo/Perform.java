package cn.com.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Perform.
 * <p>
 *
 * @author Xiaolu.Liu
 * @date 2018/10/7
 */
public class Perform {
    @JsonProperty("ProjectID")
    private Integer projectId;

    @JsonProperty("PerformID")
    private Integer performId;

    @JsonProperty("StartTime")
    private String startTime;

    @JsonProperty("PerformName")
    private String performName;

    @JsonProperty("MaxBuyCount")
    private Integer maxBuyCount;

    @JsonProperty("ShowDate")
    private String showDate;

    @JsonProperty("ShowTime")
    private String showTime;

    @JsonProperty("ShowWeekday")
    private String showWeekday;

    @JsonProperty("SeatBuyNum")
    private Integer seatBuyNum;

    @JsonProperty("Status")
    private Boolean status;

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getPerformId() {
        return performId;
    }

    public void setPerformId(Integer performId) {
        this.performId = performId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPerformName() {
        return performName;
    }

    public void setPerformName(String performName) {
        this.performName = performName;
    }

    public Integer getMaxBuyCount() {
        return maxBuyCount;
    }

    public void setMaxBuyCount(Integer maxBuyCount) {
        this.maxBuyCount = maxBuyCount;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getShowWeekday() {
        return showWeekday;
    }

    public void setShowWeekday(String showWeekday) {
        this.showWeekday = showWeekday;
    }

    public Integer getSeatBuyNum() {
        return seatBuyNum;
    }

    public void setSeatBuyNum(Integer seatBuyNum) {
        this.seatBuyNum = seatBuyNum;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
