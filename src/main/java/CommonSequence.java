import java.util.ArrayList;
import java.util.List;

/**
 * Created by lliang on 7/2/2017.
 * A sub-sequence of a given sequence is just the given sequence with zero or
 more elements left out. Formally, given a sequence X = (x1; x2; : : : ; xm), another
 sequence Z D= (z1; z2; : : :; zk) is a sub-sequence of X if there exists a strictly
 increasing sequence (i1; i2; : : : ; ik) of indices of X such that for all j = 1; 2; : : : ; k,
 we have Xij = Zj. For example, Z = (B; C; D; B) is a sub-sequence of X D
 (A;B;C;B;D; A;B) with corresponding index sequence (2; 3; 5; 7).
 */
public class CommonSequence {
    public static final int LETTER_COUNT = 26;

    public static class MatchInfo{
        char ch;
        int position;
        int posOnOtherArray;

        public MatchInfo(char ch, int position, int posOnOtherArray) {
            this.ch = ch;
            this.position = position;
            this.posOnOtherArray = posOnOtherArray;
        }


    }
    public static List<List<List<MatchInfo>>> findLongest(char[] charsA, char[] charsB){
        List<List<List<MatchInfo>>> common = new ArrayList<>();
        char[] longerChars, shorterChars;
        if (charsA.length > charsB.length){
            longerChars = charsA;
            shorterChars = charsB;
        }else {
            longerChars = charsB;
            shorterChars = charsA;
        }
        List<List<Integer>> signature = buildSignature(longerChars);
        addOneMoreLetter(shorterChars, common, 1, signature);
        return common;
    }

    public static void addOneMoreLetter(char[] shorterArray,  List<List<List<MatchInfo>>> common,
                                        int level,  List<List<Integer>> signature){
        if (level > shorterArray.length){
            return;
        }
        List<List<MatchInfo>> lists = new ArrayList<>();
        if (1 == level){

            for (int i = 0; i < shorterArray.length; i++){
                int posOnOtherArray = getLetterPosition(signature, shorterArray[i], 0);
                if (-1 < posOnOtherArray){
                    MatchInfo matchInfo = new MatchInfo(shorterArray[i], i, posOnOtherArray);
                    List<MatchInfo> matchInfoList = new ArrayList<>();
                    matchInfoList.add(matchInfo);
                    lists.add(matchInfoList);
                }
            }
        }else {
            List<List<MatchInfo>> longerSequences = common.get(level-2);
            for (List<MatchInfo> matchInfoList : longerSequences){
                MatchInfo matchInfo = matchInfoList.get(matchInfoList.size()-1);
                for (int i = matchInfo.position+1; i < shorterArray.length; i++) {
                    int posOnOtherArray = getLetterPosition(signature, shorterArray[i], matchInfo.posOnOtherArray + 1);
                    if (-1 < posOnOtherArray) {
                        MatchInfo newMatchInfo = new MatchInfo( shorterArray[i], i, posOnOtherArray);
                        List<MatchInfo> newList = cloneList(matchInfoList);
                        newList.add(newMatchInfo);
                        lists.add(newList);
                    }
                }
            }
        }
        if (0 != lists.size()) {
            common.add(level-1,lists);
            addOneMoreLetter(shorterArray, common, level + 1, signature);
        }
    }
    public static boolean isInSequence(List<Character> common, char toFind){
        boolean ret = false;
        for (Character ch : common){
            if (ch == toFind){
                ret = true;
                break;
            }
        }
        return ret;
    }

    public static int getLetterPosition( List<List<Integer>> signature, char ch, int cursor){

        int ret = -1;
        int index = Character.toLowerCase(ch) - 'a';
        List<Integer> letterPositions = signature.get(index);
        for (Integer position : letterPositions){
            if (position >= cursor){
                ret = position;
                break;
            }
        }
        return  ret;
    }

    public static List<List<Integer>> buildSignature(char[] chars){
        List<List<Integer>> ret =new ArrayList<>(LETTER_COUNT);
        for (int i = 0; i <LETTER_COUNT; i++ ){
            List<Integer> integerList = new ArrayList<>();
            ret.add(integerList);
        }
        for(int i = 0; i < chars.length; i++){
            int index = Character.toLowerCase(chars[i]) - 'a';
            List<Integer> list = ret.get(index);
            list.add(i);
        }
        return ret;
    }
    public static List<MatchInfo> cloneList(List<MatchInfo> list) {
        List<MatchInfo> clone = new ArrayList<>(list.size());
        for (MatchInfo item : list){
            clone.add(new MatchInfo(item.ch, item.position, item.posOnOtherArray));
        }
        return clone;
    }
}
