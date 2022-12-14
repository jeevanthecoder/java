import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBOPERATION {
   static Scanner scan = new Scanner(System.in);
    public static String CHOOSE_DATABASE(){

        String DBFile="",Directory="",input;

        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter the directory: ");
            Directory = scanner.nextLine();
            System.out.println(Directory);
            File f = new File(Directory);
            File[] matchingFiles = f.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return  name.endsWith(".db");
                }
            });

            System.out.println("Found db files :");
            for(int i=0;i< matchingFiles.length;i++){
                System.out.println(matchingFiles[i].getName());
            }
            System.out.println("Which File Do You Choose? ");
            DBFile= scanner.nextLine();
        }catch (Exception e){
            System.out.println(e);
        }



        return DBFile+","+Directory;

    }

    public static void CREATE_TABLE(String DBFile,String Directory){

        Connection c;
        Statement stmt;
        System.out.println("Enter the table name you want: ");
        String tablename= scan.nextLine();

        System.out.println("Which type of data do you want to store?( CREDIT-CARD or DEBIT-CARD or LOGIN-DETAILS)");
        String data = scan.nextLine();

        if(!DBFile.isEmpty()) {
            try {
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFile);
//                Class.forName("org.sqlite.JDBC");
//                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\" + DBFile);


                if(data.equals("LOGIN-DETAILS")) {

                    stmt = c.createStatement();
//                    String sql = ;
                    stmt.execute("CREATE TABLE " +tablename+
                            "(ID             TEXT    ," +
                            "ACCOUNTNAME     TEXT    ," +
                            "USERNAME        TEXT    ," +
                            "PASSWORD        TEXT    )");
                    stmt.close();
                    System.out.println("new table created");
                }else if(data.equals("CREDIT-CARD")){
                    System.out.println("Enter the table name you want: ");
                    tablename= scan.nextLine();

                    stmt = c.createStatement();
//                    String sql = ;
                    stmt.execute("CREATE TABLE " +tablename+
                            "(ID            TEXT     ," +
                            "CARDNUMBER     TEXT    ," +
                            "EXPIRYDATE-MM-YY       TEXT    ," +
                            "CVV        INTEGER);");
                    stmt.close();
                    System.out.println("new table created!!!");
                }else if(data.equals("DEBIT-CARD")){
                    System.out.println("Enter the table name you want: ");
                    tablename= scan.nextLine();

                    stmt = c.createStatement();
//                    String sql = ;
                    stmt.execute("CREATE TABLE " + tablename+
                            "(ID            TEXT     ," +
                            "CARDNUMBER     TEXT    ," +
                            "EXPIRYDATE MM YY        TEXT," +
                            "CVV        INTEGER);");
                    stmt.close();
                    System.out.println("new table created!!!");
                }else{
                    System.out.println("Do you want to exit the program?(Type Yes or No");
                    String d=scan.nextLine();
                    if(d.equals("Yes")){
                        System.out.println("Terminating the program!!!");
                        System.exit(0);
                    }else{
                        Main.WHAT_WE_DO();
                        Main.INPUT_ANALYSE();
                    }

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }else{
            System.out.println(".db File not Found!!");
            System.out.println("Do you want to choose database? (Type Yes or No)");
            String input=scan.next();
            if(input.equals("Yes")){
                CHOOSE_DATABASE();
            }else{
                System.out.println("Terminating the program!!!");
                System.exit(0);
            }
        }
    }

    public static void INSERT_DATA() {
        String input[]=CHOOSE_DATABASE().split(",");
        String DBFileName=input[0];
        String DBDirectory=input[1];

        System.out.println("Enter type of data the table having : (LOGIN-DETAILS or CREDIT-CARD or DEBIT-CARD");
        String TABLE= scan.next();

        Scanner scan=new Scanner(System.in);
        Connection c;
        Statement stmt;


        try {

            c = DriverManager.getConnection("jdbc:sqlite:" +DBDirectory+"\\"+DBFileName );
            c.setAutoCommit(true);
            stmt = c.createStatement();
            if (TABLE.equals("LOGIN-DETAILS")) {
                String userName, Password, AccountName;
                int TestCases;
                System.out.println("Enter table name:");
                String TABLENAME= scan.nextLine();
                System.out.println("Enter How many account do you enter? ");
                TestCases = scan.nextInt();
                try {
                    for (int i = 0; i < TestCases; i++) {
                        System.out.println("Account " + i + " : ");
                        System.out.println("AccountName : ");
                        AccountName = scan.next();
                        System.out.println("Username : ");
                        userName = scan.next();
                        System.out.println("Password : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,ACCOUNTNAME,USERNAME,PASSWORD) " +
                                "VALUES (" + String.valueOf(i) + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");
                        System.out.println("Data inserted to table "+TABLENAME);
                        stmt.close();
                        c.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else if (TABLE.equals("CREDIT-CARD")) {
                String userName, Password, AccountName;
                int TestCases;
                System.out.println("Enter table name:");
                String TABLENAME= scan.nextLine();
                System.out.println("Enter How many account do you enter? ");
                TestCases = scan.nextInt();
                try {
                    for (int i = 0; i < TestCases; i++) {
                        System.out.println("Account " + i + " : ");
                        System.out.println("CARDNUMBER : ");
                        AccountName = scan.next();
                        System.out.println("EXPIRYDATE : ");
                        userName = scan.next();
                        System.out.println("CVV : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,CARDNUMBER,EXPIRYDATE,CVV) " +
                                "VALUES (" + String.valueOf(i) + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");

                        System.out.println("Data inserted to table "+TABLENAME);
                    }
                    stmt.close();
                    c.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            } else if (TABLE.equals("DEBIT-CARD")) {
                String userName, Password, AccountName;
                int TestCases;
                System.out.println("Enter table name:");
                String TABLENAME= scan.nextLine();
                System.out.println("Enter How many account do you enter? ");
                TestCases = scan.nextInt();
                try {
                    for (int i = 0; i < TestCases; i++) {
                        System.out.println("Account " + i + " : ");
                        System.out.println("CARDNUMBER : ");
                        AccountName = scan.next();
                        System.out.println("EXPIRYDATE : ");
                        userName = scan.next();
                        System.out.println("CVV : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,CARDNUMBER,EXPIRYDATE,CVV) " +
                                "VALUES (" + String.valueOf(i) + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");
                        System.out.println("Data inserted to table "+TABLENAME);

                    }
                    stmt.close();
                    c.close();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }



    public static String CREATE_DATABASE(){
        String strPath = "";
        String strName = "";
        // Try-catch Block
        try (  BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in))){

            // Creating BufferedReadered object

            System.out.println("Enter the file name:");

            // Reading File name
            strName = br.readLine();
            System.out.println("Enter the file path:");

            // Reading File Path
            strPath = br.readLine();

            // Creating File Object
            File file1
                    = new File(strPath + "\\" + strName + "");

            // Method createNewFile() method creates blank
            // file.
            file1.createNewFile();
            System.out.println("Created new .db file!!!");
        }

        // Try-Catch Block
        catch (Exception ex1) {
            System.out.println(ex1);
        }
        return strName+","+strPath;

    }

    public static void UPDATE_OPERATION(){
        Scanner scan = new Scanner(System.in);
        Connection c;
        Statement stmt;
        String Table,Data,Data1,updatedata;
        String D = CHOOSE_DATABASE();
        String Files[]=D.split(",");
        String DBFileName = Files[0];
        String DBDirectory = Files[1];
//        System.out.println("Enter the DbFilename: ");
//        DBFileName=scan.next();
        System.out.println("Enter the Table Name: ");
        Table=scan.nextLine();
        System.out.println("Enter the Data which the Table stores.(LOGIN-DETAILS or CREDIT-CARD or DEBIT-CARD)");
        Data=scan.nextLine();
        if(Data.equals("LOGIN-DETAILS")){
            boolean flag=false;
            while(flag) {
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
                    flag=false;
                }if(a.equals("No")){
                    flag=true;
                }

            }
        }else if(Data.equals("CREDIT-CARD")){
            boolean flag=false;
            while(flag) {
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
                    flag=false;
                }if(a.equals("No")){
                    flag=true;
                }

            }

        }else if(Data.equals("DEBIT-CARD")){
            boolean flag=false;
            while(flag) {
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
                    flag=false;
                }if(a.equals("No")){
                    flag=true;
                }

            }
        }



    }
    public static void PRINT_DBFILE() {
        //This method isn't taking ".tables" command
        String input[] = CHOOSE_DATABASE().split(",");
        String DBFileName = input[0];
        String Directory = input[1];
        Connection c;
        Statement stmt;

        try {

            c = DriverManager.getConnection("jdbc:sqlite:" +Directory+"\\"+DBFileName);
            c.setAutoCommit(false);
            stmt =c.createStatement();
            String sql = "tables";
            System.out.println("Tables found in this .db file:");
            stmt.executeUpdate("."+sql);
            System.out.println("\nEnter the table to print: ");
            String Table = Main.scan.nextLine();

            stmt.execute("SELECT * FROM " + Table);
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.out.println(e);
        }


    }




    public static void DELETE_OPERATION(){
        Connection c;
        Statement stmt;
        String input[] = CHOOSE_DATABASE().split(",");
        String DBFileName = input[0];
        String Directory = input[1];
        System.out.println("Do you want to delete the table or a particular row?");
        String  input1= Main.scan.nextLine();


        if(input1.equals("table")){
            System.out.println("Enter the table name: ");
            String Table= Main.scan.nextLine();
            try{
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFileName);
                c.setAutoCommit(false);

                stmt = c.createStatement();
                String sql = "DROP TABLE "+Table;
                stmt.executeUpdate(sql);
                c.commit();
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (input1.equals("row")) {
            System.out.println("Enter the table name: ");
            String Table= Main.scan.nextLine();
            System.out.println("Enter username number: ");
            String row = Main.scan.nextLine();
            try{
                Class.forName("org.sqlite.JDBC");
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFileName);
                c.setAutoCommit(false);

                stmt = c.createStatement();
                String sql = "DELETE from "+Table+" where ID="+row;
                stmt.executeUpdate(sql);
                c.commit();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
