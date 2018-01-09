package com.sysware.cloud.vo;

import lombok.Data;

import javax.persistence.Column;

@Data
public class HealthVo {
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
    //行踪信息(1-2月,列时间段,地点)
    private String period_location;

    //备战状态
    //难度技术
    private String tough_skill;
    //突破口
    private String breakthrough;
    //训练需求
    private String train_need;
    //训练积极程度(动态) 10分为满分
    private Integer positive_degree;

    //伤病状态
    //陈旧伤病部位及症状描述,用药情况
    private String old_injury;
    //新伤病及部位及症状描述,用药情况
    private String new_injury;
    //伤病级数(1-5)轻,较轻,重度,较严重,很严重
    private String injury_degree;
    //治疗需求
    private String treatment_need;

    //恢复状态
    //睡眠状态（动态）好、较好、一般、差、很差以及其他描述
    private Integer sleep;
    //饮食状态（动态）好、较好、一般、差、很差以及其他描述
    private Integer diet;
    //疲劳状态（动态）好、较好、一般、差、很差以及其他描述
    private Integer tiredness;
    //伤病状态（动态）好、较好、一般、差、很差以及其他描述
    private Integer injury;
    //情绪状态（动态）好、较好、一般、差、很差以及其他描述
    private Integer mood;
    //恢复需求（动态）
    private String recover_need;


    //主要对手（列项目、人名、国家）
    private String opponent;
}
