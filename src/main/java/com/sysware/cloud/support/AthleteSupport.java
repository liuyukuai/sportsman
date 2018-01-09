package com.sysware.cloud.support;

import com.sysware.cloud.dto.AthleteDto;
import com.sysware.cloud.entity.Athlete;
import com.sysware.cloud.utils.json.ProcessCallback;
import com.sysware.cloud.utils.json.ProcessUtils;
import com.sysware.cloud.utils.md5.Md5Util;
import com.sysware.cloud.utils.uuid.UUIDUtil;
import com.sysware.cloud.vo.AthleteVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 运动员支持类
 */
public final class AthleteSupport {
    /**
     * 转换运动员对象
     *
     * @param athlete
     * @return
     */
    public static AthleteVo process(Athlete athlete) {
        return ProcessUtils.process(AthleteVo.class, athlete, new ProcessCallback<AthleteVo, Athlete>() {
            @Override
            public void call(AthleteVo athleteDto, Athlete athlete) {
//                athleteDto.setCreateTime(DateFormatUtils.format(user.getCreateTime(), constants.SIMPLE_DATA_PATTEN));
            }
        });
    }

    public static Athlete process(AthleteDto athleteDto) {
        return ProcessUtils.process(Athlete.class, athleteDto, new ProcessCallback<Athlete, AthleteDto>() {
            @Override
            public void call(Athlete athlete, AthleteDto userDto) {
                athlete.setId(UUIDUtil.getGuid());
            }
        });
    }

}
