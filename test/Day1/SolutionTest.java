package Day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void historianHysteria() {
        String input = """
                3   4
                4   3
                2   5
                1   3
                3   9
                3   3
                """;
        int result = Solution.historianHysteria(input);
        assertEquals(11, result);
    }
}