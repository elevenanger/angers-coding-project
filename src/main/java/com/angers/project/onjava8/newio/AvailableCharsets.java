package com.angers.project.onjava8.newio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author : liuanglin
 * @date : 2022/6/1 09:08
 * @description : 可用的字符集
 */
public class AvailableCharsets {
    public static void main(String[] args) {
        SortedMap<String, Charset> charsetSortedMap = Charset.availableCharsets();
        for (String csName : charsetSortedMap.keySet()) {
            System.out.print(csName);
            Iterator<String> aliases = charsetSortedMap.get(csName).aliases().iterator();
            if (aliases.hasNext()) System.out.print(" : ");
            while (aliases.hasNext()) {
                System.out.print(aliases.next());
                if (aliases.hasNext()) System.out.print(", ");
            }
            System.out.println();
        }
    }
}
