package com.angers.project.onjava8.pattern.trash;


import com.angers.project.onjava8.pattern.TypeMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/27 14:20
 * @description :
 */
public class TypeMapAdapter implements Fillable{
    private TypeMap<Trash> map;

    public TypeMapAdapter(TypeMap<Trash> map) {
        this.map = map;
    }

    @Override
    public void addTrash(Trash trash) {
        map.add(trash);
    }

    public static void main(String[] args) {
        TypeMap<Trash> bin = new TypeMap<>();
        ParseTrash.fillBin("trash",new TypeMapAdapter(bin));
        ClassToListOfTrashMap.show(bin.map);

        List<Trash> bin1  = new ArrayList<>();
        ParseTrash.fillBin("trash",bin1);
        Map<Class,List<Trash>> m = bin1.stream().collect(
                Collectors.groupingBy(Object::getClass));
        ClassToListOfTrashMap.show(m);
    }
}
