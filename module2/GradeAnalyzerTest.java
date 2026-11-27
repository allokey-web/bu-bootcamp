
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class GradeAnalyzerTest {

    @Test
    void calculateAverage_returnsCorrectAverage_forNormalInput() {

        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(80, 90, 100));

        assertEquals(90.0,
                GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverage_returnsZero_whenListIsEmpty() {

        ArrayList<Integer> scores = new ArrayList<>();

        assertEquals(0.0,
                GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverage_returnsValue_forSingleItem() {

        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(85));

        assertEquals(85.0,
                GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverage_returnsSameValue_whenAllScoresAreEqual() {

        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(75, 75, 75));

        assertEquals(75.0,
                GradeAnalyzer.calculateAverage(scores), 0.001);
    }

    @Test
    void calculateAverage_handlesLargeValues_withoutOverflow() {

        ArrayList<Integer> scores =
                new ArrayList<>(Arrays.asList(
                        Integer.MAX_VALUE,
                        Integer.MAX_VALUE));

        assertEquals(2147483647.0,
                GradeAnalyzer.calculateAverage(scores), 0.001);
    }
}
