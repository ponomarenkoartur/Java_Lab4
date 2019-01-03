package ua.nure.ponomarenko.task4;

import java.util.Iterator;
import java.util.regex.*;

public class Part1 implements Iterable {

    public static final String FILE_PATH = "src/ua/nure/ponomarenko/task4/part1.txt";
    private String text;

    public Part1() {
        text = FileReader.readTextFromFile(FILE_PATH);
    }

    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator {

        private String cursor;
        private boolean didCallHasNextOnCurrentPosition = false;
        private boolean lastHasNext;

        Pattern pattern = Pattern.compile("(?<=\\s|^)[a-zA-Zа-яА-Я]+(?=\\s|$)");
        Matcher matcher = pattern.matcher(text);

        @Override
        public boolean hasNext() {
            if (didCallHasNextOnCurrentPosition) {
                return lastHasNext;
            } else if (matcher.find()) {
                cursor = matcher.group();
                didCallHasNextOnCurrentPosition = true;
                lastHasNext = true;
                return true;
            } else {
                didCallHasNextOnCurrentPosition = true;
                lastHasNext = false;
                return false;
            }
        }

        @Override
        public Object next() {
            if (hasNext()) {
                didCallHasNextOnCurrentPosition = false;
                lastHasNext = false;
                return cursor;
            } else {
                return null;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}