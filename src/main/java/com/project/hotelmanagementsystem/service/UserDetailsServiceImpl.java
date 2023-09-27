package com.project.hotelmanagementsystem.service;

import com.project.hotelmanagementsystem.dao.RoleRepository;
import com.project.hotelmanagementsystem.dao.UserRepository;
import com.project.hotelmanagementsystem.dao.UserRoleRepository;
import com.project.hotelmanagementsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        User userFind = userRepository.findByUsername(userName);


        if (userFind == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }



        List<String> roleNames = this.userRoleRepository.findRoleNamesByUserId(userFind.getId());


        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (roleNames != null) {
            for (String role : roleNames) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }


        UserDetails userDetails = (UserDetails) new User(userFind.getUsername(),
                userFind.getPassword(), grantList);

        return userDetails;
    }
}
