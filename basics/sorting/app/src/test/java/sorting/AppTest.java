package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    public class Player implements Comparable<Player> {
        private int ranking;
        private String name;
        private int age;
        public Player(int ranking, String name, int age){
            this.ranking = ranking;
            this.name = name;
            this.age = age;
        }
        private int getRanking(){
            return this.ranking;
        }

        @Override
        public int compareTo(Player otherPlayer) {
            return Integer.compare(getRanking(), otherPlayer.getRanking());
        }

    }

    @DisplayName("Using Comparable interface")
    @Test void sortByProperty() {
        // given
        List<Player> footballTeam = new ArrayList<>();
        Player john = new Player(2, "John", 20);
        Player roger = new Player(1, "Roger", 22);
        Player steven = new Player(3, "Steven", 24);
        footballTeam.add(john);
        footballTeam.add(roger);
        footballTeam.add(steven);

        // when
        Collections.sort(footballTeam);

        // then
        List<Player> expected = new ArrayList<>();
        expected.add(roger);
        expected.add(john);
        expected.add(steven);

        assertEquals(footballTeam, expected);
    }
}
