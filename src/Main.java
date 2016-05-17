import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        
        int[] test1 = new int[] { 5, 4, 3, 2, 1};
        int[] test2 = new int[] { 1, 1, 1, 1, 1};
        int[] test3 = new int[] { 1, 1, 1, 1, 1};
        
        
        //System.out.println(Arrays.toString(test1));
        /*System.out.println(Arrays.toString(InsertionSort.sort(
                test1)));
                */
       
        System.out.println(Arrays.toString(test1));
        System.out.println(linearSearch(test1,4));
        System.out.println(linearSearch(test1,6));
        
        System.out.println(Arrays.toString(test2));
        System.out.println(Arrays.toString(test3));
        System.out.println(Arrays.toString(addBinary(test2,test3)));
        
    }
    
    
    
    public static int linearSearch(int[] ary,
                                   int target){
        for (int i = 0 ; i < ary.length ; i++){
            if (ary[i] == target){
                return i;
            }
        }
        return -1;
    }
    
    
    public static int[] addBinary(int[] a,
                                  int[] b) throws java.lang.IllegalArgumentException {


        if (a.length != b.length) {
            throw (new IllegalArgumentException("The two arrays must be the same length"));
        }
        int lenIn = a.length;
        int lenOut = a.length + 1;
        int[] c = new int[lenOut];

        for (int i = lenIn - 1; i >= 0; i--) {
            c[i+1] = a[i] + b[i] + c[i+1];

            switch (c[i+1]) {
                case 0:
                    break;

                case 1:
                    break;

                case 2:
                    c[i] = 1;
                    c[i+1] = 0;
                    break;

                case 3:
                    c[i] = 1;
                    c[i+1] = 1;
                    break;
            }

        }
        return c;
        
    }
}



