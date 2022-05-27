package web.UserDAO;

import web.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void addUser(User user);
    public User getUserById(int id);

    public void editUser(User user);
    public void removeUserById(int id);

}
