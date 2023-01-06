package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        UserServiceImpl userService=new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Ivan","Ivanov", 10);
        userService.saveUser("Petr","Petrov", 20);
        userService.saveUser("Alex","Alexeev", 30);


        userService.getAllUsers();

        //userService.removeUserById(2);

        userService.cleanUsersTable();

        userService.dropUsersTable();


    }
}
