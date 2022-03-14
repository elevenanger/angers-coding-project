package com.angers.project.assertion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AssertionTester {

    public static double mathSqrt(double x){

        return Math.sqrt(x);
    }

    public static void main(String [] args){
        mathSqrt(-1.22);
    }
}
