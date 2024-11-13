package nativeQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EntityManager entityManager;

    @DisplayName("Write")
    @Nested
    class Write {

        @DisplayName("#executeUpdate")
        @Nested
        class ExecuteUpdate {

            @DisplayName("Execute query and returns nothing - require @Transactional")
            @Nested
            class returnsNothing {

                @Test
                void test() {
                    // given
                    entityManager.createNativeQuery("TRUNCATE TABLE item").executeUpdate();

                    // when
                    List<Object[]> items = entityManager.createNativeQuery("SELECT * FROM item").getResultList();

                    // then
                    assertThat(items).hasSize(0);
                }
            }
        }

    }

    @DisplayName("Read")
    @Nested
    class Read {

        @DisplayName("#getResultList")
        @Nested
        class getResultList {

            @DisplayName("returns an array of objects")
            @Nested
            class returnsArrayObjects {

                @Test
                void test() {
                    // given
                    entityManager.createNativeQuery("TRUNCATE TABLE item").executeUpdate();
                    entityManager.createNativeQuery("INSERT INTO item (content) VALUES ('hammer');").executeUpdate();

                    // when
                    List<Object[]> people = itemRepository.getAll();

                    // then
                    assertThat(people).hasSize(1);
                }
            }
        }

    }
}