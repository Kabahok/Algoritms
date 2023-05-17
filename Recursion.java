import java.util.ArrayList;
import java.util.List;

public class Recursion {


    public static void main(String[] args) {
        compare(1);
        compare(2);
        compare(5);
        compare(15);
    }

    public static void compare(int day) {
        System.out.println("=== Day " + day + " ===");
        int[] startNumbers = { 21, 1, 20, 23 };
        int iterative = chooseHobbyIterative(startNumbers, day);
        int recursive = chooseHobbyRecursive(startNumbers, day, new int[day]);
        System.out.println("Iterative = " + iterative + " | Recursive = " + recursive);
        System.out.println();
    }

    public static int chooseHobbyRecursive(int[] startNumbers, int day, int[] memory) {
        if (memory[day - 1] != 0) return memory[day - 1];


        int prev, prePrePrev;
        if (day == 1) {
            prev = startNumbers[startNumbers.length - 1];
            prePrePrev = startNumbers[day];
        } else if (day == 2 || day == 3) {
            prev = chooseHobbyRecursive(startNumbers, day - 1, memory);
            prePrePrev = startNumbers[day];
        } else {
            prev = chooseHobbyRecursive(startNumbers, day - 1, memory);
            prePrePrev = chooseHobbyRecursive(startNumbers, day - 3, memory);
        }

        memory[day - 1] = (prev * prePrePrev) % 10 + 1;
        return (prev * prePrePrev) % 10 + 1;

    }

    public static int chooseHobbyIterative(int[] startNumbers, int day) {
        List<Integer> numbers = new ArrayList<>();

        numbers.add(startNumbers[0]);
        numbers.add(startNumbers[1]);
        numbers.add(startNumbers[2]);
        numbers.add(startNumbers[3]);

        for (int d = 0; d < day; d++) {
            int index = d + 4; // индексы дней в массиве сдвинуты на 4
            int prev = numbers.get(index - 1); // предыдущее значение
            int prePrePrev = numbers.get(index - 3); // пре-пре-предыдущее значение
            numbers.add((prev * prePrePrev) % 10 + 1);
        }

        return numbers.get(numbers.size() - 1);
    }
}