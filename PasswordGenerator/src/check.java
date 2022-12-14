import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class check {
    public static void main(String[] args) {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\Java\\java workspace\\PasswordGenerator\\Testing.db");
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS contacts "+
                    "(name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO contacts (name, phone, email) "+
                    "VALUES('joe',4564,'jeo234@gmail.com')");
            System.out.println("\nTable Created in Database.");
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}
