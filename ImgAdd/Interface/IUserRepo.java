package Interfaces;

import Entities.User;
import java.util.List;

public interface IUserRepo {
	
    User searchUserByEmail(String email);
    List<User> getAllUsers();
    boolean isEmailRegistered(String email);
    void saveUserData(User user);
    boolean updateUserEmail(String name, String oldEmail, String newEmail);
    boolean deleteUser(String name, String email);
}
