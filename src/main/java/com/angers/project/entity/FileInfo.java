package com.angers.project.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 文件信息表
 * </p>
 *
 * @author anger
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class FileInfo implements Serializable {

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
     * 桶名
     */
    private String bucketName;

    /**
     * 文件前缀
     */
    private String filePrefix;

    /**
     * 原文件名
     */
    private String originName;

    /**
     * 上传后文件名
     */
    private String actualName;

    /**
     * 状态
     */
    private String status;

    /**
     * 文件访问地址
     */
    private String url;


}
