import java.util.HashMap;
import java.util.Map;

public class Question242ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.compute(s.charAt(i), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                else {
                    return v + 1;
                }

            });
            tMap.compute(t.charAt(i), (k, v) -> {
                if (v == null) {
                    return 1;
                }
                else {
                    return v + 1;
                }

            });
        }

        return sMap.equals(tMap);

    }
    public boolean isAnagramV2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sArray = new int[Character.MAX_VALUE];
        int[] tArray = new int[Character.MAX_VALUE];


        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i)] = sArray[s.charAt(i)] + 1;
            tArray[t.charAt(i)] = tArray[t.charAt(i)] + 1;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (sArray[s.charAt(i)] != tArray[s.charAt(i)]){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        var q = new Question242ValidAnagram();
        System.out.println(q.isAnagram("anagram", "nagaram"));
        System.out.println(q.isAnagram("rat", "car"));
        System.out.println(q.isAnagram("racc", "caar"));
        System.out.println("V2: ");
        System.out.println(q.isAnagramV2("anagram", "nagaram"));
        System.out.println(q.isAnagramV2("rat", "car"));
        System.out.println(q.isAnagramV2("racc", "caar"));
    }
}
