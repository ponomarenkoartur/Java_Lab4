package ua.nure.ponomarenko.task4;

import javafx.util.Pair;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {
    public static final String RESOURCES_FILE_NAME = "ua/nure/ponomarenko/task4/resources";

    public static void main(String[] args) {
        // Read from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word and localization, enter 'stop' to finish");
        String inputFromConsole = scanner.nextLine();
        while (!inputFromConsole.equals("stop")) {
            // Parse word and loc from input
            List<String> wordAndLoc = Parser.parseWordsFromString(inputFromConsole, 2);
            if (wordAndLoc.size() < 2) {
                System.out.println("Invalid input");
            } else {
                // Create loc from parsed value
                List<Locale> availableLocails = Arrays.asList(Locale.getAvailableLocales());
                Locale loc = new Locale(wordAndLoc.get(1));
                if (!availableLocails.contains(loc)) {
                    System.out.println("Localization not found. Default localization is used.");
                }

                // Get word in required loc
                ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES_FILE_NAME, loc);
                String word = wordAndLoc.get(0);
                try {
                    String wordInLoc = bundle.getString(word);
                    System.out.println(wordInLoc);
                } catch (MissingResourceException e) {
                    System.out.println("Word not found in resources");
                }
            }
            System.out.println("Enter word and localization, enter 'stop' to finish");
            inputFromConsole = scanner.nextLine();
        }
    }
}
