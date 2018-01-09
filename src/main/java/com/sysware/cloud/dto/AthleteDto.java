package com.sysware.cloud.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AthleteDto implements Serializable {

    //运动员
    @NotEmpty(message = "姓名不能为空")
    private String name;
    //性别
    @NotNull(message = "性别不能为空")
    private Integer gender;
    //年龄(岁)
    @NotNull(message = "年龄不能为空")
    private Integer age;
    //代表单位
    @NotEmpty(message = "代表单位不能为空")
    private String behalf_unit;
    //第几次参加冬奥会
    @NotNull(message = "第几次参加冬奥会不能为空")
    private Integer participant_count;
    //从什么项目跨选到本项
    @NotEmpty(message = "从什么项目跨选到本项不能为空")
    private String from_item;
    //从事本项目几年
    @NotNull(message = "从事本项目几年不能为空")
    private Integer engage_year;
    //现执教教练
    @NotEmpty(message = "现执教教练不能为空")
    private String current_coach;
    //之前执教教练(选填)
    private String pre_coach;

    //个人信息
    //项目
    @NotEmpty(message = "项目不能为空")
    private String item;

    //个人成绩信息
    //年度各单项最好成绩名次
    @NotNull(message = "年度各单项最好成绩名次不能为空")
    private Integer highest_rank;
    //最近一次世锦赛各单项名次
    @NotNull(message = "最近一次世锦赛各单项名次不能为空")
    private Integer latest_world_rank;
    //2016-17年度排名
    @NotNull(message = "2016-17年度排名不能为空")
    private Integer yearly_rank;


}
