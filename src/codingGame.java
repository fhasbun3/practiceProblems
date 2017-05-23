/**
 * Created by Fuad Hasbun on 2/26/2017.
 */
public class codingGame {
    public static void main(String[] args) {
        System.out.println(formatNum(1100));
        System.out.println(countVal("aaabb"));
    }

    private static String countVal(String str) {
        int count = 0;
        char cur;
        StringBuilder myStr = new StringBuilder(str);
        StringBuilder myAns = new StringBuilder();
        while (myStr.length() != 0) {
            count = 0;
            cur = myStr.charAt(0);
            for (int i = 0; i < myStr.length(); i++) {
                System.out.println(myStr.charAt(i));
                if (cur == myStr.charAt(i)) {
                    count++;
                    myStr.deleteCharAt(i);
                    System.out.println(myStr); 
                }
            }
            myAns.append(count);
            myAns.append(cur);
        }
        return myAns.toString();
    }

    public static String formatNum(int num) {
        String myNum = Integer.toString(num);
        int count = 0;
        String formattedNum = "";
        String ans = "";
        for (int i = myNum.length() - 1; i >= 0; i--){
            if (count%3 == 0) {
                formattedNum = formattedNum + "," + myNum.charAt(i);
                count++;
            } else {
                formattedNum = formattedNum + myNum.charAt(i);
                count++;
            }
        }
        for (int i = formattedNum.length() - 1; i > 0; i--) {
            ans = ans + formattedNum.charAt(i);
        }
        return  ans;
    }
}
