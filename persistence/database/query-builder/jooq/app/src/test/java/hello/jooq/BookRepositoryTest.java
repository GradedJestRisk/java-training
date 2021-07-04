package hello.jooq;

import org.jooq.Record;
import org.jooq.Result;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.*;


class BookRepositoryTest {
    @Test void getBooksPublishedInShouldReturnSomething() {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        BookRepository bookRepository = new BookRepository();
        ResultSet resultSet = bookRepository.getBooksPublishedIn(1948);
        assertNotNull(resultSet, "getBooksPublishedIn should return an object");
    }

    @Test void getAuthorsShouldReturnSomething() {
        System.getProperties().setProperty("org.jooq.no-logo", "true");
        BookRepository bookRepository = new BookRepository();
        Result<Record> result = bookRepository.getAuthors();
        assertNotNull(result, "getAuthors should return an object");
    }
}
