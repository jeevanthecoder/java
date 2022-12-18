import org.sqlite.jdbc3.JDBC3Connection;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
 static DBOPERATION DBop = new DBOPERATION();
    static Connection c=null;
    static Statement stmt = null;
    

    public static void main(String[] args) {
        WHAT_WE_DO();
        INPUT_ANALYSE();
    }
    public static void INPUT_ANALYSE(){
        String commands = scan.nextLine();
        String command_split[] = commands.split(",");

        for(int i=0;i<command_split.length;i++){
            if(command_split[i].equals("generate-password")){
                getAlphaNumericString();
            }else if(command_split[i].equals("create-database")){
                DBop.CREATE_DATABASE();
                System.out.println("Database Created!!!");
            } else if (command_split[i].equals("insert-data")) {

                DBop.INSERT_DATA();


            } else if (command_split[i].equals("update-operation")) {
                DBop.UPDATE_OPERATION();
                System.out.println("Updated!!!");

            }else if (command_split[i].equals("get-data")){
                DBop.PRINT_DBFILE();
                System.out.println("That's it!!!");
            }else if(command_split[i].equals("create-database")){
                DBop.CREATE_DATABASE();
            }else if(command_split[i].equals("create-table")){
                String file[] = DBop.CHOOSE_DATABASE().split(",");

                String filename=file[0];
                String directory=file[1];

                DBop.CREATE_TABLE(filename,directory);
            } else if (command_split[i].equals("delete")) {
                DBop.DELETE_OPERATION();

            } else if (command_split[i].equals("get-password")) {
                DBop.GET_PASSWORD();

            }
        }
    }



    public static void WHAT_WE_DO() {
       try(FileReader fr = new FileReader("D:\\Java\\java workspace\\PasswordGenerator\\src\\WHAT_WE_DO.txt")) {
           int i;
           // Holds true till there is nothing to read
           while ((i = fr.read()) != -1) {

               // Print all the content of a file
               System.out.print((char) i);
           }
           System.out.println("\nEnter Command : ");
       }catch(Exception e){
           System.out.println(e);
       }

    }

    private static void getAlphaNumericString()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz"
                + "~!@#$%^&*()"
                + "-_+=|{}[];:',<.>/?";

        String AlphaNumericString1 =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        String AlphaNumericString2 =  "0123456789"
                +"abcdefghijklmnopqrstuvxyz"
                + "~!@#$%"
                ;
        String password ="";
        int n=0;
        System.out.println("Enter the strength of the password (weak,moderate,strong):");


            switch (scan.next()) {
                case "weak":
                    password = AlphaNumericString1;
                    n = 8;
                 break;
                case "moderate":
                    password = AlphaNumericString2;
                    n = 10;
                    break;
                case "strong":
                    password = AlphaNumericString;
                    n = 12;

                    break;
                default:
                    System.out.println("Input MisMatch");
                    System.out.println("Do you want to bypass this process And Set default strength password? (Type Yes or No)");

                    if (scan.next().equals("Yes")) {
                        System.out.println("Setting default password strength(moderate).");
                        password = AlphaNumericString2;
                        n = 10;


                    }else if (scan.next().equals("No")) {
                            System.out.println("Terminating the program!!!");
                            System.exit(0);

                    }

                    break;
            }



     if (n == 0) {
         System.out.println("Cannot generate password!!!");
     }else{
         StringBuilder sb = new StringBuilder(n);

         for (int i = 0; i < n; i++) {

             int index = (int) (password.length()* Math.random());

             sb.append(password.charAt(index));
         }

         System.out.println("Your Password: " + sb.toString());
         System.out.println("Do you want to save the password?(Type Yes or No)");
         if(scan.next().equals("Yes")){
             password=sb.toString();
             String Directory="D:\\Java\\java workspace\\PasswordGenerator";
             try{
                 c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\" + "password.db");
                 stmt=c.createStatement();
                 System.out.println("Enter AccountName:");
                 String name=scan.next();
                 stmt.execute("CREATE TABLE IF NOT EXISTS PASSWORD "+
                         "(ACCOUNTNAME TEXT, PASSWORDS TEXT)");
                stmt.execute("INSERT INTO 'PASSWORD' ('ACCOUNTNAME', 'PASSWORDS')" + "VALUES('"+name+"','"+password+"')");
                 System.out.println("Password saved with account "+name);

                 stmt.close();
                 c.close();

             }catch(Exception e){
                 System.out.println( e);
             }


         }


     }

    }



}
