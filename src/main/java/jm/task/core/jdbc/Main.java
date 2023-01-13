package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserServiceImpl;




public class Main {
    public static void main(String[] args)  {

        UserServiceImpl test = new UserServiceImpl();


        test.dropUsersTable();
        test.createUsersTable();
        test.saveUser("имя", "фамилия", (byte) 23);
        test.saveUser("имя2", "фамилия2", (byte) 43);
        test.saveUser("имя3", "фамилия3", (byte) 16);
        test.saveUser("Kolya", "Vetkin", (byte) 25);
        test.saveUser("Petya", "Utkin", (byte) 56);
        test.removeUserById(3);
        test.getAllUsers();
        test.cleanUsersTable();
    }
}
