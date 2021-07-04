package hello.jooq;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        BookRepository bookRepository = new BookRepository();
        ResultSet resultSet = bookRepository.getBooksPublishedIn(1948);

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
}