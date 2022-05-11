package com.angers.project.onjava8.array;

import com.angers.project.onjava8.Suppliers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : liuanglin
 * @date : 2022/5/10 10:09
 * @description :数组-比较数组和集合
 */
public class CollectionComparison {
    public static void main(String[] args) {
        BerylliumSphere [] spheres = new BerylliumSphere[10];
        for (int i = 0; i < spheres.length; i++) {
            spheres[i] = new BerylliumSphere();
        }
        ArrayShow.show(spheres);
        System.out.println(spheres[5]);

        List<BerylliumSphere> spheres1 = Suppliers.create(ArrayList::new,BerylliumSphere::new,10);
        System.out.println(spheres1);
        System.out.println(spheres1.get(5));

        int[] ints = {0,1,2,3,4,5};
        ArrayShow.show(ints);
        System.out.println(ints[1]);

        List<Integer> integers = new ArrayList<>(
                Arrays.asList(0,1,2,3,4,5)
        );
        integers.add(99);
        System.out.println(integers);
        System.out.println(integers.get(3));
    }
}

class BerylliumSphere {
    private static long counter = 0;
    private final long id = counter ++;

    @Override
    public String toString() {
        return "BerylliumSphere{" +
                "id=" + id +
                '}';
    }
}