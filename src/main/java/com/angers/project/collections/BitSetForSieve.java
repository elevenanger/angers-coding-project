package com.angers.project.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.BitSet;

@Slf4j
public class BitSetForSieve {

    public static void main(String [] args){
        int n = 20;
        long start = System.currentTimeMillis();
        BitSet bitSet = new BitSet(n+1);
        int count  = 0;
        int i ;
        for (i = 2; i <= n ; i++) {
            bitSet.set(i);
        }
        i = 2;
        while (i * i<=n){
            if (bitSet.get(i)){
                count ++;
                int k = 2*i;
                while (k<=n){
                    bitSet.clear(k);
                    k += i;
                }
            }
            i ++;
        }
        while ( i <= n){
            if (bitSet.get(i)) count++;
            i++;
        }
        if (bitSet.size()<100) log.info(bitSet.toString());
        long end = System.currentTimeMillis();
        log.info(count + "Primes");
        log.info((end-start)+"milliseconds");
    }
}
