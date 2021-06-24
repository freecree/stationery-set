package controllers;

import config.SpringConfig;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
    private static AnnotationConfigApplicationContext context;
    private static UserController userController;

    @BeforeAll
    static void setUp() {
        context = new AnnotationConfigApplicationContext(SpringConfig.class);
        userController = context.getBean("userController", UserController.class);
    }
    @Test
    @DisplayName("testing for creating and getting user by id")
    public void createUser() {
        //GIVEN
        User expectedUser = new User();
        expectedUser.setLogin("user1");
        expectedUser.setId(1);
        //WHEN
        userController.createUser(expectedUser);
        User actualUser = userController.getUserById(1);
        System.out.println(userController.getUsers());
        //User actualUser = new User();
        //actualUser.setLogin("user1");
        //actualUser.setId(2);
        //THEN
        Assertions.assertEquals(expectedUser, actualUser);
    }

}