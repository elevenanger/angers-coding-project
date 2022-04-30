package com.angers.project.onjava8.file;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author : liuanglin
 * @date : 2022/4/29 14:14
 * @description : 文件-删除文件夹以及其中所有的文件
 */
public class RmDir {
    public static void rmDir(Path dir) throws IOException {
        /*
        访问者模式
        查找目标地址的所有子文件夹和文件
        访问者模式为集合中的每个对象都提供了一种标准的处理机制
        对每个对象执行相同的操作
         */
        Files.walkFileTree(dir,new SimpleFileVisitor<Path>(){
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main(String[] args) throws IOException {
        rmDir(Paths.get("/Users/liuanglin/data/tmp"));
    }
}