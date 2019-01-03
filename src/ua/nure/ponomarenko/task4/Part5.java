package ua.nure.ponomarenko.task4;

import java.util.*;

public class Part5 {
    public static final String FILE_PATH = "src/ua/nure/ponomarenko/task4/part5.txt";

    public static void main(String[] args) {
        String fileText = FileReader.readTextFromFile(FILE_PATH);
        List<String> words = Parser.parseWordsFromString(fileText);
        List<FreqWord> threeMostCommonWords = findMostCommonWords(3, words);
        for (FreqWord word: threeMostCommonWords) {
            System.out.println(word.getContent() + " ==> " + word.getFrequency());
        }
    }

    public static FreqWordContainer findMostCommonWords(int numberOfWords, List<String> words) {
        // Getting words with frequencies from 'words' list
        FreqWordContainer wordContainer = FreqWordContainer.freqWordContainerFromStrings(words);

        wordContainer.sort(Comparator.comparing(FreqWord::getFrequency).reversed());
        // return top [numberOfWords] words
        if (wordContainer.size() > numberOfWords) {
            return new FreqWordContainer(wordContainer.subList(0, numberOfWords));
        } else {
            return wordContainer;
        }
    }
}