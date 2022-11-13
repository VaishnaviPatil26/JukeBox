package org.example;

import org.example.service.UserService;



public class App
{
    public static void main( String[] args )
    {
        UserService service = new UserService();
        service.mainMenu();

    }
}
