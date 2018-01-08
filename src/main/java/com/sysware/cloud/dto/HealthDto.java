package com.sysware.cloud.dto;

import org.hibernate.validator.constraints.NotEmpty;

public class HealthDto {
    //项目
    @NotEmpty(message = "项目不能为空")
    private String item;
    //运动员
    @NotEmpty(message = "姓名不能为空")
    private String name;
    //性别
    @NotEmpty(message = "性别不能为空")
    private Integer gender;
    //代表单位
    @NotEmpty(message = "代表单位不能为空")
    private String behalf_unit;

    //行踪信息(1-2月,列时间段,地点)
    @NotEmpty(message = "行踪信息(1-2月,列时间段,地点)不能为空")
    private String period_location;

    //备战状态
    //难度技术
    @NotEmpty(message = "难度技术不能为空")
    private String tough_skill;
    //突破口
    @NotEmpty(message = "突破口不能为空")
    private String breakthrough;
    //训练需求
    @NotEmpty(message = "训练需求不能为空")
    private String train_need;
    //训练积极程度(动态) 10分为满分
    @NotEmpty(message = "训练积极程度不能为空")
    private Integer positive_degree;

    //伤病状态
    //陈旧伤病部位及症状描述,用药情况
    @NotEmpty(message = "陈旧伤病部位及症状描述,用药情况不能为空")
    private String old_injury;
    //新伤病及部位及症状描述,用药情况
    @NotEmpty(message = "新伤病及部位及症状描述,用药情况不能为空")
    private String new_injury;
    //伤病级数(1-5)轻,较轻,重度,较严重,很严重
    @NotEmpty(message = "伤病级数不能为空")
    private String injury_degree;
    //治疗需求
    @NotEmpty(message = "治疗需求不能为空")
    private String treatment_need;

    //恢复状态
    //睡眠状态（动态）好、较好、一般、差、很差以及其他描述
    @NotEmpty(message = "睡眠状态不能为空")
    private Integer sleep;
    //饮食状态（动态）好、较好、一般、差、很差以及其他描述
    @NotEmpty(message = "饮食状态不能为空")
    private Integer diet;
    //疲劳状态（动态）好、较好、一般、差、很差以及其他描述
    @NotEmpty(message = "疲劳状态不能为空")
    private Integer tiredness;
    //伤病状态（动态）好、较好、一般、差、很差以及其他描述
    @NotEmpty(message = "伤病状态不能为空")
    private Integer injury;
    //情绪状态（动态）好、较好、一般、差、很差以及其他描述
    @NotEmpty(message = "情绪状态不能为空")
    private Integer mood;
    //恢复需求（动态）
    @NotEmpty(message = "恢复需求不能为空")
    private String recover_need;


    //主要对手（列项目、人名、国家）
    @NotEmpty(message = "主要对手不能为空")
    private String opponent;
}
