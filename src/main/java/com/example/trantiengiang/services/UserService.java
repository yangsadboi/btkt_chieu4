package com.example.trantiengiang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class UserService  {}
//
//    private final IUserRepository userRepository;
//    private final IRoleRepository roleRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(IUserRepository userRepository, IRoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.roleRepository = roleRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    // Save a new user after encoding the password
//    public void save(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userRepository.save(user);
//    }
//
//    // Set default role for a user based on username
//    public void setDefaultRole(String username) {
//        userRepository.findByUsername(username).ifPresentOrElse(
//                user -> {
//                    Role defaultRole = roleRepository.findByName("USER")
//                            .orElseThrow(() -> new IllegalStateException("Default role not found"));
//                    user.getRoles().add(defaultRole);
//                    userRepository.save(user);
//                },
//                () -> { throw new UsernameNotFoundException("User not found"); }
//        );
//    }
//
//    // Load user details by username for authentication
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .authorities(user.getAuthorities())
//                .accountExpired(!user.isAccountNonExpired())
//                .accountLocked(!user.isAccountNonLocked())
//                .credentialsExpired(!user.isCredentialsNonExpired())
//                .disabled(!user.isEnabled())
//                .build();
//    }
//
//    // Find user by username
//    public Optional<User> findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
