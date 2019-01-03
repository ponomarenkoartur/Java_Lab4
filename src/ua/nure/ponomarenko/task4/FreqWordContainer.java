package ua.nure.ponomarenko.task4;

import java.util.ArrayList;
import java.util.List;

public class FreqWordContainer extends ArrayList<FreqWord> {

    public FreqWordContainer() {
        super();
    }

    public FreqWordContainer(List<FreqWord> otherContainer) {
        super(otherContainer);
    }

    public FreqWordContainer(FreqWordContainer otherContainer) {
        super(otherContainer);
    }

    public static FreqWordContainer freqWordContainerFromStrings(List<String> strings) {
        FreqWordContainer newContainer = new FreqWordContainer();

        for (String string: strings) {
            boolean wordIsAlreadyInContainer = false;

            // Check if container contains freqWord with content that equals to 'string'.
            // If contains, then increment word's frequency.
            for (FreqWord word: newContainer) {
                if (word.getContent().equals(string)) {
                    wordIsAlreadyInContainer = true;
                    word.incrementFrequency();
                    break;
                }
            }
            // If container doesn't contains word with content that equals to 'string',
            // then add new FreqWord with default frequency '1'.
            if (!wordIsAlreadyInContainer) {
                newContainer.add(new FreqWord(string));
            }
        }

        return newContainer;
    }
}
