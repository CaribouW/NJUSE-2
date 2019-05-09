package com.example.main.core.enums;
public enum ExceptionEnum {
    SUCCESS(200, "success"),
    PERMISSION_DENY(201,"permission denied"),
    PASSWORD_ERROR(401, "Password Error"),
    NO_SUCH_USER(402,"No such user"),
    USER_EXISTED(403, "user has already existed"),
    USER_IN(404,"user has already login"),
    USER_OUT(405, "user not login"),
    MOVIE_SCHEDULED(501,"Movie has been scheduled"),
    SCHEDULE_CONFLICT(502, "Schedule conflict"),
    SCHEDULE_MISS(503,"schedule not exist"),
    MOVIEHALL_EXISTED(504, "Moviehall has already existed"),
    MOVIEHALL_MISS(505,"Moviehall not exist"),
    VIPCARD_EXISTED(601, "VIPcard exist"),
    VIPCARD_MISS(602,"VIPcard not exist"),
    TICKETS_SOLDOUT(603, "Tickets have been sold out"),
    REFUND_DENY(604,"Refund denied"),
    REFUNDSTRATEGY_MISS(605, "Refund strategy not exist"),
    MOVIE_MISS(701,"Movie not exist");

    private Integer value;

    private String desc;

    ExceptionEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
