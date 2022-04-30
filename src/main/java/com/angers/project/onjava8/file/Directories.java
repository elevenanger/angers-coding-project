package com.angers.project.onjava8.file;

import com.angers.project.onjava8.common.CommonUtils;

import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/4/29 14:28
 * @description :文件-文件夹操作
 */
public class Directories {
    static Path test = Paths.get("/Users/liuanglin/data/test");
    static String sep = FileSystems.getDefault().getSeparator();
    static List<String> parts = Arrays.asList("foo","bar","baz","bag");
    static Path makeVariant(){
        Collections.rotate(parts,1);
        return Paths.get("/Users/liuanglin/data/tmp/test",String.join(sep,parts));
    }
    static void refreshTestDir() throws Exception{
        if (Files.exists(test))
            RmDir.rmDir(test);
        if (!Files.exists(test)){
            Files.createDirectory(test);
        }
    }
    static void populateTestDir()throws Exception{
        for (int i = 0; i < parts.size(); i++) {
            Path variant = makeVariant();
            if (!Files.exists(variant)){
                Files.createDirectory(variant);
                Files.copy(Paths.get("/Users/liuanglin/Projects/angers-coding-project/src/main/java/com/angers/project/onjava8/file/Directories.java"),
                        variant.resolve("/File.txt"));
                Files.createTempFile(variant,null,null);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        refreshTestDir();
        Files.createFile(test.resolve("Hello.txt"));
        Path variant = makeVariant();
        try {
            Files.createDirectory(variant);
        }catch (Exception e){
            System.out.println("create variant failed");
        }
        populateTestDir();
        Path tmpDir = Files.createTempDirectory(test,"DIR_");
        Files.createTempFile(tmpDir,"pre",".non");
        Files.newDirectoryStream(test)
                .forEach(System.out::println);
        CommonUtils.printDivide("divide");
        Files.walk(test).forEach(System.out::println);
    }
}
