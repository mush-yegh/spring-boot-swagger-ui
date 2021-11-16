package com.mush.service;

import com.mush.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {
  private List<User> users = new ArrayList<>();

  public User add(User user) {
    if (users.contains(user)) {
      return null;
    }
    users.add(user);
    return user;
  }

  public List<User> getAll() {
    return users;
  }

  public User getByEmail(String email) {
    return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().get();
  }

  public boolean delete(String email) {
    User user = users.stream().filter(u -> u.getEmail().equals(email)).findFirst().get();
    return users.remove(user);
  }

  public User update(User user) {
    int index = users.indexOf(user);
    if (index == -1) {
      return null;
    }
    return users.set(index, user);
  }
}
