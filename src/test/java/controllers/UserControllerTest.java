package controllers;

import config.SpringConfig;
import models.Product;
import models.User;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

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
    public void createUser() {
        User user = new User();
        user.setLogin("test1User");
        userController.createUser(user);
        System.out.println(userController.getUsers());

    }

}