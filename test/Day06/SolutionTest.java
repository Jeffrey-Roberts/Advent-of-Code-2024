package Day06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void predictGuardsMovement() {
        String input = """
                ....#.....
                .........#
                ..........
                ..#.......
                .......#..
                ..........
                .#..^.....
                ........#.
                #.........
                ......#...
                """;
        int result = Solution.predictGuardsMovement(input);
        assertEquals(41, result);
    }
}