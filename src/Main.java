import java.util.Scanner;

public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        char[] i = s.toCharArray();
        int indents = 0;
        if (i[0] == ')') {return false;}
        for (char c : i) {
            if (c == '(') {
                indents++;
            }
            if (c == ')') {
                indents--;
            }
            if (indents < 0) {
                return false;
            }
        }
        return indents==0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        StringBuilder x = new StringBuilder();
        while (n !=0) {
            x.append((n % 10));
            n = n/10;
        }
        return x.toString();
    }


    // 3. encryptThis
    public static String encryptThis(String input) {
        String[] inputs = input.split(" ");
        int i;
        StringBuilder g = new StringBuilder();
        for (i=0; i<inputs.length; i++) {
            g.append(encryptWord(inputs[i]));
            if (i!=inputs.length-1) {g.append(" ");}
        }
        return g.toString();
    }

    public static String encryptWord(String input) {
        StringBuilder x = new StringBuilder();
        int i;
        for (i=0; i<input.length(); i++) {
            if (i==0){x.append((int)input.charAt(i));}
            else if (i==1){x.append(input.charAt(input.length()-1));}
            else if (i==input.length()-1) {x.append(input.charAt(1));}
            else {x.append(input.charAt(i));}
        }
        return x.toString();
    }


    // 4. decipherThis
    public static String decipherThis(String input) {
        String[] words = input.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            StringBuilder number = new StringBuilder();
            StringBuilder letter = new StringBuilder();
            char[] charArray = word.toCharArray();

            for (char c: charArray) {
                if (Character.isDigit(c)) {
                    number.append(c);
                } else if (Character.isAlphabetic(c)) {
                    letter.append(c);
                } else {
                    break;
                }
            }

            int num = Integer.parseInt(number.toString());
            StringBuilder x = new StringBuilder();
            x.append((char)num);
            x.append(letter);
            int i;
            for (i=0; i<x.length(); i++) {
                if (i==1){result.append(x.charAt(x.length()-1));}
                else if (i==x.length()-1) {result.append(x.charAt(1));}
                else {result.append(x.charAt(i));}
            }
            result.append(" ");
        }
        String z = result.toString();
        return z.substring(0, z.length()-1);
    }

}
