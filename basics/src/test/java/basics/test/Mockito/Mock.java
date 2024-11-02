package basics.test.Mockito;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@DisplayName("Mock")
public class Mock {

    @DisplayName("Mock")
    @Nested
    class MockTest {

        @DisplayName("Static")
        @Nested
        class staticMock {


            @DisplayName("without argument")
            @Test
            void staticTest() {

//            https://www.baeldung.com/mockito-mock-static-methods

                try (MockedStatic<StaticUtils> utilities = org.mockito.Mockito.mockStatic(StaticUtils.class)) {
                    utilities.when(StaticUtils::name).thenReturn("Eugen");
                    assertThat(StaticUtils.name()).isEqualTo("Eugen");
                }

                assertThat(StaticUtils.name()).isEqualTo("Baeldung");

            }

            @DisplayName("with argument")
            @Test
            void givenStaticMethodWithArgs_whenMocked_thenReturnsMockSuccessfully() {
                assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);

                try (MockedStatic<StaticUtils> utilities = org.mockito.Mockito.mockStatic(StaticUtils.class)) {
                    utilities.when(() -> StaticUtils.range(2, 6))
                            .thenReturn(Arrays.asList(10, 11, 12));

                    assertThat(StaticUtils.range(2, 6)).containsExactly(10, 11, 12);
                }

                assertThat(StaticUtils.range(2, 6)).containsExactly(2, 3, 4, 5);
            }
        }

        @DisplayName("Classic")
        @Nested
        class classicMock {
            // https://www.baeldung.com/mockito-argument-matchers
            // https://www.digitalocean.com/community/tutorials/mockito-argument-matchers-any-eq
            @DisplayName("Matching any value of a primitive type parameter")
            @Test
            void anyValuePrimitiveTypeParameter() {
                // given
                FlowerService service = mock();
                when(service.wrap(anyString())).thenReturn("A parcel of books");

                // when
                String actual = service.wrap("Something");

                // then
                String expected = "A parcel of books";
                assertEquals(expected, actual);
            }

            @DisplayName("Matching any value of a user type parameter")
            @Test
            void anyValueEnumParameter() {
                // given
                FlowerService service = new FlowerService();

                // when
                String actual = service.wrap(List.of(Flower.ROSE, Flower.DAISY));

                // then
                String expected = "A bouquet of [ROSE, DAISY]";
                assertEquals(expected, actual);

                // given
                FlowerService mockedService = mock();
                when(mockedService.wrap((List<Flower>) any(Object.class))).thenReturn("A bouquet of [BREAD, BUTTER]");

                // when
                String actualMock = mockedService.wrap(List.of(Flower.ROSE, Flower.DAISY));

                // then
                String expectedMock = "A bouquet of [BREAD, BUTTER]";
                assertEquals(expectedMock, actualMock);
            }

        }

//        https://www.baeldung.com/mockito-verify
//        https://blog.the-experts.nl/maikkingma/goodbye-argumentcaptor-welcome-assertarg-oof
//        https://www.baeldung.com/mockito-argument-matchers

    }
}

