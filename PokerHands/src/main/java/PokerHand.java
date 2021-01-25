import java.util.HashMap;
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

    //counts the number of values in a hand using maps
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

    //counts the number of suits in a hand using maps
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

        for (int i = 0; i < cards.length-1; i++) {
            if(cards[i].getCardValue().value != cards[i+1].getCardValue().value+1)
            {
                return null;
            }
        }
     return cards[0].getCardValue();
    }

    public boolean isFlush(){
        Map<Suit, Integer> suits = countSuits();
      if(suits.size() == 1)
      {
          return true;
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
        Map<FaceValue, Integer> values = countFaceValues();
        int count = 0;
        FaceValue match = this.cards[0].getCardValue();
        for(FaceValue key : values.keySet())
        {
            System.out.println("From 4 of a kind method, the key is: " + key);
            if(key != match)
            {
                if(count < 5) {
                    count++;
                    match = this.cards[0+count].getCardValue();
                }

            }

        }
        if(count == 0)
        {
            return match;
        }
        else
        {
            match = null;
        }
        return match;
    }

    //should return null if there are really 4
    public FaceValue threeOfAKindValue(){
        Map<FaceValue, Integer> values = countFaceValues();

        throw new UnsupportedOperationException();
    }

    //should return null if there are really 3 (or more of the same card)
    public FaceValue pairValue(){
        Map<FaceValue, Integer> suits = countFaceValues();
        throw new UnsupportedOperationException();
    }

    //should return null when there is only one pair
    public FaceValue lowerPairValue(){
        throw new UnsupportedOperationException();
    }




    //return 0 if "this" ties with "that"
    //return negative number if "this" wins over "that"
    //return positive number if "this" loses to "that"
    public int compareTo( PokerHand that ){
        int result = 0;
        return result;
//        throw new UnsupportedOperationException();
    }

    //in general compareTo() sematics are
    // - means "this before that"
    // 0 means "they're equal"
    // + means "that before this"


}
