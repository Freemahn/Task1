import java.util.*;

/**
 * Created by Freemahn on 19.06.2016.
 */
public class Roman {
    private static HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();

    static {
        dictionary.put('I', 1);
        dictionary.put('V', 5);
        dictionary.put('X', 10);
        dictionary.put('L', 50);
        dictionary.put('C', 100);
        dictionary.put('D', 500);
        dictionary.put('M', 1000);
    }

    String val;

    public Roman(String s) {
        val = s;
    }

    public Roman(int decimal) {
        StringBuilder res = new StringBuilder();
        List<Integer> values = new ArrayList<Integer>(dictionary.values());
        Collections.sort(values, new Comparator<Integer>() {

            public int compare(Integer o1, Integer o2) {
                return -Integer.compare(o1, o2);
            }
        });
        for (Integer cifer : values) {
            while (decimal >= cifer) {
                decimal -= cifer;
                res.append(getKeyByValue(dictionary, cifer));
            }
        }
        val = res.toString();
    }

    public int toDecimal() {
        int res = 0;
        int current = 0;
        int cifer;
        for (int i = val.length() - 1; i > -1; i--) {
            cifer = dictionary.get(val.charAt(i));
            if (cifer < current) res -= cifer;
            else {
                res += cifer;
                current = cifer;
            }
        }
        return res;
    }

    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
