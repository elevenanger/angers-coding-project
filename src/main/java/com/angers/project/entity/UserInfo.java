package com.angers.project.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author anger
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 修改时间
     */
    private LocalDateTime modifiedDate;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户手机号
     */
    private String mobileNo;

    /**
     * 性别,0:male;1:female
     */
    private Boolean sex;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 用户昵称
     */
    private String nickName;

    /**
     * 密码
     */
    private String password;


}
