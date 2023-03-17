package com.vint.shop.service.impl;

import com.vint.shop.domain.User;
import com.vint.shop.repository.RoleRepository;
import com.vint.shop.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserDetailsServiceImpl underTest;

    @BeforeEach
    void setUp() {
        underTest = new UserDetailsServiceImpl(userRepository, roleRepository, passwordEncoder);
    }

    private User createUser() {
        User newUser = new User();
        newUser.setId(1);
        newUser.setEmail("asd@gmail.com");
        newUser.setUsername("Eva");
        newUser.setLogin("test123456");
        newUser.setPassword("Nfywq21@$55");
        return newUser;
    }

    @Test
    void loadUserByUsername() {
        User newUser = createUser();
        when(userRepository.findByLogin(newUser.getLogin())).thenReturn(newUser);
        underTest.loadUserByUsername(newUser.getLogin());
        verify(userRepository).findByLogin(newUser.getLogin());
    }

    @Test
    void deleteUser() {
    }

    @Test
    void findAll() {
        underTest.findAll();
        verify(userRepository).findAll();
    }

    @Test
    void saveUser() {
        User newUser = createUser();
        underTest.saveUser(newUser);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User userCapture = userArgumentCaptor.getValue();
        assertThat(userCapture).isEqualTo(newUser);
    }

    @Test
    void updateUser() {
        User newUser = createUser();
        newUser.setId(3);
        newUser.setUsername("TestUser");
        underTest.saveUser(newUser);
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userArgumentCaptor.capture());
        User userCapture = userArgumentCaptor.getValue();
        assertThat(userCapture).isEqualTo(newUser);
    }
}