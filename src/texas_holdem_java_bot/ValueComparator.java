package texas_holdem_java_bot;

import java.util.Comparator;

public class ValueComparator implements Comparator<Object> {
    public int compare(Object card1, Object card2) throws ClassCastException{
        // verify two Card objects are passed in
        if (!((card1 instanceof Card) && (card2 instanceof Card))){
            throw new ClassCastException("A Card object was expeected.  Parameter 1 class: " + card1.getClass() 
                    + " Parameter 2 class: " + card2.getClass());
        }

        int rank1 = ((Card)card1).getValueValue();
        int rank2 = ((Card)card2).getValueValue();

        return rank1 - rank2;
    }
}