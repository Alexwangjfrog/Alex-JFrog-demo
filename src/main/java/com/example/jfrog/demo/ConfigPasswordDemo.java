package com.example.jfrog.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConfigPasswordDemo {

    public static void connectUsingEnvironmentVariables() {
        try {
            // 获取数据库连接信息（从环境变量中读取）
            String url = System.getenv("DB_URL");
            String username = System.getenv("DB_USER");
            String password = System.getenv("DB_PASSWORD");

            if (url == null || username == null || password == null) {
                throw new IllegalStateException("Database credentials are not set in environment variables.");
            }

            // 使用环境变量中的信息连接数据库
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected with user: " + username);

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
