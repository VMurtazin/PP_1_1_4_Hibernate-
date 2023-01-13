package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {

    private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb1?useUnicode=true&characterEncoding=UTF-8&" +
            "characterSetResults=UTF-8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rootroot";


    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            //System.out.println("connection ok");
        } catch (SQLException e) {
            System.out.println("connection Nok");
            e.printStackTrace();
        }
        return connection;
    }

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){
        Properties properties=new Properties();
        try {
            Configuration configuration = new Configuration();

            properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
            properties.setProperty(Environment.HBM2DDL_AUTO, "update");
            properties.setProperty(Environment.DRIVER, DB_DRIVER);
            properties.setProperty(Environment.URL, DB_URL);
            properties.setProperty(Environment.USER, DB_USERNAME);
            properties.setProperty(Environment.PASS, DB_PASSWORD);
            properties.setProperty(Environment.SHOW_SQL,"false");

            configuration.setProperties(properties);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);



        }catch (Exception e){
            e.printStackTrace();
        }

        return sessionFactory;
    }
}