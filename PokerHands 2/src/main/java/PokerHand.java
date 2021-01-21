import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PokerHand {
    //field variables
    //we'll "compose" a poker hand from multiple sub-objects that we pull into a collection
    private Card[] cards;

    //need a constructor to make sure every hand is built with all the cards needed
    public PokerHand( Card[] cards ) {
        //for now we'll cross our fingers and hope its always 5
//        if( cards.length < 5 ){
//            //TODO: create a specific exception for this
//            throw new Exception("Invalid number of cards.");
//        }


        this.cards = cards;

        sortCards();
    }

    private void sortCards() {

        //bubble sort
        boolean sorted = false;

        while( !sorted ){

            sorted = true;
            for( int i = 0; i < cards.length - 1; i++){
                //does the element at i need to be flipped with the element at i + 1?
                if( (cards[i].getCardValue().value < cards[i+1].getCardValue().value) ||

                        (cards[i].getCardValue().value == cards[i+1].getCardValue().value
                        && cards[i].getCardSuit().value < cards[i+1].getCardSuit().value
                        )
                ){
                    //we need to swap elements at i and i + 1
                    //it also means we found elements out of order
                    sorted = false;
                    Card temp = cards[i+1];
                    cards[i+1] = cards[i];
                    cards[i] = temp;
                }
            }

        }

    }

    public Card[] getCards(){
        return cards;
    }

    public Map<FaceValue, Integer> countFaceValues(){

        Map<FaceValue, Integer> count = new HashMap<>();

        for( Card toCount : cards ){
            if( !count.containsKey(toCount.getCardValue())){
                count.put(toCount.getCardValue(), 0);
            }

            Integer currentCount = count.get(toCount.getCardValue());

            count.put( toCount.getCardValue(),
                    1 + currentCount );

        }

        return count;
    }

    public Map<Suit, Integer> countSuits(){

        Map<Suit, Integer> count = new HashMap<>();

        for( Card toCount : cards ){
            if( !count.containsKey(toCount.getCardSuit())){
                count.put(toCount.getCardSuit(), 0);
            }

            Integer currentCount = count.get(toCount.getCardSuit());

            count.put( toCount.getCardSuit(),
                    1 + currentCount );

        }

        return count;
    }


    //if no straight, return a null
    public FaceValue straightHighCardValue(){
        for(int i = 0; i < cards.length - 1; i++) {
            if(cards[i].getCardValue().value - 1 != cards[i + 1].getCardValue().value) {
                return null;
            }
        }
        return cards[0].getCardValue();
    }

    public boolean isFlush(){
        Map<Suit, Integer> suits = countSuits();
        for(Map.Entry<Suit, Integer> entry : suits.entrySet()) {
            if(entry.getValue() == 5) {
                return true;
            }
        }
        return false;
    }

    public boolean isStraightFlush(){
        return (straightHighCardValue() != null) && isFlush();
    }

    public boolean isFullHouse(){
        return pairValue() != null && threeOfAKindValue() != null;
    }

    public boolean isRoyalFlush(){
        return isStraightFlush() && cards[0].getCardValue() == FaceValue.ACE;
    }

    //if not 4 of a kind, return null
    public FaceValue fourOfAKindValue(){
        Map<FaceValue, Integer> faceValues = countFaceValues();
        for(Map.Entry<FaceValue, Integer> entry : faceValues.entrySet()) {
            if(entry.getValue() == 4) {
                return entry.getKey();
            }
        }
        return null;
    }

    //should return null if there are really 4
    public FaceValue threeOfAKindValue(){
        Map<FaceValue, Integer> faceValues = countFaceValues();
        for(Map.Entry<FaceValue, Integer> entry : faceValues.entrySet()) {
            if(entry.getValue() == 3) {
                return entry.getKey();
            }
        }
        return null;
    }

    //should return null if there are really 3 (or more of the same card)
    public FaceValue pairValue(){
        Map<FaceValue, Integer> faceValues = countFaceValues();
        for(Map.Entry<FaceValue, Integer> entry : faceValues.entrySet()) {
            if(entry.getValue() == 2) {
                return entry.getKey();
            }
        }
        return null;
    }

    //should return null when there is only one pair
    public FaceValue lowerPairValue(){
        List<FaceValue> pairs = new ArrayList<>();
        Map<FaceValue, Integer> faceValues = countFaceValues();
        for(Map.Entry<FaceValue, Integer> entry : faceValues.entrySet()) {
            if(entry.getValue() == 2) {
                pairs.add(entry.getKey());
            }
        }
        if(pairs.size() <= 1) return null;
        return pairs.get(0).value > pairs.get(1).value ? pairs.get(1) : pairs.get(0);
    }

    //return 0 if "this" ties with "that"
    //return negative number if "this" wins over "that"
    //return positive number if "this" loses to "that"
    //Royal flush. A, K, Q, J, 10, all the same suit.
    //Straight flush. Five cards in a sequence, all in the same suit.
    //Four of a kind. All four cards of the same rank.
    //Full house. Three of a kind with a pair.
    //Flush. ...
    //Straight. ...
    //Three of a kind. ...
    //Two pair.
    public int compareTo( PokerHand that ){
        int result = 0;
        if(this.isRoyalFlush() && !that.isRoyalFlush()) {
            result = -1;
        } else if(that.isRoyalFlush()) {
            result = 1;
        } else if(this.isStraightFlush() && !that.isStraightFlush()) {
            result = -1;
        } else if(that.isStraightFlush() && !this.isStraightFlush()) {
            result = 1;
        }else if(this.isStraightFlush() && that.isStraightFlush())
        {
            if(this.straightHighCardValue().value > that.straightHighCardValue().value)
            {
                result = -1;
            }
            else if(this.straightHighCardValue().value < that.straightHighCardValue().value)
            {
                result = 1;
            }
        }
        else if(this.fourOfAKindValue() != null && that.fourOfAKindValue() != null) {
            if(this.fourOfAKindValue().value > that.fourOfAKindValue().value) {
                result = -1;
            }
            else result = 1;
        } else if(that.fourOfAKindValue() != null) {
            result = 1;
        } else if(this.isFullHouse() && !that.isFullHouse()) {
            result = -1;
        } else if(that.isFullHouse()) {
            result = 1;
        } else if(this.isFlush() && !that.isFlush()) {
            result = -1;
        } else if(that.isFlush()) {
            result = 1;
        } else if(this.straightHighCardValue() != null && that.straightHighCardValue() != null) {
            if(this.straightHighCardValue().value > that.straightHighCardValue().value) {
                result = -1;
            } else {
                result = 1;
            }
        } else if(this.threeOfAKindValue() != null && that.threeOfAKindValue() != null) {
            if(this.threeOfAKindValue().value > that.threeOfAKindValue().value) {
                result = -1;
            } else {
                result = 1;
            }
        } else if(that.threeOfAKindValue() != null) {
            result = 1;
        } else if(this.pairValue() != null && that.pairValue() != null) {
            if(this.pairValue().value > that.pairValue().value) {
                result = -1;

            } else {
                result = 1;
            }
        } else if(this.pairValue() != null && that.pairValue() == null) {
            result = -1;
        }

        return result;
    }
    //in general compareTo() semantics are
    // - means "this before that"
    // 0 means "they're equal"
    // + means "that before this"

}
