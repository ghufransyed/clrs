import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        int[] test1 = new int[] { 5, 4, 3, 2, 1};
        
        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(InsertionSort.sort(
                test1)));
    }
}



