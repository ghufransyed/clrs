/**
 * Created by ghufran on 5/19/16.
 */
public class Inversions {

    public static int sort(int[] ary,
                             int p,
                             int r){
        
        int count = 0;

        //int q = (p + r)/2;
        int q = (int) Math.ceil((p + r)/2.0);

        if ((q - p) > 1){
            count += Inversions.sort(ary, p, q - 1);
        }
        if ((r - q + 1) > 1){
            count += Inversions.sort(ary, q, r);
        }
        count += Inversions.merge(ary, p, q, r);

        return count;
    }

    public static int merge(int[] ary,
                              int p,
                              int q,
                              int r){

        int count = 0;
        
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
            if (rh >= n2){
                ary[p + k] = left[lh];
                lh++;
            }
            else if (lh >= n1){
                ary[p + k] = right[rh];
                rh++;
            }
            else if (left[lh] <= right[rh]) {
                ary[p + k] = left[lh];
                lh++;
            }
            else if (left[lh] > right[rh]) { //has to be 'else', otherwise, can consume from left and right in one iteration
                // leading to array index out of bounds error when k continues but elements of left and right exhausted
                ary[p + k] = right[rh];
                count += (n1 - lh); // adding a single element from the right subarray means there 
                                    // are as many inversions present from left to right as there are remaining
                                    // elements in left subarray
                rh++;
            }
        }

        return count;
    }

}


/*

int a = 1;
int b = 2;
b = a; // b now contains 1
b = b + 2; b now contains 3
a // a is still 1



 */