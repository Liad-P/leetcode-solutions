import java.util.HashSet;
import java.util.Set;

public class Question290WordPattern {
    public boolean wordPattern(String pattern, String s) {

        String[] splitString = s.split(" ");
        if (pattern.length() != splitString.length) {
            return false;
        }
        String[] stringArrays = new String[Character.MAX_VALUE];
        Set<String> stringsFromSSet = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            var currentCharacterFromPattern = pattern.charAt(i);
            var correspondingString = splitString[i];
            var correspondingStringInArray = stringArrays[currentCharacterFromPattern];
            if (correspondingStringInArray == null) {
                if (stringsFromSSet.contains(correspondingString)) {
                    return false;
                }
                else {
                    stringArrays[currentCharacterFromPattern] = correspondingString;
                    stringsFromSSet.add(correspondingString);
                }
            } else if (correspondingStringInArray.equals(correspondingString)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        var q = new Question290WordPattern();
        System.out.println(q.wordPattern("abba", "dog cat cat dog"));
        System.out.println(q.wordPattern("abba", "dog cat cat dog cat"));
        System.out.println(q.wordPattern("abba", "dog cat cat fish"));
        System.out.println(q.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(q.wordPattern("aaaaa", "dog cat cat dog"));
        System.out.println(q.wordPattern("abba", "dog dog dog dog"));
    }
}
