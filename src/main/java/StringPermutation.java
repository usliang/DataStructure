import java.util.ArrayList;
import java.util.List;

/**
 * Created by lliang on 5/28/2017.
 */
public class StringPermutation {
    public static List<String> permute(final List<String> list){
        if (null == list || 0 == list.size()){
            return null;
        }
        List<String> ret = new ArrayList<>();
        ret.add(list.get(0));
        for(int i=1; i<list.size(); i++){
            List<String> newList = new ArrayList<>();
            for (String exist : ret){
                for (int j=0; j<= exist.length(); j++){
                    String newStr = exist.substring(0,j) + list.get(i) + exist.substring(j,exist.length());
                    newList.add(newStr);
                }
            }
            ret = newList;
        }
        return ret;
    }
}
