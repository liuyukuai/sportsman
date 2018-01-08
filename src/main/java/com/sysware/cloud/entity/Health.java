package com.sysware.cloud.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="HEALTH")
public class Health {

    @Id
    @Column(name = "ID")
    private String id;

    //项目
    @Column(name = "ITEM")
    private String item;
    //运动员
    @Column(name = "NAME")
    private String name;
    //性别 0男1女
    @Column(name = "GENDER")
    private Integer gender;
    //代表单位
    @Column(name = "BEHALF_UNIT")
    private String behalf_unit;

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
