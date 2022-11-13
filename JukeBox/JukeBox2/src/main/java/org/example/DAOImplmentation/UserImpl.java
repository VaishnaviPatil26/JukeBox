package org.example.DAOImplmentation;

import org.example.DBConnection;
import org.example.DAOInterface.UserInterface;
import org.example.model.Users;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {
    Scanner sc = new Scanner(System.in);
    @Override
    public List<Users> userDetails(int userId) {
        List<Users> users = new ArrayList<>();
        try {
            Connection con= DBConnection.getConnection();
            String query="select * from Users where userId ='"+userId+"'";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("\nUser Id"+"     "+"User Name"+"     "+"Mobile No");
            while(rs.next()){
                int id =  rs.getInt("userId");
                String name =  rs.getString("userName");
                long mobile = rs.getLong("mobileNo");
                System.out.println(" "+id+"         "+name+"       "+mobile+"\n");
            }
        }catch (Exception e){System.out.println("Error--"+e);}
        return users;
    }

    @Override
    public void changePassword(String password,int id) {
        try {
            int count=0;
            Connection con= DBConnection.getConnection();
            String query="select userId , passwords from Users where userId ="+id+" and passwords = '"+password+"'";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
                count++;
                String pwd = rs.getString("passwords");
                System.out.print("Enter New Password : " );
                String newPassword = sc.next().trim();
                String updatePassword = "update Users set passwords = '" + newPassword + "' where userId=" + id;
                Statement st6 = con.createStatement();
                int row1 = st6.executeUpdate(updatePassword);
                System.out.println("\nYour Password is changed");
            }
            if(count==0){
                System.out.println("-------Invalid Id or Password-------");
            }
        }catch (Exception e){System.out.println(e);}

    }

    @Override
    public void changeUserName(String pwds, int id) {
        try {
            int count=0;
            Connection con= DBConnection.getConnection();
            String query="select userId , passwords from Users where userId ="+id+" and passwords = '"+pwds+"'";
            Statement st= con.createStatement();
            ResultSet rs=st.executeQuery(query);
            while (rs.next()) {
               // String pwd = rs.getString("userName");
                System.out.print("Enter New User Name : " );
                String newUserName = sc.next().trim();
                String updatedName = "update Users set userName = '" + newUserName + "' where userId=" + id;
                Statement st6 = con.createStatement();
                int row1 = st6.executeUpdate(updatedName);
                System.out.println("\n Your User Name is changed");
            }
            if(count==0){
                System.out.println("-------Invalid Id or Password-------");
            }
        }catch (Exception e){System.out.println(e);}
    }

    @Override
    public void deleteUserAccount(int id) {
        try {
            Connection con= DBConnection.getConnection();
            String searchQuery = "delete from Users where userId ='"+id+"'";
            Statement statement = con.createStatement();
            statement.executeUpdate(searchQuery);
            System.out.println("Account is Deleted");
        }catch (Exception e){System.out.println(e);}
    }
}
