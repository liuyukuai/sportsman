package com.sysware.cloud.support;

import com.sysware.cloud.dto.SportsmanDto;
import com.sysware.cloud.entity.Sportsman;
import com.sysware.cloud.vo.SportsmanVo;

/**
 * 运动员支持类
 */
public final class SportsmanSupport {
    /**
     * 转换运动员对象
     *
     * @param sportsman
     * @return
     */
//    public static SportsmanVo process(Sportsman sportsman) {
//        return ProcessUtils.process(SportsmanVo.class, user, new ProcessCallback<SportsmanVo, User>() {
//            @Override
//            public void call(UserVo userDto, User user) {
//                userDto.setCreateTime(DateFormatUtils.format(user.getCreateTime(), Constants.SIMPLE_DATA_PATTEN));
//            }
//        });
//    }

//    public static Sportsman process(SportsmanDto sportsmanDto) {
//        return ProcessUtils.process(User.class, userDto, new ProcessCallback<User, UserDto>() {
//            @Override
//            public void call(User user, UserDto userDto) {
//                user.setId(UUIDUtil.getGuid());
//                user.setPassword(Md5Util.digestMD5(user.getPassword()));
//                user.setCreateTime(new Timestamp(System.currentTimeMillis()));
//                if(StringUtils.isBlank(user.getSign())){
//                    user.setSign(UserConstants.USER_DEFAULT_SIGN);
//                }
//                if(StringUtils.isBlank(user.getNickName())){
//                    user.setNickName(UserConstants.USER_DEFAULT_NICK_NAME);
//                }
//            }
//        });
//    }

}
