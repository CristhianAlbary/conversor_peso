package br.edu.utfpr.weight_converter.services;

import br.edu.utfpr.weight_converter.models.dao.UserDAO;
import br.edu.utfpr.weight_converter.models.domain.User;

import java.util.HashMap;
import java.util.List;

public class UserService extends AbstractService<Long, User> {

    UserDAO userDao = new UserDAO();

    public boolean saveUser(HashMap<String, String> identity) {
        if(identity.isEmpty()) {
            return false;
        }

        boolean res = this.save(new User(identity.get("identity")));
        return res;
    }

    public User findByName(String name) {
        List<User> result = this.userDao.findByName("name", name);
        User user = new User();
        user.setId(result.get(0).getId());
        user.setName(result.get(0).getName());
        return user;
    }


}
