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
       
        //System.out.println(Arrays.toString(test1));
        //System.out.println(linearSearch(test1,4));
        //System.out.println(linearSearch(test1,6));
        
        //System.out.println(Arrays.toString(test2));
        //System.out.println(Arrays.toString(test3));
        //System.out.println(Arrays.toString(addBinary(test2,test3)));
        
        //System.out.println(Arrays.toString(test1));
        //System.out.println(Arrays.toString(insertionSort(test1)));

        System.out.println(Arrays.toString(test1));
        System.out.println(Arrays.toString(mergeSort(test1, 0, test1.length - 1)));

    }
   
    // start = index of first element, end = index of last element
    public static int[] mergeSort(int[] ary,
                                       int p,
                                  int r){
        
        
        int q = (int)(Math.ceil((p + r) /(double) 2)); // stack overflow, need to fix recursion calls / checks for base case
        
        if ((r - q + 1) > 1) {
            mergeSort(ary, q, r);
        }
        if (q - p > 1){
            mergeSort(ary,p ,q - 1);
        }
        
        merge(ary, p,q,r);
           
       
        return ary;
    }
    
    private static int[] merge(int[] ary,
                               int p, // first element  of left subarray
                               int q, // first element of right subarray
                               int r){
        
        int n1 = q - p;
        int n2 = r - q + 1;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int lh = 0; // pointer to head of left subarray
        int rh = 0; // pointer to head of right subarray
        
        for (int i = 0 ; i < n1 ; i++){
            left[i] = ary[p + i];
        }
        for (int j = 0 ; j < n2 ; j++){
            right[j] = ary[q + j];
        }
        
        for (int k = p ; k <= r ; k++){
            if ((rh >= n2) || (left[lh] < right[rh])){
                ary[k] = left[lh];
                lh++;
            }
            else if((lh >= n1) || (right[rh] < left[lh])){
                ary[k] = right[rh];
                rh++;
            }
        }
        return ary;
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
    
    public static int[] insertionSort(int[] ary){
        int smallest; 
        int tmp;
        
        for (int i = 0 ; i <  ary.length - 1 ; i++){
            for (int j = i + 1 ; j < ary.length ; j++){
                
                if (ary[j] < ary[i]){
                    tmp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = tmp;
                }
                System.out.println("inner loop");
                System.out.println(Arrays.toString(ary));
            }

            System.out.println("outer loop");
            System.out.println(Arrays.toString(ary));
        }
        return ary;
    }
}



