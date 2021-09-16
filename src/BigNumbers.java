import java.util.Arrays;

public class BigNumbers {

    public static int[] reverse(int[] op) {
        for (int i = 0; i < op.length / 2; i++) {
            int aux = op[i];
            op[i] = op[op.length - 1 - i];
            op[op.length - 1 - i] = aux;
        }
        return op;
    }

    public static int[] sum(int[] op1, int[] op2) {
        int[] array1 = reverse(op1);
        int[] array2 = reverse(op2);

        int[] result = new int[Math.max(array1.length, array2.length)];
        int min = Math.min(array1.length, array2.length);
        int t = 0;


        for (int i = 0; i < min; i++) {
            result[i] = (array1[i] + array2[i] + t) % 10;
            t = (array1[i] + array2[i] + t) / 10;
        }

        if (array1.length > array2.length) {
            for (int i = min; i < array1.length; i++) {
                result[i] = (array1[i] + t) % 10;
                t = (array1[i] + t) / 10;
            }
        } else {
            for (int i = min; i < array2.length; i++) {
                result[i] = (array2[i] + t) % 10;
                t = (array2[i] + t) / 10;
            }
        }

        if (t != 0) {
            result = Arrays.copyOf(result, result.length + 1);
            result[result.length - 1] = t;
        }

        return reverse(result);
    }

    public static void main(String[] args) {
        int noTests = 6;

        int[][] op1 = {{0}, {9, 9}, {9}, {2, 1, 7, 8},
                {5, 0, 5, 0, 5}, {1, 0, 8, 6, 7, 8, 9, 4, 2, 3, 4}};
        int[][] op2 = {{1, 0, 1}, {1}, {9, 9, 9, 9}, {5, 9, 6},
                {5, 5, 0, 5, 0}, {3, 4, 2, 8, 9, 7, 9, 2, 3, 4, 9}};
        int[][] correct = {{1, 0, 1}, {1, 0, 0}, {1, 0, 0, 0, 8}, {2, 7, 7, 4},
                {1, 0, 5, 5, 5, 5}, {4, 5, 1, 5, 7, 6, 8, 6, 5, 8, 3}};

        int total = 0;
        for (int i = 0; i < noTests; i++) {
            System.out.println("Test " + (i + 1) + ":");
            String op1S = noToString(op1[i]);
            String op2S = noToString(op2[i]);

            BigNumbers bn = new BigNumbers();
            int[] rez = bn.sum(op1[i], op2[i]);

            String rezS = noToString(rez);
            String correctS = noToString(correct[i]);
            System.out.println(op1S + " + " + op2S + " = " + rezS + " C: " + correctS +
                    "......" + (rezS.equals(correctS) ? "OK" : "WRONG"));
            System.out.println();

            total += rezS.equals(correctS) ? 1 : 0;
        }

        System.out.println("Your total score is: " + total + " / " + noTests);
        System.out.println(total > 3 ? "You passed! Hurray! :)" : "Sorry.. :(");
    }

    private static String noToString(int[] no) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < no.length; i++) {
            sb.append(no[i]);
        }
        return sb.toString();
    }
}