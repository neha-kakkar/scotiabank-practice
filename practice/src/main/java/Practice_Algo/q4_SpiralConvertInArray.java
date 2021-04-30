package Practice_Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class q4_SpiralConvertInArray {

    public static int[] generageteMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int layer = 0; layer < (n + 1) / 2; layer++) {
            // direction 1 - traverse from left to right
            for (int ptr = layer; ptr < n - layer; ptr++) {
                result[layer][ptr] = cnt++;
            }
            // direction 2 - traverse from top to bottom
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[ptr][n - layer - 1] = cnt++;
            }
            // direction 3 - traverse from right to left
            for (int ptr = layer + 1; ptr < n - layer; ptr++) {
                result[n - layer - 1][n - ptr - 1] = cnt++;
            }
            // direction 4 - traverse from bottom to top
            for (int ptr = layer + 1; ptr < n - layer - 1; ptr++) {
                result[n - ptr - 1][layer] = cnt++;
            }
        }


        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                list.add(result[i][j]);
            }
        }

        // now you need to find a mode in the list.

        // tiny change 3, if you definitely need an array
        int[] vector = new int[list.size()];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = list.get(i);
        }


        return vector;

    }

    public static void main(String[] args) {
        int n=3;
        System.out.println("Spiral Convert In Array : " + Arrays.toString(generageteMatrix(n)));
    }

}
