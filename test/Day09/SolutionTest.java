package Day09;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compactHardDrive() {
        String input = "2333133121414131402";
        int result = Solution.compactHardDrive(input);
        assertEquals(1928, result);
    }
}