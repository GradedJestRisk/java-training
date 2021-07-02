package client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public String getGreeting() {

        return "Hello World!";
    }

    public static void main(String[] args) {
        //System.out.println(new App().getGreeting());
        String url = "jdbc:postgresql://localhost:5432/database";
        String user = "user";
        String password = "password";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();
            String query = "SELECT id, value FROM foo LIMIT 2";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println("result: " + rs.getString("id") + " - " + rs.getString("value"));
            }

            String bindedQuery = "SELECT id, value FROM foo WHERE id > ? LIMIT 2";
            PreparedStatement pstmt = con.prepareStatement(bindedQuery);

            Integer fooId = 156;
            pstmt.setInt(1, fooId);
            ResultSet rs2 = pstmt.executeQuery();

            while (rs2.next()) {
                System.out.println("result: " + rs2.getString("id") + " - " + rs2.getString("value"));
            }

        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(App.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}