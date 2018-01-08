package com.sysware.cloud.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AthleteVo {
    //个人信息
    //项目
    private String item;
    //运动员
    private String name;
    //性别
    private String gender;
    //年龄(岁)
    private Integer age;
    //代表单位
    private String behalf_unit;
    //第几次参加冬奥会
    private Integer participant_count;
    //从什么项目跨选到本项
    private String from_item;
    //从事本项目几年
    private Integer engage_year;
    //现执教教练
    private String current_coach;
    //之前执教教练(选填)
    private String pre_coach;


    //个人成绩信息
    //年度各单项最好成绩名次
    private Integer highest_rank;
    //最近一次世锦赛各单项名次
    private Integer latest_world_rank;
    //2016-17年度排名
    private Integer yearly_rank;

}
