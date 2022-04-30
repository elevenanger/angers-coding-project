package com.angers.project.onjava8.file;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/4/29 09:42
 * @description :文件- Path 接口抽象的文件路径信息
 */
public class PathInfo {
    static void show(String id,Object p){
        System.out.println(id + " : " +p );
    }

    /**
     * 输出基本的文件或者文件夹信息
     * @param path 文件/文件夹路径
     */
    static void info(Path path){
        show("toString",path);
        show("Exist", Files.exists(path));
        show("Regular file",Files.isRegularFile(path));
        show("Directory",Files.isDirectory(path));
        show("Absolute",path.isAbsolute());
        show("Filename",path.getFileName());
        show("Parent", path.getParent());
        show("Root",path.getRoot());
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        // 使用参数列表表示路径信息，类 Unix 系统第一个参数需要拼接 /
        Path p =Paths.get("/Users","liuanglin","data","notice.txt");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        try {
            info(p.toRealPath());
        }catch (IOException e){
            System.out.println(e);
        }
        URI uri = p.toUri();
        System.out.println("Uri : " +uri);
        Path pUri = Paths.get(uri);
        System.out.println(Files.exists(pUri));
        // 这个方法是为了向前兼容，一般不会需要用到了
        File file = ap.toFile();
    }
}
