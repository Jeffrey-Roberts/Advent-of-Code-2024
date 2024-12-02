package Day02;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Nested
    class PartOne {
        @Test
        void findSafeReports() {
            String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;

            List<List<Integer>> result = Solution.findSafeReports(input);
            assertEquals(2, result.size());
        }
    }

    @Nested
    class PartTwo {
        @Test
        void findSafeReportsWithProblemDampener() {
            String input = """
                7 6 4 2 1
                1 2 7 8 9
                9 7 6 2 1
                1 3 2 4 5
                8 6 4 4 1
                1 3 6 7 9
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(4, result.size());
        }

        @Test
        void findSafeReportsWithProblemDampener_WhereLastElementCanBeRemoved_WhenIncrementing() {
            String input = """
                1 3 6 7 5
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(1, result.size());
        }

        @Test
        void findSafeReportsWithProblemDampener_WhereLastElementCanBeRemoved_WhenDecrementing() {
            String input = """
                7 6 4 2 3
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(1, result.size());
        }

        @Test
        void findSafeReportsWithProblemDampener_WhereFirstElementCanBeRemoved_WhenIncrementing() {
            String input = """
                0 3 6 7 9
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(1, result.size());
        }

        @Test
        void findSafeReportsWithProblemDampener_WhereFirstElementCanBeRemoved_WhenDecrementing() {
            String input = """
                4 6 4 2 1
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(1, result.size());
        }

        @Test
        void findSafeReportsWithProblemDampenerEdgeCase() {
            String input = """
                5 1 7 8 9
                """;
            List<List<Integer>> result = Solution.findSafeReportsWithProblemDampener(input);
            assertEquals(1, result.size());
        }
    }
}