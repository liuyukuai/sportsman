package com.sysware.cloud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="SPORTS_MAN")
public class Sportsman {

    @Id
    @Column(name = "ID")
    private String id;

    //个人信息
    //项目
    @Column(name = "ITEM")
    private String item;
    //运动员
    @Column(name = "NAME")
    private String name;
    //性别
    @Column(name = "GENDER")
    private String gender;
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
    @Column(name = "FROM_EVENT")
    private String from_event;
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

    //行踪信息(1-2月,列时间段,地点)
    @Column(name = "PERIOD_LOCATION")
    private String period_location;

    //备战状态
    //难度技术
    @Column(name = "TOUGH_SKILL")
    private String tough_skill;
    //突破口
    @Column(name = "BREAKTHROUGH")
    private String breakthrough;
    //训练需求
    @Column(name = "TRAIN_NEED")
    private String train_need;
    //训练积极程度(动态) 10分为满分
    @Column(name = "POSITIVE_DEGREE")
    private Integer positive_degree;

    //伤病状态
    //陈旧伤病部位及症状描述,用药情况
    @Column(name = "OLD_INJURY")
    private String old_injury;
    //新伤病及部位及症状描述,用药情况
    @Column(name = "NEW_INJURY")
    private String new_injury;
    //伤病级数(1-5)轻,较轻,重度,较严重,很严重
    @Column(name = "INJURY_DEGREE")
    private String injury_degree;
    //治疗需求
    @Column(name = "TREATMENT_NEED")
    private String treatment_need;

    //恢复状态
    //睡眠状态（动态）好、较好、一般、差、很差以及其他描述
    @Column(name = "SLEEP")
    private Integer sleep;
    //饮食状态（动态）好、较好、一般、差、很差以及其他描述
    @Column(name = "DIET")
    private Integer diet;
    //疲劳状态（动态）好、较好、一般、差、很差以及其他描述
    @Column(name = "TIREDNESS")
    private Integer tiredness;
    //伤病状态（动态）好、较好、一般、差、很差以及其他描述
    @Column(name = "INJURY")
    private Integer injury;
    //情绪状态（动态）好、较好、一般、差、很差以及其他描述
    @Column(name = "MOOD")
    private Integer mood;
    //恢复需求（动态）
    @Column(name = "RECOVER_NEED")
    private String recover_need;


    //主要对手（列项目、人名、国家）
    @Column(name = "OPPONENT")
    private String opponent;
}
