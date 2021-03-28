package codewar;

import java.util.HashSet;
import java.util.Set;

public class PangramChecker {
    public boolean check(String sentence){
        Set<Character> abc = new HashSet<>();
        char[] str = sentence.toLowerCase().toCharArray();
        for (char c : str){
            if (Character.isAlphabetic(c) && !abc.contains(c)){
                abc.add(c);
            }
        }
        if (abc.size() == 26)
            return true;
        return false;
    }

    public static void main(String[] args) {
        PangramChecker checker = new PangramChecker();
        System.out.println(checker.check("The quick brown fo jumps over the lazy dog"));
    }
}
