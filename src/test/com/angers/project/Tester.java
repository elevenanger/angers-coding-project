package com.angers.project;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest(classes = Application.class)
@Rollback
public class Tester {

}
