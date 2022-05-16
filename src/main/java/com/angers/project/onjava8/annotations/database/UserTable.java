package com.angers.project.onjava8.annotations.database;

/**
 * @author : liuanglin
 * @date : 2022/5/13 14:43
 * @description :注解-数据库-用户表
 */
@DBTable(name = "user_table")
public class UserTable {
    @SQLString(name = "first_name",value = 30)
    String firstName;
    @SQLString(value = 30,name = "last_name")
    String lastName;
    @SQLString(value = 3,name = "age")
    Integer age;
    @SQLString(value = 30,name = "reference",constraints = @Constraints(primaryKey = true))
    String reference;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getReference() {
        return reference;
    }
}
