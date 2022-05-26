package com.angers.project.onjava8.pattern.trash;

import java.util.ArrayList;

/**
 * @author : liuanglin
 * @date : 2022/5/26 18:41
 * @description :
 */
class TrashBin<T extends Trash> extends ArrayList<T> {
    final Class<T> binType;
    TrashBin(Class<T> binType){
        this.binType = binType;
    }

    @SuppressWarnings("uncheked")
    boolean grab(Trash trash){
        if (trash.getClass().equals(binType)){
            // 转型为具体的 Trash 子类型
            add((T)trash);
            return true;
        }
        return false;
    }
}

class TrashBinList<T extends Trash>
        extends ArrayList<TrashBin<? extends T>> {
    public TrashBinList(Class<? extends T> ... types){
        for(Class<? extends T> type : types){
            add(new TrashBin<>(type));
        }
    }

    public boolean sort(T t){
        return this.stream().anyMatch(ts -> ts.grab(t));
    }

    public void sortBin(TrashBin<T> bin){
        bin.forEach(t -> {
            if (!sort(t))
                throw new RuntimeException("Bin not found for " + t);
        });
    }

    public void show(){
        this.forEach(ts -> {
            String type = ts.binType.getSimpleName();
            TrashValue.sum(ts,type);
        });
    }
}
public class RecycleC {
    public static void main(String[] args) {
        TrashBin<Trash> bin =
                new TrashBin<>(Trash.class);
        ParseTrash.fillBin("trash",bin);
        TrashBinList<Trash> trashBins = new TrashBinList<>(
                Aluminum.class,
                Paper.class,
                CardBoard.class,
                Glass.class
        );
        trashBins.sortBin(bin);
        trashBins.show();
        TrashValue.sum(bin,"Trash");
    }
}
