package com.sysware.cloud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ATHLETE")
public class Athlete {

    @Id
    @Column(name = "ID")
    private String id;

    //运动员
    @Column(name = "NAME")
    private String name;
    //性别 0男1女
    @Column(name = "GENDER")
    private Integer gender;
    //年龄(岁)
    @Column(name = "AGE")
    private Integer age;
    //代表单位
    @Column(name = "BEHALF_UNIT")
    private String behalf_unit;
    //第几次参加冬奥会
    @Column(name = "PARTICIPANT_COUNT")
    private Integer participant_count;
    //从什么项目跨选到本项
    @Column(name = "FROM_ITEM")
    private String from_item;
    //从事本项目几年
    @Column(name = "ENGAGE_YEAR")
    private Integer engage_year;
    //现执教教练
    @Column(name = "CURRENT_COACH")
    private String current_coach;
    //之前执教教练(选填)
    @Column(name = "PRE_COACH")
    private String pre_coach;


    //个人成绩信息
    //年度各单项最好成绩名次
    @Column(name = "HIGHEST_RANK")
    private Integer highest_rank;
    //最近一次世锦赛各单项名次
    @Column(name = "LATEST_WORLD_RANK")
    private Integer latest_world_rank;
    //2016-17年度排名
    @Column(name = "YEARLY_RANK")
    private Integer yearly_rank;

    //个人信息
    //项目
    @Column(name = "ITEM")
    private String item;

}
