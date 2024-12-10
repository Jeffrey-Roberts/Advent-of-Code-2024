package Day09;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compactHardDrive() {
        String input = "2333133121414131402";
        BigInteger result = Solution.compactHardDrive(input);
        assertEquals(new BigInteger("1928"), result);
    }
}