package com.angers.project.onjava8.pattern.trash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author : liuanglin
 * @date : 2022/5/26 08:05
 * @description : 读取 Trash.dat 文件中的数据 创建对象
 */
public class ParseTrash {
    public static String source = "/Users/liuanglin/Projects/angers-coding-project/src/main/java/com/angers/project/onjava8/pattern/trash/Trash.dat";
    public static <T extends Trash> void
        fillBin(String packageName, Fillable<T> bin){
        DynamicTrashFactory factory = new DynamicTrashFactory(packageName);
        try (Stream<String> fileParse =
                Files.lines(Paths.get(source)) ){
                    fileParse.filter(line -> line.trim().length() != 0)
                        .filter(line -> !line.startsWith("//"))
                        .forEach(line -> {
                            String type = line.substring(0,line.indexOf(':')).trim();
                            double weight = Double.parseDouble(
                                line.substring(line.indexOf(':') + 1).trim());
                        bin.addTrash(factory.create(new TrashInfo(type,weight)));
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Trash> void
        fillBin(String packageName, List<T> bin){
            fillBin(packageName,new FillableList<T>(bin));
    }

    public static void main(String[] args) {
        List<Trash> bin = new ArrayList<>();
        fillBin("trash",bin);
        bin.forEach(System.out::println);
    }
}
