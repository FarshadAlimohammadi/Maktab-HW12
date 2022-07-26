package ir.maktabsharif.service;

import ir.maktabsharif.domain.User;
import ir.maktabsharif.repository.UserDAO;

public class UserServiceImple {
    private UserDAO userDAO;
    private SecurityService securityService;

    public void assignPassword(User user) throws Exception {
        String passwordMd5 = securityService.md5(user.getPassword());
        user.setPassword(passwordMd5);
        userDAO.updateUser(user);
    }

    public UserServiceImple(UserDAO userDAO, SecurityService securityService) {
        this.userDAO = userDAO;
        this.securityService = securityService;
    }
}
