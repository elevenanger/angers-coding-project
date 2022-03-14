package com.angers.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class leetcodeTester extends Tester{

    @Test
    public void isPalindrome() {
        String result = "1";
        int x = 1234321;
        if (x < 0||x%10==0){
            result = "0" ;
        }
        if (x>=0&&x<10){
            result = "1";
        }
        char [] numArrray = String.valueOf(x).toCharArray();
        int arrayLength = numArrray.length;
        for (int i =0 ; i< arrayLength/2;i++){
            if (numArrray[i]!=numArrray[arrayLength-1-i]){
                result = "0";
            }
        }
        log.info(result);
        int y = 0;
        int z = x;
        while (z>10){
            int x1 = z%10;
            y = (y+x1)*10;
            z = z/10;
        }
        y+=z;
        log.info(String.valueOf(y==x));
    }
}
