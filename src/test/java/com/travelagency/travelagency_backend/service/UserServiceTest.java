//package com.travelagency.travelagency_backend.service;
//
//import com.travelagency.travelagency_backend.model.User;
//import com.travelagency.travelagency_backend.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class UserServiceTest {
//
//    @InjectMocks
//    private UserService userService;
//
//    @Mock
//    private UserRepository userRepository;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testFindUserById() {
//        User user = new User();
//        user.setId(1L);
//
//        when(userRepository.findById(1L)).thenReturn(java.util.Optional.of(user));
//
//        User foundUser = userService.findUserById(1L).orElseThrow();
//
//        assertNotNull(foundUser);
//        assertEquals(1L, foundUser.getId());
//    }
//}