package com.sysware.cloud.enums;


public enum ItemEnum {

    BOBSLEIQH("1","雪车"),
    SKELETON("2","钢架雪车"),
    ALPINE_SKIING("3","高山滑雪"),
    SKI_JUMPING("4","跳台滑雪"),
    BIATHLON("5","冬季两项"),
    CROSS_COUNTRY_SKIING("6","越野滑雪"),
    SNOWBOARDING("7","单板滑雪"),
    FREE_STYLING("8","自由式滑雪"),
    CURLING("9","冰壶"),
    SPEED_SKATING("10","速滑"),
    SHORT_TRACK_SPEEDING_SKATING("11","短道"),
    FIGURE_SKATING("12","花样");

    private String id;

    private String value;

    ItemEnum(String id,String value) {
        this.value = value;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
