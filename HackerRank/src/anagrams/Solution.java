package anagrams;

import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {

        if (a.length() != b.length()) {
            return false;
        }

        a = a.toLowerCase();
        b = b.toLowerCase();
        
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();

        java.util.Arrays.sort(aArray);
        java.util.Arrays.sort(bArray);

        for (int i = 0; i < aArray.length; i++) {

            if (aArray[i] != bArray[i]) {
                return false;
            }
        }

        return true;
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
