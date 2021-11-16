package com.mush.controller;

import com.mush.model.User;
import com.mush.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired UserService service;

  @GetMapping
  public List<User> getAll() {
    return service.getAll();
  }

  @GetMapping("/{email}")
  public User findByEmail(@PathVariable("email") String userEmail) {
    return service.getByEmail(userEmail);
  }

  @PostMapping
  public User add(@RequestBody User user) {
    return service.add(user);
  }

  @PutMapping
  public User update(@RequestBody User user) {
    return service.update(user);
  }

  @DeleteMapping
  public void delete(@RequestParam String email) {
    service.delete(email);
  }
}
