import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
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

    public boolean isIsomorphicV2(String s, String t) {
        // The problem with this one:
        // What if you are replacing the current char with a char that is somewhere else in the string
        for (int i = 0; i < s.length(); i++) {
            s = s.replace(s.charAt(i), (char) i);
            t = t.replace(t.charAt(i), (char) i);
        }
        return s.equals(t);
    }

    public boolean isIsomorphicV3(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            List<Integer> indexesOfCharInS = indexesOfCharacter(s, s.charAt(i), i);
            List<Integer> indexesOfCharInT = indexesOfCharacter(t, t.charAt(i), i);
            if (indexesOfCharInT.equals(indexesOfCharInS)) {
                continue;
            }
            return false;
        }
        return true;
    }

    public List<Integer> indexesOfCharacter(String s, char c, int indexToStartFrom) {

        List<Integer> indexes = new ArrayList<>();
        int index = -1;
        while (-1 != (index = s.indexOf(c, indexToStartFrom))) {
            indexes.add(index);
            indexToStartFrom = index + 1;
            if (indexToStartFrom == s.length()) {
                break;
            }
        }
        return indexes;
    }
    
    public static void main(String[] args) {
        Question205IsomorphicStrings q = new Question205IsomorphicStrings();

        System.out.println(q.isIsomorphic("egg", "add"));

        System.out.println(q.isIsomorphic("foo", "bar"));

        System.out.println(q.isIsomorphic("paper", "title"));
        System.out.println(q.isIsomorphic("p", "t"));

        System.out.println("V2:");
        System.out.println(q.isIsomorphicV2("egg", "add"));

        System.out.println(q.isIsomorphicV2("foo", "bar"));

        System.out.println(q.isIsomorphicV2("paper", "title"));
        System.out.println(q.isIsomorphicV2("p", "t"));
        System.out.println(q.isIsomorphicV2("p\"", "tn"));
        System.out.println("V3:");
        System.out.println(q.isIsomorphicV3("egg", "add"));

        System.out.println(q.isIsomorphicV3("foo", "bar"));

        System.out.println(q.isIsomorphicV3("paper", "title"));
        System.out.println(q.isIsomorphicV3("p", "t"));
        System.out.println(q.isIsomorphicV3("p\"", "tn"));

        System.out.println("Indexes of chars: ");

        var test = "Hello";
        System.out.println(q.indexesOfCharacter(test, test.charAt(2), 3));
    }
}
