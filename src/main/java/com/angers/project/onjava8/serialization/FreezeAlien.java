package com.angers.project.onjava8.serialization;

import com.angers.project.onjava8.common.CommonUtils;

import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : liuanglin
 * @date : 2022/6/6 18:42
 * @description :
 */
public class FreezeAlien {
    public static void main(String[] args) throws Exception{
        Path path = Paths.get(CommonUtils.FILE_PATH,"X.file");
        try (ObjectOutputStream out =
            new ObjectOutputStream(
                Files.newOutputStream(path))){
            Alien alien = new Alien();
            out.writeObject(alien);
        }
    }
}
