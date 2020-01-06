package com.baomidou.test.sys.store.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author yaoyige
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 别名
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 权限id
     */
    private Integer roleId;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否删除(0:未删除 1:已删除)
     */
    private Integer deleted;

    /**
     * 乐观锁
     */
    private Integer updateVersion;

    /**
     * 邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;


}
