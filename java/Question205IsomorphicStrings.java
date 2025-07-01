import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/isomorphic-strings/?envType=study-plan-v2&envId=top-interview-150
public class Question205IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Set<Integer>> sMap = new HashMap<>();
        HashMap<Character, Set<Integer>> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            final int index = i;
            sMap.compute(s.charAt(index), (k, v) -> {
                if (v == null) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(index);
                    return hashSet;
                } else {
                    v.add(index);
                    return v;
                }
            });
            tMap.compute(t.charAt(index), (k, v) -> {
                if (v == null) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    hashSet.add(index);
                    return hashSet;
                } else {
                    v.add(index);
                    return v;
                }
            });
        }

        Set<Set<Integer>> sMapSet = new HashSet<>(sMap.values());
        Set<Set<Integer>> tMapSet = new HashSet<>(tMap.values());

        return sMapSet.equals(tMapSet);
    }
    
    public static void main(String[] args) {
        Question205IsomorphicStrings q = new Question205IsomorphicStrings();

        System.out.println(q.isIsomorphic("egg", "add"));

        System.out.println(q.isIsomorphic("foo", "bar"));

        System.out.println(q.isIsomorphic("paper", "title"));
        System.out.println(q.isIsomorphic("p", "t"));
    }
}
