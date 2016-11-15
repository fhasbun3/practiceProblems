import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BooleanSupplier;

public class Main {

    public static void main(String[] args) {
        Student seniorStudent = new Student(902);
        Student juniorStudent = new Student(903);
        Student[] studentArr = {seniorStudent, juniorStudent};

        System.out.println(buildMap(studentArr));
        String[] words = {"Hi", "my name is"};
        String [] more = {" Fuad"};
        System.out.println(merge(words, more));

        String name = "ffff";
        System.out.println(uniqueChars("abcd"));
        System.out.println(uniqueChars("aaaa"));
        System.out.println(uniqueChars(null));
        System.out.println(uniqueChars("aaabbb"));

        System.out.println(reverse("Fuad"));

        System.out.println(isPermuation("Fuadd", "daduF"));

    }

    private static HashMap<Integer, Student> buildMap(Student[] students) {
        HashMap<Integer, Student> map = new HashMap<>();
        for (Student s: students) map.put(s.getId(), s);
        return map;
    }

    private static ArrayList<String> merge (String[] words, String[] more) {
        ArrayList<String> sentence = new ArrayList<String>();
        for (String w:words) sentence.add(w);
        for (String w:more) sentence.add(w);
        return sentence;
    }

    /*Inerview Steps:
    1) Ask your interviewer questions to resolve ambiguity
    2) Design an Algorithm
    3) Write pseudcode first
    4) write code
    5) test your code (test for 0, null, maxs, mins)

    Interview Question 1.1: Implement an algorithm to determine if a string has
    all unique characters. What if you cannot use additional data structures
    1) Size of string? What about empty strings? Does case matter?
    */

    /**
     * Method that checks if characters in a string are unique
     * @param str the given string
     * @return true if its unique, false otherwise
     */
    private static boolean uniqueChars(String str) {
        boolean isUnique = true;
        if (str == null) {
            return isUnique = false;
        } else if (str.isEmpty()) {
            isUnique = false;
        } else {
            ArrayList<Character> myArrayList = new ArrayList<Character>();
            for (int i = 0; i < str.length(); i++) {
                if (myArrayList.contains(str.charAt(i))) {
                     isUnique = false;
                }
                myArrayList.add(str.charAt(i));
            }
        }
        return isUnique;
    }

    /*Interview Question 1.2: Implement a function void reverse(Str str) that
    reverses a string

    1) Questions:
    size? can we use data structures?
    */

    public static StringBuffer reverse(String str) {
        StringBuffer strToReturn = new StringBuffer();
        if (str == null) {
            return strToReturn;
        } else if (str.length() < 2) {
            return strToReturn.append(str);
        } else {
            for (int i = str.length() - 1; i >= 0; i--) {
                strToReturn.append(str.charAt(i));
            }
        }
        return strToReturn;
    }

    /* Interview Question 1.3: Given two strings write a method to decide if one is
    a permutation of the other

    1) Questions:
    size? what to do when its null? can we use data structures or do you want it in place?
     */

    public static boolean isPermuation(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        } else if (str1.length() != str2.length()) {
            return false;
        } else {
            HashMap<Integer, Integer> myHashmapStr1 = new HashMap<>();
            HashMap<Integer, Integer> myHashmapStr2 = new HashMap<>();
            for (int i = 0; i < str1.length(); i++) {
                System.out.println(myHashmapStr1.get((int) str1.charAt(i)));
                if(!myHashmapStr1.containsKey((int) str1.charAt(i))) {
                    myHashmapStr1.put((int) str1.charAt(i), 0);
                    System.out.println(myHashmapStr1.get((int) str1.charAt(i)));
                }
                if(!myHashmapStr2.containsKey((int) str2.charAt(i))) {
                    myHashmapStr2.put((int) str2.charAt(i), 0);
                }
                System.out.println("Current Key: " + (int) str1.charAt(i));
                System.out.println("Current Value: " + myHashmapStr1.get((int) str1.charAt(i)));
                myHashmapStr1.put((int) str1.charAt(i), myHashmapStr1.get((int) str1.charAt(i)) + 1);
                myHashmapStr2.put((int) str2.charAt(i), myHashmapStr2.get((int) str2.charAt(i)) + 1);
            }
            return myHashmapStr1.equals(myHashmapStr2);
        }
    }

    /* Interview Question 1.4 Write a method to replace all spaces in a string with '%20'. You may
       assume that the string has sufficient space at the end of the string to hold the additional
       characters, and that you are given the "true" length of the string. (Note: if implementing
       in Java, please use a character array so that you can perform this operation in place.)

       1) Questions
       will the input be a character array? Do you want me to return the char[] or a string?
       does the character array also have those extra spaces? Index out of bounds?
       */
    //TODO: Finish this problem
    public static String replaceSpace(char[] charStr) {
        if (charStr == null) {
            return "Your String is null";
        } else {
            for (int i = 0; i < charStr.length; i++) {
                if (charStr[i] == ' ') {

                }
            }
        }


    }
}
