package mockito;

// Spies are stubs that also record some information based on how they were called.
// One form of this might be an email service that records how many messages it was sent.
// https://martinfowler.com/bliki/TestDouble.html


import mockito.dependencies.Body;
import mockito.dependencies.Foot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@DisplayName("Spy")
@Nested
class SpyOn {

    @DisplayName("using spy method")
    @Test
    void test1() {
        // Create a spy object
        List<String> spyList = spy(new ArrayList<>());
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // Perform the method call on the spy object
        spyList.add("item");

        // Capture the argument
        verify(spyList).add(captor.capture());

        // Retrieve the captured argument
        String capturedArgument = captor.getValue();
        assertThat(capturedArgument).isEqualTo("item");
    }

    @DisplayName("Dependencies")
    @Nested
    class Dependency{

        @Mock
        Foot leftFoot;

        @InjectMocks
        Body walker = new Body();

        @Captor
        ArgumentCaptor<String> captor;

        @Test
        public void testMethod() {
                // Given

                // When
                walker.move();
                verify(leftFoot).forward(captor.capture());

                // Then
                assertThat(captor.getValue()).isEqualTo("1");
        }
    }

}