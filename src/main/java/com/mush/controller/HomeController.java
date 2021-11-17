package com.mush.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

  @Operation(summary = "Test current route")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Will return string 'home'",
            content = {@Content()})
      })
  @GetMapping
  public String testHome() {
    return "home";
  }
}
