package Day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void calculateTotalDistanceOffset() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;
        int result = Solution.calculateTotalDistanceOffset(input);
        assertEquals(11, result);
    }

    @Test
    void testCalculateTotalDistanceOffset() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;
        int result = Solution.calculateSimilarityScore(input);
        assertEquals(31, result);
    }
}