package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoHibernateImpl userdao= new UserDaoHibernateImpl();

    public void createUsersTable() {

        userdao.createUsersTable();

    }

    public void dropUsersTable() {

        userdao.dropUsersTable();

    }

    public void saveUser(String name, String lastName, int age) {

        userdao.saveUser(name,lastName, (byte) age);

    }

    public void removeUserById(long id) {

        userdao.removeUserById(id);

    }

    public List<User> getAllUsers() {

        return userdao.getAllUsers();
    }


    public void cleanUsersTable() {

        userdao.cleanUsersTable();

    }
}