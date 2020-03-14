import java.util.Scanner;

public class Programi2 {
    public static void main(String[] args) {

        switch (args[0]) {
            case "lowercase":
                lowercase(args[1]);
                break;
            case "uppercase":
                uppercase(args[1]);
                break;
            case "capitalize":
                capitalize(args[1]);
                break;
            case "inverse":
                inverse(args[1]);
                break;
            case "alternating":
                alternating(args[1]);
                break;
        }
    }
    public static void lowercase(String sL) {
        String sLL = sL.toLowerCase();
        System.out.println(sLL);
    }
    public static void uppercase(String sU) {
        String sUU = sU.toUpperCase();
        System.out.println(sUU);
    }
    public static void capitalize(String sC) {
        String upper_case_line = "";
        Scanner lineScan = new Scanner(sC);
        while(lineScan.hasNext()) {
            String word = lineScan.next();
            upper_case_line += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }
        System.out.println(upper_case_line.trim());
    }
    public static void inverse(String sI) {
        String sU = sI.toUpperCase();
        String sII = Character.toLowerCase(sU.charAt(0))
                + (sU.length() > 1 ? sU.substring(1) : "");
        System.out.println(sII);
    }
    public static void alternating(String sA) {
        String sL = sA.toLowerCase();
        String sU = sA.toUpperCase();
        for(int i = 0 ; i < sA.length() ; i++){
            if(i % 2 == 0)
            System.out.print(sL.charAt(i));
        else
        System.out.print(sU.charAt(i));
    }
}}
