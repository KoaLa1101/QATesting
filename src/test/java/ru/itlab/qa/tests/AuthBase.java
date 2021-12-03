package ru.itlab.qa.tests;

import org.junit.jupiter.api.BeforeEach;

public class AuthBase extends TestBase{
    @BeforeEach
    public void setUp(){
        login(0);
    }
}
