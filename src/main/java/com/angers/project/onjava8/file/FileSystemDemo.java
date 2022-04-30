package com.angers.project.onjava8.file;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

/**
 * @author : liuanglin
 * @date : 2022/4/29 14:52
 * @description :文件-文件系统
 */
public class FileSystemDemo {
    static void show(String id,Object o){
        System.out.println(id + " : " + o);
    }
    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        // 查看文件系统相关特性
        FileSystem fileSystem = FileSystems.getDefault();
        fileSystem.getFileStores().forEach(fileStore -> show("File store",fileStore));
        fileSystem.getRootDirectories().forEach(path -> show("Root directory",path));
        show("Separator",fileSystem.getSeparator());
        show("getUserPrincipalLookupService",fileSystem.getUserPrincipalLookupService());
        show("isOpen",fileSystem.isOpen());
        show("isReadOnly",fileSystem.isReadOnly());
        show("provider",fileSystem.provider());
        show("attribute",fileSystem.supportedFileAttributeViews());
    }
}
