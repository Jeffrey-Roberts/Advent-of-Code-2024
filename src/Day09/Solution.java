package Day09;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static int compactHardDrive(String input) {
        List<String> disc = parseDiscMap(input);

        return -1;
    }

    private static List<String> parseDiscMap(String discMap) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < discMap.length() /2; i++) {
            int size = Character.getNumericValue(discMap.charAt(i * 2));
            int freeSpace = Character.getNumericValue(discMap.charAt(i * 2 + 1));
            result.append(("%d ".formatted(i)).repeat(size));
            result.append(". ".repeat(freeSpace));
        }
        int lastId = discMap.length() /2;
        result.append(("%d ".formatted(lastId).repeat(Character.getNumericValue(discMap.charAt(discMap.length()-1)))));
        result.trimToSize();
        return Arrays.asList(result.toString().split(" "));
    }

    private static List<String> compact(List<String> disc) {
        int rightPointer = disc.size()-1;
        int leftPointer = -1;
        while (leftPointer < rightPointer) {
            leftPointer++;
            String elem = disc.get(leftPointer);
            if (!elem.equals(".")) continue;

            while (!disc.get(rightPointer).equals(".") && leftPointer < rightPointer){
                rightPointer--;
            }
        }
    }

    private static void calculateCheckSum() {}


}
