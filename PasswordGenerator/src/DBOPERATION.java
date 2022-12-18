import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.sql.*;
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
                if(!matchingFiles[i].getName().equals("password.db")) {
                    System.out.println(matchingFiles[i].getName());
                }
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

        System.out.println("Which type of data do you want to store?( CREDIT-CARD or DEBIT-CARD or LOGIN-DETAILS)");
        String data = scan.nextLine();

        if(!DBFile.isEmpty()) {
            try {
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFile);

                if(data.equals("LOGIN-DETAILS")) {
                    System.out.println("Enter the table name you want: ");
                   String tablename= scan.nextLine();

                    stmt = c.createStatement();
                    stmt.execute("CREATE TABLE " +tablename+
                            "(ID             TEXT    ," +
                            "ACCOUNTNAME     TEXT    ," +
                            "USERNAME        TEXT    ," +
                            "PASSWORD        TEXT    )");
                    stmt.close();
                    System.out.println("new table created");
                }else if(data.equals("CREDIT-CARD")){
                    System.out.println("Enter the table name you want: ");
                    String tablename= scan.nextLine();

                    stmt = c.createStatement();
                    stmt.execute("CREATE TABLE " +tablename+
                            "(ID            TEXT     ," +
                            "CARDNUMBER     TEXT    ," +
                            "EXPIRYDATE       TEXT    ," +
                            "CVV        INTEGER);");
                    stmt.close();
                    System.out.println("new table created!!!");
                }else if(data.equals("DEBIT-CARD")){
                    System.out.println("Enter the table name you want: ");
                    String tablename= scan.nextLine();

                    stmt = c.createStatement();
                    stmt.execute("CREATE TABLE " + tablename+
                            "(ID            TEXT     ," +
                            "CARDNUMBER     TEXT    ," +
                            "EXPIRYDATE        TEXT," +
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
                        System.out.println("Account " + (i+1) + " : ");
                        System.out.println("\nEnter the ID number : ");
                        Long id = scan.nextLong();
                        System.out.println("AccountName : ");
                        AccountName = scan.next();
                        System.out.println("Username : ");
                        userName = scan.next();
                        System.out.println("Password : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,ACCOUNTNAME,USERNAME,PASSWORD) " +
                                "VALUES (" + id + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");
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
                        System.out.println("Account " + (i+1) + " : ");
                        System.out.println("\nEnter the ID number : ");
                        Long id = scan.nextLong();
                        System.out.println("CARDNUMBER : ");
                        AccountName = scan.next();
                        System.out.println("EXPIRYDATE : ");
                        userName = scan.next();
                        System.out.println("CVV : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,CARDNUMBER,EXPIRYDATE,CVV) " +
                                "VALUES (" + id + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");

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
                        System.out.println("Account " + (i+1) + " : ");
                        System.out.println("\nEnter the ID number : ");
                        Long id = scan.nextLong();
                        System.out.println("CARDNUMBER : ");
                        AccountName = scan.next();
                        System.out.println("EXPIRYDATE : ");
                        userName = scan.next();
                        System.out.println("CVV : ");
                        Password = scan.next();

                        stmt.execute("INSERT INTO " + TABLENAME + " (ID,CARDNUMBER,EXPIRYDATE,CVV) " +
                                "VALUES (" + id + ",'" + AccountName + "', '" + userName + "', '" + Password + "')");
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


            System.out.println("Enter the file name:");

            strName = br.readLine();
            System.out.println("Enter the file path:");

            strPath = br.readLine();

            File file1
                    = new File(strPath + "\\" + strName + "");

            file1.createNewFile();
            System.out.println("Created new .db file!!!");
        }

        catch (Exception ex1) {
            System.out.println(ex1);
        }
        return strName+","+strPath;

    }

    public static void UPDATE_OPERATION(){
        Scanner scan = new Scanner(System.in);
        Connection c;
        Statement stmt;
        String Table,Data1,updatedata;
        String D = CHOOSE_DATABASE();
        String Files[]=D.split(",");
        String DBFileName = Files[0];
        String DBDirectory = Files[1];
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
    public void GET_PASSWORD(){

        Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;


        try {
            con = DriverManager.getConnection("jdbc:sqlite:D:\\Java\\java workspace\\PasswordGenerator\\password.db");
            System.out.println("\nEnter the ACCOUNTNAME : ");
            String account = scan.nextLine();
            // SQL command data stored in String datatype
            String sql = "select * from PASSWORD where ACCOUNTNAME = '"+account+"';";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            System.out.println("\nPassword : \n");

            while (rs.next()) {

                String ac = rs.getString("ACCOUNTNAME");
                String pwd = rs.getString("PASSWORDS");

                System.out.println(ac+" : ");
                System.out.print("******"+pwd+"*******");
            }
        }

        catch (SQLException e) {

            System.out.println(e);
        }


    }
    public static void PRINT_DBFILE() {
        String input =CHOOSE_DATABASE();
        String input1[]=input.split(",");
        String DBDirectory = input1[1];
        String DBFile = input1[0];
      Connection con = null;
        PreparedStatement p = null;
        ResultSet rs = null;


        try {
            con = DriverManager.getConnection("jdbc:sqlite:"+DBDirectory+"\\"+DBFile);

            String sql = "select * from CREDIT";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            System.out.println("ID\t\tCARDNUMBER\t\tEXPIRYDATE\tCVV");

            while (rs.next()) {

                String id = rs.getString("ID");
                String CARDNUMBER = rs.getString("CARDNUMBER");
                String EXPIRYDATE = rs.getString("EXPIRYDATE");
                int CVV = rs.getInt("CVV");
                System.out.println(id + "\t\t" +CARDNUMBER
                                   + "\t\t" + EXPIRYDATE+"\t\t"+CVV);
            }
        }

        catch (SQLException e) {

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
        String  input1= scan.nextLine();


        if(input1.equals("table")){
            System.out.println("Enter the table name: ");
            String Table= scan.nextLine();
            try{
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFileName);

                stmt = c.createStatement();

                stmt.execute("DROP TABLE "+Table);

                stmt.close();
                c.close();
            }catch (Exception e){
                System.out.println(e);
            }
        } else if (input1.equals("row")) {
            System.out.println("Enter the table name: ");
            String Table= Main.scan.nextLine();
            System.out.println("Enter ID: ");
            String row = Main.scan.nextLine();
            try{
                c = DriverManager.getConnection("jdbc:sqlite:"+Directory+"\\"+DBFileName);

                stmt = c.createStatement();

                stmt.execute("DELETE from "+Table+" where ID="+row);
                stmt.close();
                c.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

}
