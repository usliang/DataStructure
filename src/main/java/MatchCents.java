import java.util.*;

/**
 * Created by lliang on 5/28/2017.
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents)
 * and pennies (1 cent), write code to calculate the number of ways of representing n cents.
 */
public class MatchCents {
    static class Combination{
        int centCount;
        int nickelCount;
        int dimeCount;
        int quarterCount;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Combination that = (Combination) o;

            if (centCount != that.centCount) return false;
            if (dimeCount != that.dimeCount) return false;
            if (nickelCount != that.nickelCount) return false;
            if (quarterCount != that.quarterCount) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = centCount;
            result = 31 * result + nickelCount;
            result = 31 * result + dimeCount;
            result = 31 * result + quarterCount;
            return result;
        }

        public Combination(){
            centCount = 0;
            nickelCount = 0;
            dimeCount = 0;
            quarterCount = 0;
        }

        public Combination(Combination a){
            centCount = a.centCount;
            nickelCount = a.nickelCount;
            dimeCount = a.dimeCount;
            quarterCount = a.quarterCount;
        }
    }

    public static Set<Combination> match(final int target){
        Set<Combination> ret = new HashSet<>();
        ret.add(new Combination());
        match(target, 0, ret);
        return ret;
    }

    private static void match(final int target, final int n, final Set<Combination> combinationSet){
        if (n == target){
            return;
        }
        // use a cent
        Set<Combination> newComb = new HashSet<>();
        Iterator<Combination> iter = combinationSet.iterator();
        while(iter.hasNext()){
            Combination combination = iter.next();
            iter.remove();
            combination.centCount++;
            newComb.add(combination);
            newComb.addAll(handleCentIncrease(combination));
        }

        combinationSet.addAll(newComb);
        match(target, n+1, combinationSet);
    }

    private static Set<Combination> handleCentIncrease(final Combination combination) {
        Set<Combination> newComb = new HashSet<>();
        if (5 <= combination.centCount) {
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.nickelCount++;
            newComb.add(newOne);
            newComb.addAll(handleNickelIncrease(newOne));
        }

        if (10 <= combination.centCount) {
            Combination newOne = new Combination(combination);
            newOne.centCount -= 10;
            newOne.dimeCount++;
            newComb.add(newOne);
            newComb.addAll(handleDimeIncrease(newOne));
        }

        if (25 <= combination.centCount) {
            Combination newOne = new Combination(combination);
            newOne.centCount -= 25;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (5 <= combination.centCount && 1 <= combination.nickelCount){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.nickelCount--;
            newOne.dimeCount++;
            newComb.add(newOne);
            newComb.addAll(handleDimeIncrease(newOne));
        }

        if (5 <= combination.centCount && 4 <= combination.nickelCount){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.nickelCount -= 4;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (10 <= combination.centCount && 3 <= combination.nickelCount){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 10;
            newOne.nickelCount -= 3;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (5 <= combination.centCount && 2 <= combination.dimeCount) {
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.dimeCount -= 2;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (15 <= combination.centCount && 1 <= combination.dimeCount) {
            Combination newOne = new Combination(combination);
            newOne.centCount -= 15;
            newOne.dimeCount --;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        return newComb;
    }

    private static Set<Combination> handleNickelIncrease(final Combination newOne){

        Set<Combination> newComb = new HashSet<>();
        //handle 10 cents
        if (2 <= newOne.nickelCount) {
            Combination newTwo = new Combination(newOne);
            newTwo.nickelCount -= 2;
            newTwo.dimeCount++;
            newComb.add(newTwo);
            newComb.addAll(handleDimeIncrease(newTwo));

        }

        if (5 <= newOne.centCount && 1 <= newOne.nickelCount){
            Combination newTwo = new Combination(newOne);
            newTwo.centCount -= 5;
            newTwo.nickelCount--;
            newTwo.dimeCount++;
            newComb.add(newOne);
            newComb.addAll(handleDimeIncrease(newTwo));
        }

        if (5 <= newOne.nickelCount) {
            Combination newThree = new Combination(newOne);
            newThree.nickelCount -= 5;
            newThree.quarterCount++;
            newComb.add(newThree);
        }

        if (20 <= newOne.centCount && 1 <= newOne.nickelCount) {
            Combination newFour = new Combination(newOne);
            newFour.centCount -= 20;
            newFour.nickelCount -= 1;
            newFour.quarterCount++;
            newComb.add(newFour);
        }

        if (15 <= newOne.centCount && 2 <= newOne.nickelCount) {
            Combination newFour = new Combination(newOne);
            newFour.centCount -= 15;
            newFour.nickelCount -= 2;
            newFour.quarterCount++;
            newComb.add(newFour);
        }

        if (10 <= newOne.centCount && 3 <= newOne.nickelCount) {
            Combination newFour = new Combination(newOne);
            newFour.centCount -= 10;
            newFour.nickelCount -= 3;
            newFour.quarterCount++;
            newComb.add(newFour);
        }

        if (5 <= newOne.centCount && 4 <= newOne.nickelCount) {
            Combination newFour = new Combination(newOne);
            newFour.centCount -= 5;
            newFour.nickelCount -= 4;
            newFour.quarterCount++;
            newComb.add(newFour);
        }


        return newComb;
    }

    private static Set<Combination> handleDimeIncrease(final Combination combination){
        Set<Combination> newComb = new HashSet<>();

        if (5 <= combination.centCount && 1 < combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.dimeCount -= 2;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (15 <= combination.centCount && 0 < combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 15;
            newOne.dimeCount -= 1;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (5 <= combination.centCount && 2 <= combination.nickelCount  && 1 <= combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 5;
            newOne.nickelCount -= 2;
            newOne.dimeCount --;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if (10 <= combination.centCount && 1 <= combination.nickelCount  && 1 <= combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.centCount -= 10;
            newOne.nickelCount --;
            newOne.dimeCount --;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if ( 1 <= combination.nickelCount  && 2 <= combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.nickelCount --;
            newOne.dimeCount -= 2;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        if ( 3 <= combination.nickelCount  && 1 <= combination.dimeCount ){
            Combination newOne = new Combination(combination);
            newOne.nickelCount -= 3;
            newOne.dimeCount --;
            newOne.quarterCount++;
            newComb.add(newOne);
        }

        return newComb;
    }

    public static int makeChange(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }
        return ways;
    }
}
