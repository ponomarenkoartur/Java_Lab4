package ua.nure.ponomarenko.task4;

public class FreqWord implements Comparable {
    private String content;
    private int frequency;

    public FreqWord(String content) {
        this.content = content;
        frequency = 1;
    }

    public FreqWord(String content, int frequency) {
        this.content = content;
        this.frequency = frequency;
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void incrementFrequency() {
        frequency++;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof FreqWord)) {
            throw new ClassCastException();
        }
        FreqWord word = (FreqWord)o;
        return frequency - word.frequency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof FreqWord))
            return false;
        FreqWord otherWord = (FreqWord)o;
        if (content == null) {
            return otherWord.content == null;
        } else {
            return content.equals(otherWord.content) &&
                    frequency == otherWord.frequency;
        }
    }

    @Override
    public String toString() {
        return "'" + content + ": " + frequency + "'";
    }
}


