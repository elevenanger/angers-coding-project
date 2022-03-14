package com.angers.project;

import com.angers.project.object.Animal;
import com.angers.project.object.Trainer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class ObjectTester extends Tester {

    @Autowired
    private  Trainer trainer;

    private void training(Animal an) {

    }
}
