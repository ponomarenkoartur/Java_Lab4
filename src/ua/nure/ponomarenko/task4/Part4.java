package ua.nure.ponomarenko.task4;

import java.util.*;


public class Part4 {
    public static final String NUMBERS_FILE_PATH = "src/ua/nure/ponomarenko/task4/part4.txt";
    public static final String SORTED_NUMBERS_FILE_PATH = "src/ua/nure/ponomarenko/task4/part4_sorted.txt";


    public static void main(String[] args) {
        generate();
        process();
        print();
    }

    public static void generate() {
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            numbers.add(randomInt(0, 51));
        }
        MyFileWriter.writeNumbersToFile(numbers, NUMBERS_FILE_PATH);
    }

    public static void process() {
        String numbersString = FileReader.readTextFromFile(NUMBERS_FILE_PATH);
        List<Integer> numbers = Parser.parseIntegersFromString(numbersString);
        Collections.sort(numbers);
        MyFileWriter.writeNumbersToFile(numbers, SORTED_NUMBERS_FILE_PATH);
    }

    public static void print() {
        String inputData = FileReader.readTextFromFile(NUMBERS_FILE_PATH);
        String outputData = FileReader.readTextFromFile(SORTED_NUMBERS_FILE_PATH);
        System.out.println("input ==> " + inputData);
        System.out.println("output ==> " + outputData);
    }

    private static int randomInt(int lowBound, int highBound) {
        Random random = new Random();
        return random.nextInt(highBound - lowBound) + lowBound;
    }
}

