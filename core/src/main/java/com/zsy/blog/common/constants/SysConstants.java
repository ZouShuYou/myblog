package com.zsy.blog.common.constants;

/**
 * @author zousy
 * @version v1.0
 * @Description
 * @date 2020-11-24 19:02
 */
public class SysConstants {
    public enum SysEnum {
        SUPER_ADMIN(1);
        public final Integer id;
        private SysEnum(Integer id){
            this.id = id;
        }
    }
}
