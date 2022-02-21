
import java.util.Scanner;
import java.util.Stack;

public class Oefening2 {

    public static void main(String[] args) {

        Stack<String> q = new Stack<>();

        String input = "(1 + ((2 + 3) * (4 * 5)))";
        //String input = "(2 + 2)";
        //String input = "(2 + (1 + 1))";
        //String input = "((8 / 4) + (1 + 1))";
        int openBrackets = input.length() - input.replaceAll("\\(", "").length();
        String cleanInput = input.replaceAll("\\s+", "");
        System.out.println(cleanInput);

        for (int i = 0; i < cleanInput.length(); i++) {
            String character = Character.toString(cleanInput.charAt(i));
            q.push(character);
        }


        for (int i = 0; i< openBrackets; i++) {
            for (int j = 1; j < q.size() - 1; j++) {
                if (q.elementAt(j).equals("+") || q.elementAt(j).equals("-") ||
                        q.elementAt(j).equals("*") || q.elementAt(j).equals("/")) {
                    String[] inputStr = new String[]{q.elementAt(j - 1), q.elementAt(j), q.elementAt(j + 1)};
                    String newInt = trySolveSubExpression(inputStr);
                    if (!newInt.equals("Error")) {
                        int k =0;
                        while (k < 5) {
                            q.remove(j - 2);
                            k++;
                        }
                        q.add(j -2, newInt);
                    }
                }
            }
            System.out.println("Elements of queue " + q);
        }
    }


    public static String trySolveSubExpression(String[] input){
        try{
        int left = Integer.parseInt(input[0]);
        int right =Integer.parseInt(input[2]);
            if (input[1].equals("+")) { return Integer.toString(left + right);}
            if (input[1].equals("-")) { return Integer.toString(left - right);}
            if (input[1].equals("*")) { return Integer.toString(left * right);}
            if (input[1].equals("/")) { return Integer.toString(left / right);}
            return "Error";
        }
        catch(Exception e){
            return "Error";
        }
    }
}
