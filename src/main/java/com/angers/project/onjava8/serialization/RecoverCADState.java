package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/6/7 09:46
 * @description : 反序列化 CAD 系统数据文件
 */
public class RecoverCADState {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(CommonUtils.FILE_PATH,"/serialization/CAD.dat");
        try (
            ObjectInputStream in =
                new ObjectInputStream(
                    Files.newInputStream(path))
            ){
            List<Class<? extends Shape>> shapeTypes =
                (List<Class<? extends Shape>>) in.readObject();
            // 反序列化 Line 中的 static 域
            Line.deserializeStaticState(in);
            List<Shape> shapes = (List<Shape>) in.readObject();
            shapeTypes.forEach(System.out::println);
            shapes.forEach(System.out::println);
        }
    }
}
