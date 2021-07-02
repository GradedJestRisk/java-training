package test;

import static org.jooq.impl.DSL.*;

import java.sql.*;
import java.sql.Statement;
import java.util.List;

import org.jooq.*;
import org.jooq.impl.*;

public class Main {

//    https://www.jooq.org/doc/3.15/manual/getting-started/use-cases/jooq-as-a-sql-builder-without-codegeneration/
    public static void main(String[] args) {
        String userName = "user";
        String password = "password";
        String url = "jdbc:postgresql://localhost/database";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            Query query = create.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                    .from(table("BOOK"))
                    .join(table("AUTHOR"))
                    .on(field("BOOK.AUTHOR_ID").eq(field("AUTHOR.ID")))
                    .where(field("BOOK.PUBLISHED_IN").eq(1948));
            String sql = query.getSQL();
            List<Object> bindValues = query.getBindValues();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) bindValues.get(0));
            ResultSet resultSet = pstmt.executeQuery();

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = resultSet.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println("");
            }

        } 

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}