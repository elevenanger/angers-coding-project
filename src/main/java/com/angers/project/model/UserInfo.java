package com.angers.project.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
@TableName(value = "user_info")
public class UserInfo {

    @TableId(type = IdType.AUTO)
    private long id;

    @TableField(value = "create_date")
    private Date createDate;

    @TableField(value = "modified_date")
    private Date modifiedDate;

    private String name;

    @TableField(value="mobile_no")
    private String mobileNo;

    private int sex;

    private String birthday;

    @TableField(value="nick_name")
    private String nickName;

    private String password;

}
