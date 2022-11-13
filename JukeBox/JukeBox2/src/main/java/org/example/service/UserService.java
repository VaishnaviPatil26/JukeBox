package org.example.service;

import org.example.DBConnection;
import org.example.DAOInterface.UserInterface;
import org.example.DAOImplmentation.UserImpl;
import org.example.model.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {

    Scanner sc = new Scanner(System.in);
    Users user = new Users();
    SongService songService = new SongService();
    PodcastService podcastService = new PodcastService();
    PlaylistService playlistService = new PlaylistService();
    UserInterface userInterface = new UserImpl();
    PlaylistDetailsService playlistDetailsService = new PlaylistDetailsService();

    public void mainMenu(){
        while(true){
            System.out.println();
            System.out.println("----------------------------------------------------");
            System.out.println("**************** WELCOME TO JUKEBOX ****************");
            System.out.println("----------------------------------------------------");
            System.out.println("\n1. New User Register  \n2. Login User \n3. Go Without Login \n4. Exit");
            System.out.print("\nEnter your choice : ");
            int choice =sc.nextInt();
            switch (choice){
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    withoutLogin(choice);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
    public void menu(int id) {
        System.out.println("----------------------------------------------------");
        System.out.println("******************** Main Menu *********************");
        System.out.println("----------------------------------------------------");
        System.out.println("1. Songs");
        System.out.println("2. Podcast");
        System.out.println("3. PlayList");
        System.out.println("4. PlayListDetails");
        System.out.println("5. Edit User Details");
        System.out.println("6. Exit");
        System.out.print("\nEnter Your Choice : ");
        int choose = sc.nextInt();

        switch (choose) {
            case 1:
                songService.songMenu(id);
                break;
            case 2:
                podcastService.podcastMenu(id);
                break;
            case 3:
                  playlistService.playlistMenu(id);
                break;
            case 4:
                  playlistDetailsService.playlistDetailMenu(id);
                break;
            case 5:
                userMenu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Invalid Choice");
        }
    }
    public void login() {
        try {
            Connection con= DBConnection.getConnection();
            System.out.println("----------------------------------------------------");
            System.out.print("Enter Your User Id : ");
            int id = sc.nextInt();
            user.setUserId(id);
            System.out.print("Enter Your Password : ");
            String pwd = sc.next().trim();
            user.setPasswords(pwd);
            String getPwdQuery = "select * from Users where userId = "+ user.getUserId();
            PreparedStatement statement = con.prepareStatement(getPwdQuery);
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                int userId = resultSet.getInt("userId");
                String password = resultSet.getString("passwords").trim();
                String name = resultSet.getString("userName");
                if (user.getPasswords().equals(password)){
                    System.out.println("Login Successfully ......... !!! Welcome "+name+" !!!");
                    menu(userId);
                }else {
                    System.out.println("\n*******User Id or Password is Incorrect*********");
                }
            }

        }catch (Exception e){
            System.out.println("Error -- "+e);
        }

    }

    public void register() {
        try {
            Connection con= DBConnection.getConnection();
            System.out.println("-------------------------- Enter Your Details ------------------------------");
            System.out.print("Enter Your User Id : ");
            int id = sc.nextInt();
            user.setUserId(id);
            System.out.print("Enter Your Name : ");
            String name = sc.next();
            Pattern pattern1= Pattern.compile("[a-zA-Z]{3,15}");
            Matcher matcher1= pattern1.matcher(name);
            if (matcher1.find()){
                user.setUserName(name);
            }else {
                System.out.println("Name should contain more than 3 characters");
                register();
            }
            System.out.print("Enter Your Mobile No. : ");
            String mobile = sc.next().trim();
            Pattern pattern = Pattern.compile("\\d{10}");
            Matcher matcher =pattern.matcher(mobile);
            if(matcher.find()){
                user.setMobileNo(mobile);
            }
            else {
                System.out.println("Entered Incorrect Mobile No");
                register();
            }
            System.out.print("Enter Your Password : ");
            String pwd = sc.next();
            user.setPasswords(pwd);

            String custQuery = "insert into Users values("+user.getUserId()+",'"+user.getUserName()+"',"+user.getMobileNo()+",'" + user.getPasswords().trim()+"')";
            Statement statement = con.createStatement();
            int rows = statement.executeUpdate(custQuery);
            System.out.println("Account Created Successfully");
            menu(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void withoutLogin(int id){
        while (true){
            System.out.println("\n---------------------------------------------------");
            System.out.println("****************** Main Menu **********************");
            System.out.println("---------------------------------------------------");
            System.out.println("1. Songs");
            System.out.println("2. Podcast");
            System.out.println("3. Back to Main Menu");
            System.out.println("4. Exit");
            System.out.println("---------------------------------------------------");
            System.out.print("\nEnter you choice : ");
            int choose = sc.nextInt();

            switch (choose){
                case 1:
                    songService.withoutLoginMenu();
                    break;
                case 2:
                    podcastService.withoutLoginPodcast();
                    break;
                case  3:
                    menu(id);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Entered Invalid Option");
            }
        }
    }

    public void userMenu(){
        while (true){
            System.out.println("---------------------------------------------------------------------");
            System.out.println("************************ Welcome to User ***************************");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. User Details");
            System.out.println("2. Change Your Password");
            System.out.println("3. Change Your User Name");
            System.out.println("4. Delete Your Account");
            System.out.println("5. Back to Main Menu");
            System.out.println("6. Exit");
            System.out.print("\nEnter Your Choice :");
            int choose = sc.nextInt();
            int usId =0;
            switch (choose){

                case 1:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("-------------------------- User Information -------------------------");
                    System.out.print("\nEnter User your Id : ");
                    int userId = sc.nextInt();
                    userInterface.userDetails(userId);
                    break;
                case 2:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("------------------------ Change Your Password -----------------------");
                    System.out.print("\nEnter User Id : ");
                    int uId = sc.nextInt();
                    System.out.print("Enter old Password  : ");
                    String pwd = sc.next();
                    userInterface.changePassword(pwd,uId);
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("------------------------ Change Your User Name -----------------------");
                    System.out.print("\nEnter User Id : ");
                    int urId = sc.nextInt();
                    System.out.print("Enter your Password  : ");
                    String pwds = sc.next();
                    userInterface.changeUserName(pwds,urId);
                    break;
                case 4:
                    System.out.println("---------------------------------------------------------------------");
                    System.out.println("-------------------------- Delete Account --------------------------");
                    System.out.print("\nEnter User Id to delete your Account : ");
                    usId = sc.nextInt();
                    userInterface.deleteUserAccount(usId);
                    break;
                case 5:
                    menu(usId);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

}
