package ua.nure.ponomarenko.task4;

import java.util.Comparator;
import java.util.List;

public class Part2 {
    public static final String FILE_PATH = "src/ua/nure/ponomarenko/task4/part2.txt";

    public static void main(String[] args) {
        String text = FileReader.readTextFromFile(FILE_PATH);
        List<String> words = Parser.parseWordsFromString(text);
        printWordsInDecreasingFrequencyOrder(words);
    }

    public static void printWordsInDecreasingFrequencyOrder(List<String> words) {
        FreqWordContainer wordContainer = FreqWordContainer.freqWordContainerFromStrings(words);
        wordContainer.sort(Comparator.comparing(FreqWord::getFrequency).reversed());
        for (FreqWord word: wordContainer) {
            System.out.println(word);
        }
    }

}
