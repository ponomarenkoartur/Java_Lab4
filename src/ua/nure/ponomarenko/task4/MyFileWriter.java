package ua.nure.ponomarenko.task4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MyFileWriter {

    public static void writeTextToFile(String text, String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeNumbersToFile(List<Integer> numbers, String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < numbers.size(); i++) {
                writer.write(numbers.get(i).toString());
                if (i != numbers.size() - 1) {
                    // Write the 'space' between numbers
                    writer.write(" ");
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
