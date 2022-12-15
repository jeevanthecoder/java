import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class check {
    static DBOPERATION dboperation = new DBOPERATION();
    public static void main(String[] args) {

//        try{
//            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java\\java workspace\\PasswordGenerator\\Testing.db");
//            Statement statement = conn.createStatement();
//            statement.execute("CREATE TABLE IF NOT EXISTS contacts "+
//                    "(name TEXT, phone INTEGER, email TEXT)");
//            statement.execute("INSERT INTO contacts (name, phone, email) "+
//                    "VALUES('joe',4564,'jeo234@gmail.com')");
//            System.out.println("\nTable Created in Database.");
//            statement.close();
//            conn.close();
//        } catch (SQLException e) {
//            e.getStackTrace();
//        }
        Scanner scan = new Scanner(System.in);
        Connection c;
        Statement stmt;
        String Table,Data1,updatedata;
        String D = dboperation.CHOOSE_DATABASE();
        String Files[]=D.split(",");
        String DBFileName = Files[0];
        String DBDirectory = Files[1];
//        System.out.println("Enter the DbFilename: ");
//        DBFileName=scan.next();
        System.out.println("Enter the Table Name: ");
        Table=scan.nextLine();
        System.out.println("Enter the Data which the Table stores.(1.LOGIN-DETAILS or 2.CREDIT-CARD or 3.DEBIT-CARD)");
        int num = scan.nextInt();
        switch(num){
            case 1:
                boolean flag=true;
                while(flag) {
                    System.out.println("Entered to LOGIN-DETAILS!!!");
                    System.out.println("Enter the row number of the table: ");
                    int n = scan.nextInt();
                    System.out.println("What do you want to update :(ACCOUNTNAME or USERNAME or PASSWORD)");
                    updatedata = scan.next();
                    System.out.println("Enter new value of "+updatedata+" : ");
                    Data1= scan.next();
                    try {
//                    Class.forName("org.sqlite.JDBC");
                        c = DriverManager.getConnection("jdbc:sqlite:"+DBDirectory+"\\"+DBFileName);
                        c.setAutoCommit(true);
                        stmt = c.createStatement();

                        stmt.execute("UPDATE "+Table+" set "+updatedata+" = "+Data1+" where ID="+n);
                        stmt.close();
                        c.close();

                    }catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Do you want to update anything else in this table?(Type Yes or No)");
                    String a= scan.next();
                    if(a.equals("Yes")){
                        flag=true;
                    }if(a.equals("No")){
                        flag=false;
                    }

                }
                break;
            case 2:
                boolean flag1=true;
                while(flag1) {
                    System.out.println("Entered to CREDIT-CARD!!!");
                    System.out.println("Enter the row number of the table: ");
                    int n = scan.nextInt();
                    System.out.println("What do you want to update :(CARDNUMBER or EXPIRYDATE(MM/YY) or CVV)");
                    updatedata = scan.next();
                    System.out.println("Enter new value of "+updatedata+" : ");
                    Data1= scan.next();
                    try {
//                    Class.forName("org.sqlite.JDBC");
                        c = DriverManager.getConnection("jdbc:sqlite:"+DBDirectory+"\\"+DBFileName);
                        c.setAutoCommit(true);
                        stmt = c.createStatement();

                        stmt.execute("UPDATE "+Table+" set "+updatedata+" = "+Data1+" where ID="+n);
                        stmt.close();
                        c.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Do you want to update anything else in this table?(Type Yes or No)");
                    String a= scan.next();
                    if(a.equals("Yes")){
                        flag1=true;
                    }if(a.equals("No")){
                        flag1=false;
                    }

                }

                break;
            case 3:
                boolean flag2=true;
                while(flag2) {
                    System.out.println("Entered to DEBIT-CARD!!!");
                    System.out.println("Enter the row number of the table: ");
                    int n = scan.nextInt();
                    System.out.println("What do you want to update :(CARDNUMBER or EXPIRYDATE(MM/YY) or CVV)");
                    updatedata = scan.next();
                    System.out.println("Enter new value of "+updatedata+" : ");
                    Data1= scan.next();
                    try {
//                    Class.forName("org.sqlite.JDBC");
                        c = DriverManager.getConnection("jdbc:sqlite:"+DBDirectory+"\\"+DBFileName);
                        c.setAutoCommit(true);
                        stmt = c.createStatement();

                        stmt.execute("UPDATE "+Table+" set "+updatedata+" = "+Data1+" where ID="+n);
                        stmt.close();
                        c.close();
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    System.out.println("Do you want to update anything else in this table?(Type Yes or No)");
                    String a= scan.next();
                    if(a.equals("Yes")){
                        flag2=true;
                    }if(a.equals("No")){
                        flag2=false;
                    }

                }
                break;



        }

    }

    public static void CREDIT_DETAILS(){
        Scanner scan = new Scanner(System.in);
        Connection c;
        Statement stmt;
        String Table,Data1,updatedata;
        String D = dboperation.CHOOSE_DATABASE();
        String Files[]=D.split(",");
        String DBFileName = Files[0];
        String DBDirectory = Files[1];
//        System.out.println("Enter the DbFilename: ");
//        DBFileName=scan.next();
        System.out.println("Enter the Table Name: ");
        Table=scan.nextLine();
        System.out.println("Enter the Data which the Table stores.(1.LOGIN-DETAILS or 2.CREDIT-CARD or 3.DEBIT-CARD)");
        int num = scan.nextInt();

    }
}
