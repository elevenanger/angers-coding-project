package com.angers.project.onjava8.annotations.database;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : liuanglin
 * @date : 2022/5/13 15:56
 * @description :注解-数据库-创建表
 * 读取类中数据库相关注解，依此创建数据库表
 */
public class TableCreator {
    public static void generateTableSql(Class<?> cl) {
        DBTable table = cl.getAnnotation(DBTable.class);
        if (table == null) {
            System.out.println("table name undefine");
            return;
        }
        String tableName = table.name();
        if (tableName.length() < 1) tableName = cl.getSimpleName();
        List<String> fields =
        Arrays.stream(cl.getDeclaredFields())
                .map(Field::getDeclaredAnnotations)
                .map(TableCreator::processFieldAnnotation)
                .collect(Collectors.toList());
        StringBuilder tableSql = new StringBuilder();
        tableSql.append("CREATE TABLE ")
                .append(tableName.toUpperCase())
                .append("(")
                .append("\n");
        fields.subList(0, fields.size()-2)
                .forEach(s -> tableSql.append("\t").append(s).append(",").append("\n"));
        tableSql.append("\t").append(fields.get(fields.size()-1));
        tableSql.append(");");
        System.out.println(tableSql.toString());
    }
    static String processFieldAnnotation(Annotation ... annotations){
        return Arrays.stream(annotations)
                .map(TableCreator::generateFieldSql)
                .findFirst()
                .orElse("");
    }
    static String generateFieldSql(Annotation annotation){
        StringBuilder fieldSql = new StringBuilder();
        if (annotation instanceof SQLString){
            fieldSql.append(((SQLString) annotation).name().toUpperCase())
                    .append(" ")
                    .append("VARCHAR(")
                    .append(((SQLString) annotation).value())
                    .append(")")
                    .append(generateConstraintSql(((SQLString) annotation).constraints()));
        }
        if (annotation instanceof SQLInteger){
            fieldSql.append(((SQLInteger) annotation).name())
                    .append(" ")
                    .append("INT")
                    .append(generateConstraintSql(((SQLInteger) annotation).constraints()));
        }
        return fieldSql.toString();
    }
    static String generateConstraintSql(Constraints constraints){
        StringBuilder constraintBuilder = new StringBuilder(" ");
        if (constraints.unique()) constraintBuilder.append(" UNIQUE");
        if (!constraints.allowNull()) constraintBuilder.append(" NOT NULL");
        if (constraints.primaryKey()) constraintBuilder.append(" PRIMARY KEY");
        return constraintBuilder.toString();
    }

    public static void main(String[] args) {
        generateTableSql(UserTable.class);
    }
}
