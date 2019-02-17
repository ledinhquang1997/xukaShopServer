package com.example.xukashop.controller;

import com.example.xukashop.dto.UserInfoDTO;
import com.example.xukashop.exception.ResourceNotFoundException;
import com.example.xukashop.model.User;
import com.example.xukashop.repository.UserRepository;
import com.example.xukashop.security.CurrentUser;
import com.example.xukashop.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserInfoDTO getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        User user = userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));

        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setEmail(user.getEmail());
        userInfoDTO.setId(user.getId());
        userInfoDTO.setName(user.getName());
        userInfoDTO.setImageUrl(user.getImageUrl());
        return userInfoDTO;
    }

    @GetMapping("/admin/me")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String getAdminInfo(){
        return "fuckit";
    }
}
