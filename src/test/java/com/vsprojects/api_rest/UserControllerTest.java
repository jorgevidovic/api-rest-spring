package com.vsprojects.api_rest;

import com.vsprojects.api_rest.controllers.UserController;
import com.vsprojects.api_rest.models.User;
import com.vsprojects.api_rest.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getUsers_ShouldReturnAllUsers() {
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User());
        mockUsers.add(new User());

        when(userService.getAll()).thenReturn(new ArrayList<>(mockUsers));

        List<User> result = userController.getUsers();

        assertEquals(2, result.size());
        verify(userService).getAll();
    }

    @Test
    void getUserById_ShouldReturnUser_WhenExists() {
        User user = new User();
        user.setId(1L);

        when(userService.getById(1L)).thenReturn(Optional.of(user));

        ResponseEntity<User> response = userController.getUserById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    void getUserById_ShouldReturnNotFound_WhenMissing() {
        when(userService.getById(99L)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.getUserById(99L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void saveUser_ShouldReturnCreatedUser() {
        User input = new User();
        input.setEmail("test@test.com");

        when(userService.save(input)).thenReturn(input);

        ResponseEntity<User> response = userController.saveUser(input);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(input, response.getBody());
    }

    @Test
    void updateUserById_ShouldReturnUpdatedUser_WhenExists() {
        User updated = new User();
        updated.setFirstName("Updated");

        when(userService.update(1L, updated)).thenReturn(Optional.of(updated));

        ResponseEntity<User> response = userController.updateUserById(1L, updated);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Updated", response.getBody().getFirstName());
    }

    @Test
    void updateUserById_ShouldReturnNotFound_WhenMissing() {
        User input = new User();
        when(userService.update(999L, input)).thenReturn(Optional.empty());

        ResponseEntity<User> response = userController.updateUserById(999L, input);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void delete_ShouldReturnNoContent_WhenExists() {
        when(userService.delete(1L)).thenReturn(true);

        ResponseEntity<Void> response = userController.delete(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void delete_ShouldReturnNotFound_WhenMissing() {
        when(userService.delete(123L)).thenReturn(false);

        ResponseEntity<Void> response = userController.delete(123L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}