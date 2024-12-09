package Day07;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void findValidEquationsWithAddAndMultiplyOperations() {
        String input = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20
                """;
        Set<Solution.Operation> operations = Set.of(Solution.Operation.ADD, Solution.Operation.MULTIPLY);
        String result = Solution.findValidEquations(input, operations);
        assertEquals("3749", result);
    }

    @Test
    void findValidEquationsWithAddAndMultiplyAndConcatOperations() {
        String input = """
                190: 10 19
                3267: 81 40 27
                83: 17 5
                156: 15 6
                7290: 6 8 6 15
                161011: 16 10 13
                192: 17 8 14
                21037: 9 7 18 13
                292: 11 6 16 20
                """;
        Set<Solution.Operation> operations = Set.of(Solution.Operation.ADD, Solution.Operation.MULTIPLY, Solution.Operation.CONCAT);
        String result = Solution.findValidEquations(input, operations);
        assertEquals("11387", result);
    }
}