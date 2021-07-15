package com.angers.project;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = Application.class)
@Transactional
@Rollback
public class Tester {

}
