package Day09;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void compactHardDriveByBlock() {
        String input = "2333133121414131402";
        BigInteger result = Solution.compactHardDriveByBlock(input);
        assertEquals(new BigInteger("1928"), result);
    }

    @Test
    void compactHardDriveByFile() {
        String input = "2333133121414131402";
        BigInteger result = Solution.compactHardDriveByFile(input);
        assertEquals(new BigInteger("2858"), result);
    }
}