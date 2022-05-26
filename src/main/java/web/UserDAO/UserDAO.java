package web.UserDAO;

import web.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);
    public User showUser(int id);
}
