package ua.nure.ponomarenko.task4;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String[] EMPTY_STRING_ARRAY = new String[]{};

    public static void main(String[] args) {
        System.out.println("================================");
        System.out.println("Part1");
        System.out.println("================================");
        Part1 part1 = new Part1();
        for (Iterator itr = part1.iterator(); itr.hasNext();) {
            System.out.println(itr.next());
        }


        System.out.println("================================");
        System.out.println("Part2");
        System.out.println("================================");
        Part2.main(EMPTY_STRING_ARRAY);

        System.out.println("================================");
        System.out.println("Part3");
        System.out.println("================================");
        Part3.main(EMPTY_STRING_ARRAY);

        System.out.println("================================");
        System.out.println("Part4");
        System.out.println("================================");
        Part4.main(EMPTY_STRING_ARRAY);

        System.out.println("================================");
        System.out.println("Part5");
        System.out.println("================================");
        Part5.main(EMPTY_STRING_ARRAY);
    }
}
