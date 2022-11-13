package org.example.DAOInterface;

import org.example.model.Users;

import java.util.List;

public interface UserInterface {
    List<Users> userDetails(int userId);
    public void changePassword(String password, int id);
    public void changeUserName(String userName, int id);
    public void deleteUserAccount(int id);
}
