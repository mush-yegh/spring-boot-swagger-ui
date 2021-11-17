package com.mush.controller;

import com.mush.model.User;
import com.mush.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired UserService service;

  @Operation(summary = "Get all users")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "The found user",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = User.class))
            })
      })
  @GetMapping
  public List<User> getAll() {
    return service.getAll();
  }

  @Operation(summary = "Get user by email")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "The found user",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = User.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid email provided",
            content = @Content),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
      })
  @GetMapping("/{email}")
  public User findByEmail(@PathVariable("email") String userEmail) {
    return service.getByEmail(userEmail);
  }

  @Operation(summary = "Add a new user")
  @PostMapping
  public User add(@RequestBody User user) {
    return service.add(user);
  }

  @Operation(summary = "Update existing user data")
  @PutMapping
  public User update(@RequestBody User user) {
    return service.update(user);
  }

  @Operation(summary = "Delete existing user")
  @DeleteMapping
  public void delete(@RequestParam String email) {
    service.delete(email);
  }
}
