// package com.example.TodoAPI.model;

// import java.util.Collection;
// import java.util.List;

// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;

// import lombok.Data;

// @Data
// public class Users implements UserDetails {
// private String user_id;
// private String login;
// private String password;
// private String role;
// private String created_at;
// private String created_user;
// private String updated_at;
// private String updated_user;

// @Override
// public Collection<? extends GrantedAuthority> getAuthorities() {
// return List.of(() -> "ROLE_" + this.role);
// }

// @Override
// public String getPassword() {
// return this.password;
// }

// @Override
// public String getUsername() {
// return this.login;
// }

// @Override
// public boolean isAccountNonExpired() {
// return true; // ここでは単純にtrueを返します
// }

// @Override
// public boolean isAccountNonLocked() {
// return true; // ここでは単純にtrueを返します
// }

// @Override
// public boolean isCredentialsNonExpired() {
// return true; // ここでは単純にtrueを返します
// }

// @Override
// public boolean isEnabled() {
// return true; // ここでは単純にtrueを返します
// }
// }