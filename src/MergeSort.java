/**
 * Created by ghufran on 5/19/16.
 */
public class MergeSort {
    
    
    public static int[] sort(int[] ary,
                             int p,
                             int r){
        
        //int q = (p + r)/2;
        int q = (int) Math.ceil((p + r)/2.0);
        
        if ((q - p) > 1){
            MergeSort.sort(ary, p, q - 1);
        }
        if ((r - q + 1) > 1){
            MergeSort.sort(ary, q, r);
        }
        MergeSort.merge(ary, p, q, r);
        
        return ary;
    }
    
    public static int[] merge(int[] ary,
                              int p,
                              int q,
                              int r){
        
        int n1 = q - p;
        int n2 = r - q + 1;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int lh = 0; // pointer to head of left
        int rh = 0; // pointer to head of right
        
        // fill left and right subarrays
        
        for (int i = 0 ; i < n1 ; i++){
            left[i] = ary[p + i];
        }
        for (int j = 0 ; j < n2 ; j++){
            right[j] = ary[q + j];
        }
        
        // loop to merge subarrays (copying into ary)
        
        for (int k = 0 ; k < (n1 + n2) ; k++ ) {
            if ((rh >= n2) || left[lh] < right[rh]) {
                ary[p + k] = left[lh];
                lh++;
            }
            else if ((lh >= n1) || left[lh] >= right[rh]) { //has to be 'else', otherwise, can consume from left and right in one iteration
                                                            // leading to array index out of bounds error when k continues but elements of left and right exhausted
                ary[p + k] = right[rh];
                rh++;
            }
        }
        
        return ary;
    }
        
}
