package com.angers.project.onjava8.pattern.trash.doubledispatch;

import com.angers.project.onjava8.pattern.trash.Trash;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/27 08:49
 * @description : 垃圾桶类型
 */
public class TypedBin {
    private List<Trash> typedBin = new ArrayList<>();
    public final String type;
    public TypedBin(String type) {
        this.type = type;
    }
    public List<Trash> bin(){
        return new ArrayList<>(typedBin);
    }
    protected boolean addIt(Trash trash){
        typedBin.add(trash);
        return true;
    }
    public boolean add(Aluminum aluminum){
        return false;
    }
    public boolean add(Paper paper){
        return false;
    }
    public boolean add(Glass glass){
        return false;
    }
    public boolean add(CardBoard cardBoard){
        return false;
    }
}
