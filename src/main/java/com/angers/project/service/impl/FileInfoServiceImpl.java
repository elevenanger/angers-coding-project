package com.angers.project.service.impl;

import com.angers.project.entity.FileInfo;
import com.angers.project.mapper.FileInfoMapper;
import com.angers.project.service.IFileInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件信息表 服务实现类
 * </p>
 *
 * @author anger
 * @since 2021-07-20
 */
@Service
public class FileInfoServiceImpl extends ServiceImpl<FileInfoMapper, FileInfo> implements IFileInfoService {

}
