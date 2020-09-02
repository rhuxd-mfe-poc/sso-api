package org.rh.uxd.sso;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDataService {
    private static UserDataService ourInstance = new UserDataService();

    public static UserDataService getInstance() {
        return ourInstance;
    }

    // For now just store users in memory.
    private static List<Contact> userList = new ArrayList<>();

    public String addUser(Contact user) {
        String newId =  UUID.randomUUID().toString();
        user.setId(newId);
        userList.add(user);
        return newId;
    }

    public String deleteUser(String id) {
        for(Contact user : userList) {
            if(user.getId().equals(id)) {
                userList.remove(userList.indexOf(user));
                return "removed user: " + id;
            }
        }

        return "user " + id + " does not exists";
    }

    public List<Contact> getUserList() {
        return userList;
    }

    public Contact getUserById(String id) {
        for (Contact user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }
}
