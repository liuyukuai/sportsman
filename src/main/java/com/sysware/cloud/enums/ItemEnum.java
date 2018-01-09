package com.sysware.cloud.enums;


public enum ItemEnum {

    BOBSLEIQH("雪车"),
    SKELETON("钢架雪车"),
    ALPINE_SKIING("高山滑雪"),
    SKI_JUMPING("跳台滑雪"),
    BIATHLON("冬季两项"),
    CROSS_COUNTRY_SKIING("越野滑雪"),
    SNOWBOARDING("单板滑雪"),
    FREESTYLING("自由式滑雪"),
    CURLING("冰壶"),
    SPEED_SKATING("速滑"),
    SHORT_TRACK_SPEEDING_SKATING("短道"),
    FIGURE_SKATING("花样"),
    ;

    private String item;

    ItemEnum(String item) {
        this.item = item;
    }


    public String getItem() {
        return item;
    }
}
