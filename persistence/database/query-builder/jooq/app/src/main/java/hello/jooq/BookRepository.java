package hello.jooq;

import org.jooq.DSLContext;
import org.jooq.Query;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.*;
import java.util.List;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.table;

public class BookRepository {

    static String userName = "user";
    static String password = "password";
    static String url = "jdbc:postgresql://localhost/database";

//    https://www.jooq.org/doc/3.15/manual/getting-started/use-cases/jooq-as-a-sql-builder-without-codegeneration/
    public ResultSet getBooksPublishedIn(int year) {

        ResultSet resultSet = null;
        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            Query query = create.select(field("book.title"), field("author.first_name"), field("author.last_name"))
                    .from(table("book"))
                    .join(table("author"))
                    .on(field("book.author_id").eq(field("author.id")))
                    .where(field("book.published_in").eq(year));
            String sql = query.getSQL();
            List<Object> bindValues = query.getBindValues();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, (Integer) bindValues.get(0));
            resultSet = pstmt.executeQuery();
        }

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public Result<Record> getAuthors() {

        Result<Record> result = null;

        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.POSTGRES);
            result = create.select().from(table("author")).fetch();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;

    }
}