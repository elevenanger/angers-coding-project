package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/6 18:45
 * @description :
 */
public class ThawAlien {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(CommonUtils.FILE_PATH,"X.file");
        Object x;
        try (ObjectInputStream in = new ObjectInputStream(
            Files.newInputStream(path))) {
            x = in.readObject();
        }
        System.out.println(x.getClass());
        /* output
        class com.angers.project.onjava8.serialization.Alien
         */
    }
}
