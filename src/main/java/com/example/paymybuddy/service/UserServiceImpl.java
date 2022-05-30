package com.example.paymybuddy.service;

import com.example.paymybuddy.model.User;
import com.example.paymybuddy.repository.UserRepository;
import com.example.paymybuddy.DTO.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void save(UserRegistrationDTO registrationDTO) {
        User user = new User(registrationDTO.getFirstName(),
                registrationDTO.getLastName(), registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()), (double) 0, new ArrayList<>());

        userRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email));
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void addFriend(User user, User friend) {
        user.getFriends().add(friend);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities());
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities() {
        return new HashSet<GrantedAuthority>();
    }
}
