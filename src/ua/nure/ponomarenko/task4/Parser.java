package ua.nure.ponomarenko.task4;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static List<String> parseWordsFromString(String string) {
        List<String> words = new ArrayList<String>();

        Pattern pattern = Pattern.compile("(?<=\\s|^)[a-zA-Zа-яА-Я]+(?=\\s|$)");
        Matcher matcher = pattern.matcher(string);

        while(matcher.find()) {
            words.add(matcher.group());
        }

        return words;
    }

    public static List<String> parseWordsFromString(String string, int maxCountOfWords) {
        List<String> words = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=\\s|^)[a-zA-Zа-яА-Я]+(?=\\s|$)");
        Matcher matcher = pattern.matcher(string);

        while(matcher.find() && maxCountOfWords > 0) {
            words.add(matcher.group());
            maxCountOfWords--;
        }
        return words;
    }

    public static List<Integer> parseIntegersFromString(String string) {
        List<Integer> numbers = new ArrayList<Integer>();

        Pattern pattern = Pattern.compile("(?<=\\s|^)[1-9]+[0-9]*(?=\\s|$)");
        Matcher matcher = pattern.matcher(string);

        while(matcher.find()) {
            try {
                Integer number = Integer.parseInt(matcher.group());
                numbers.add(number);
            } catch (NumberFormatException e) {
                break;
            }
        }
        return numbers;
    }
}
