package com.angers.project.corejava.database;

import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Enumeration;

@Slf4j
public class TestDB {

    public static void main(String [] args) throws SQLException, ClassNotFoundException {
        /*
        数据库 URL
        DriverManager 遍历项目已注册的 jdbc 驱动
        寻找可以用于解析 URL 中子协议的驱动
         */
        String dbUrl = "jdbc:postgresql://localhost:5432/anger_db";
        String userName = "anger"; // 数据库用户
        String passWord = "anger"; // 数据库密码
        /*
        DriverManager 管理 JDBC 驱动
         */
        Enumeration<Driver> e = DriverManager.getDrivers();
        while (e.hasMoreElements()){
            log.info(e.nextElement().toString());
        }

        try (Connection connection = DriverManager
                .getConnection(dbUrl,userName,passWord); // 建立数据库连接
                    // 使用 Connection 创建Statement 对象，用于执行静态 SQL 语句
                    Statement statement = connection.createStatement()){
            // 默认为自动提交，SQL 语句一旦执行完则会自动提交，将其设置为 false，方便进行事务的控制
            connection.setAutoCommit(false);
            log.info(connection.getCatalog());
            // update 语句，返回影响的行数
            // 将这些语句封装为一个事务
            statement.executeUpdate("CREATE TABLE greeting (message char(20))");
            statement.executeUpdate("INSERT INTO greeting VALUES ('hello')");
            statement.executeUpdate("INSERT INTO greeting VALUES ('hello again')");
            int count = statement.
                    executeUpdate("UPDATE greeting SET message = 'hello everyone!' WHERE message = 'hello'");
            if (count>1) connection.rollback(); // 执行结果不符合预期则回滚事务
            // query 语句，返回结果集
            ResultSet resultSet = statement.executeQuery("SELECT * FROM greeting");
            while (resultSet.next()){
                // 结果集的第一列，使用 String 接收
                log.info(resultSet.getString(1));
            }
            statement.executeUpdate("DROP TABLE greeting");
            // 语句执行未出错，则提交事务
            connection.commit();
        }
    }
}
