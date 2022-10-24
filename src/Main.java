import java.util.*;

public class Main {
    public static String calc(String input) throws Exception {
        ArrayList<String> roman = new ArrayList<>(List.of("O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"));
        String[] arr = input.split(" ");
        if (arr.length != 3) {
            throw new Exception();
        }
        int a;
        int b;
        boolean aIsInt;
        boolean bIsInt;
        String result;
        try {
            a = Integer.parseInt(arr[0]);
            aIsInt = true;
        }
        catch (NumberFormatException nfe) {
            a = roman.indexOf(arr[0]);
            aIsInt = false;
        }
        try {
            b = Integer.parseInt(arr[2]);
            bIsInt = true;
        }
        catch (NumberFormatException nfe) {
            b = roman.indexOf(arr[2]);
            bIsInt = false;
        }
        if (aIsInt != bIsInt) {
            throw new Exception();
        }
        if ((a < 1) || (a > 10) || (b < 1) || (b > 10)){
            throw new Exception();
        }
        result = switch (arr[1]) {
            case ("+") -> String.valueOf(a + b);
            case ("-") -> String.valueOf(a - b);
            case ("*") -> String.valueOf(a * b);
            case ("/") -> String.valueOf(a / b);
            default -> throw new Exception();
        };
        if (!aIsInt && !bIsInt){
            if (Integer.parseInt(result) < 1) {
                throw new Exception();
            }
            result = roman.get(Integer.parseInt(result));
        }
        return result;
    }
    public static void main (String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(calc(input));
    }
}

