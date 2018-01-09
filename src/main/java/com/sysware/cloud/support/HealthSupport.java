package com.sysware.cloud.support;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.dto.HealthDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.entity.Health;
import com.sysware.cloud.utils.json.ProcessCallback;
import com.sysware.cloud.utils.json.ProcessUtils;
import com.sysware.cloud.utils.uuid.UUIDUtil;
import com.sysware.cloud.vo.AthleteVo;
import com.sysware.cloud.vo.HealthVo;

/**
 * 运动员支持类
 */
public final class HealthSupport {
    /**
     * 转换运动员对象
     *
     * @param health
     * @return
     */
    public static HealthVo process(Health health) {
        return ProcessUtils.process(HealthVo.class, health, new ProcessCallback<HealthVo, Health>() {
            @Override
            public void call(HealthVo healthDto, Health health) {
//                athleteDto.setCreateTime(DateFormatUtils.format(user.getCreateTime(), constants.SIMPLE_DATA_PATTEN));
            }
        });
    }

    public static Health process(HealthDto healthDto) {
        return ProcessUtils.process(Health.class, healthDto, new ProcessCallback<Health, HealthDto>() {
            @Override
            public void call(Health health, HealthDto healthDto) {
                health.setId(UUIDUtil.getGuid());
            }
        });
    }

}
