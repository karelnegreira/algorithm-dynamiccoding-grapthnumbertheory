package dynamics;

import java.util.HashSet;
import java.util.Set;

/*
* Given a set of words in a dictionary,
* find in a given input String a space-separate
* words matching those in the dictionary.
* */
public class WordBreakProblem {

    private static Set<String> dictionary = new HashSet<>();

    public static void main(String[] args) {
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        for (String temp: temp_dictionary) {
            dictionary.add(temp);
        }

        System.out.println(wordBreak("ilikesamsung"));
        System.out.println(wordBreak("iiiiiiii"));
        System.out.println(wordBreak(""));
        System.out.println(wordBreak("ilikelikeimangoiii"));
        System.out.println(wordBreak("samsungandmango"));
        System.out.println(wordBreak("samsungandmango"));
    }

    static boolean dicionaryContains(String word) {
        String dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};
        int size = dictionary.length;
        for (int i = 0; i < size; i++) {
            if (dictionary[i].compareTo(word) == 0) {
                return true;
            }
        }
        return false;
    }

    static boolean dynamicWordBreak(String word) {
        int size = word.length();
        //base case, when is empty
        if (size == 0) {
            return true;
        }
        boolean wb[] = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            if (wb[i] == false && dicionaryContains(word.substring(0, i))) {
                wb[i] = true;
            }

            if (wb[i] == true) {
                //if we reach the last prefix
                if (i == size) {
                    return true;
                }
                for (int j = i + 1; j <= size; j++) {
                    if (wb[j] == false && dicionaryContains(word.substring(i, j - i))) {
                        wb[i] = true;
                    }
                    if (j == size && wb[j] == true) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean wordBreak(String word) {
        int size = word.length();

        if (size == 0) {
            return true;
        }

        for (int i = 1; i <= size; i++) {
            if (dictionary.contains(word.substring(0, i)) && wordBreak(word.substring(i, size))) {
                return true;
            }
        }
        return false;
    }
}
