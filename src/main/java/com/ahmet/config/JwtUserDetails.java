package com.ahmet.config;

import com.ahmet.repository.entity.Userr;
import com.ahmet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtUserDetails implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    public UserDetails loadUserByUserId(Long id) throws UsernameNotFoundException {
        Optional<Userr> user = userService.findById(id);

        if (user.isPresent()){

            List<GrantedAuthority> authorityList=new ArrayList<>();
            authorityList.add(new SimpleGrantedAuthority(user.get().getRole().toString()));

            return User.builder()
                    .username(user.get().getUsername())
                    .password("")
                    .accountExpired(false)
                    .accountLocked(false)
                    .authorities(authorityList)
                    .build();
        }

        return null;
    }

}
