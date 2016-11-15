import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
        Student seniorStudent = new Student(902);
        Student juniorStudent = new Student(903);
        Student[] studentArr = {seniorStudent, juniorStudent};

        System.out.println(buildMap(studentArr));
        String[] words = {"Hi", "my name is"};
        String[] more = {" Fuad"};
        System.out.println(merge(words, more));

        String name = "ffff";
        System.out.println("Question 1.1 Test Cases:");
        System.out.println(uniqueChars("abcd"));
        System.out.println(uniqueChars("aaaa"));
        System.out.println(uniqueChars(null));
        System.out.println(uniqueChars("aaabbb"));

        System.out.println("Question 1.2 Test Cases:");
        System.out.println(reverse("Fuad"));

        System.out.println("Question 1.3 Test Cases:");
        System.out.println(isPermuation("Fuadd", "daduF"));

        System.out.println("Quesiton 1.4 Test Cases:");
        char[] charArrays = new char[]{'F', ' ', 'u', ' ', 'a', ' ', 'd', ' ', ' ', ' ', ' ', ' ', ' '};
        System.out.println(replaceSpace(charArrays, 7));

        System.out.println("Question 1.5 Test Cases:");
        System.out.println(stringCompression("aaaaaabbbbbbbccccccc"));
        System.out.println(stringCompression("abcd"));

        System.out.println("Question 1.6 Test Cases:");
        int[][] myArr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int nVal = 4;
        System.out.println(Arrays.deepToString(rotate90(myArr, nVal)));

        System.out.println("Question 1.6 Test Cases:");
        int[][] zeroArr = new int[][]{
                {1, 0, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 0, 16},
        };
        System.out.println(Arrays.deepToString(matrixZero(zeroArr)));
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
//                System.out.println(myHashmapStr1.get((int) str1.charAt(i)));
                if(!myHashmapStr1.containsKey((int) str1.charAt(i))) {
                    myHashmapStr1.put((int) str1.charAt(i), 0);
//                    System.out.println(myHashmapStr1.get((int) str1.charAt(i)));
                }
                if(!myHashmapStr2.containsKey((int) str2.charAt(i))) {
                    myHashmapStr2.put((int) str2.charAt(i), 0);
                }
//                System.out.println("Current Key: " + (int) str1.charAt(i));
//                System.out.println("Current Value: " + myHashmapStr1.get((int) str1.charAt(i)));
                myHashmapStr1.put((int) str1.charAt(i), myHashmapStr1.get((int) str1.charAt(i)) + 1);
                myHashmapStr2.put((int) str2.charAt(i), myHashmapStr2.get((int) str2.charAt(i)) + 1);
            }
            return myHashmapStr1.equals(myHashmapStr2);
        }
    }

    /* Interview Question 1.4: Write a method to replace all spaces in a string with '%20'. You may
       assume that the string has sufficient space at the end of the string to hold the additional
       characters, and that you are given the "true" length of the string. (Note: if implementing
       in Java, please use a character array so that you can perform this operation in place.)

       1) Questions
       will the input be a character array? Do you want me to return the char[] or a string?
       does the character array also have those extra spaces? Index out of bounds?
       What about if the given string is only spaces?
       */
    //TODO: Finish this problem
    private static String replaceSpace(char[] charStr, int length) {
        int spaceCount = 0, newLength, i;
        for (i = 0; i < length; i++) {
            if (charStr[i] == ' ') {
                spaceCount++;
            }
        }
        newLength = length + spaceCount*2;
        charStr[newLength - 1] = '\0';
        for (i = length - 1; i >= 0; i--) {
            if (charStr[i] == ' ') {
                charStr[newLength - 1] = '0';
                charStr[newLength - 2] = '2';
                charStr[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                charStr[newLength - 1] = charStr[i];
                newLength = newLength - 1;
            }
        }
        return new String(charStr);
    }

    /* Interview Question 1.5: Implement a method to perform basic string compression using
    the counts of repeated characters. For example, the string aabcccccaaa would become
    a2b1c5a3. If the "compressed" string would not become smaller than the orignal string,
    your method should return the original string.

    1) Questions:
    case sensitive? what to do with null inputs? In-place?

    ALWAYS USE STRINGBUFFER because when concatenating strings the cost of iteration increases,
    while that working with buffer it doesn't
     */

    private static String stringCompression(String str) {
        int originalSize = str.length();
        StringBuffer myBuffer = new StringBuffer();
        if (str == null) {
            return "Input is null";
        }
        char currentChar = str.charAt(0);
        myBuffer.append(currentChar);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char iterationChar = str.charAt(i);
            if (currentChar == iterationChar) {
                count++;
            } else {
                myBuffer.append(count);
                currentChar = str.charAt(i);
                myBuffer.append(currentChar);
                count = 1;
            }
        }
        myBuffer.append(count);
        if (myBuffer.length() < str.length()) {
            return myBuffer.toString();
        } else {
            return str;
        }
    }

    /* Interview Question 1.6: Given an image represented by an NxN matrix, where each pixel
    in the image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this
    in place?

    1)Questions:
    What input am I given? I'll assume it is a 2D array, with ints as its 4byte color value
     */

    private static int[][] rotate90(int[][] img, int n) {
        for (int layer = 0; layer < (n/2); layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                //save the top value
                int top = img[first][i];

                //put left value on top
                img[first][i] = img[last - offset][first];

                //put bottom on left
                img[last - offset][first] = img[last][last - offset];

                //put right on bottom
                img[last][last - offset] = img[i][last];

                //put top on right
                img[i][last] = top;
            }
        }
        return img;
    }

    /* Interview Question 1.7: Write an algorithm such that if an element in an MxN matrix
    is 0, its entire row and column are set to 0

    1)Questions
    in place?
     */

    private static int[][] matrixZero(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}
