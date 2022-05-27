package com.angers.project.onjava8.pattern.trash;

import java.util.List;
import java.util.Map;

/**
 * @author : liuanglin
 * @date : 2022/5/27 14:17
 * @description :
 */
public class ClassToListOfTrashMap {
    public static void show(Map<Class, List<Trash>> map){
        map.values().forEach(
                bin -> {
                    String typeName = "Trash";
                    if (!bin.isEmpty())
                            typeName = bin.get(0).getClass().getSimpleName();
                    TrashValue.sum(bin,typeName);
                });
    }

}
