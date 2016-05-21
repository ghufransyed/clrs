/**
 * Created by ghufran on 5/21/16.
 */
public class MaxSubArrayR {
    
    public static MaxArrayResult maxSubArray(int[] ary,
                                    int p,
                                    int r){
        
        
        if (p == r) { return new MaxArrayResult(p,r,ary[p]) ; } 
        
        else {
            int q = (int) Math.ceil((p + r)/2.0);
            
            MaxArrayResult leftResult = maxSubArray(ary, p, q -1);
            MaxArrayResult rightResult = maxSubArray(ary, q, r);
            MaxArrayResult crossResult = crossingMaxSubArray(ary, p, q, r);
            
            if ((leftResult.sum >= rightResult.sum) &&
                    (leftResult.sum >= crossResult.sum)){
                return leftResult;
            }
            else if ((rightResult.sum >= leftResult.sum) &&
                    (rightResult.sum >= crossResult.sum)){
                return rightResult;
            }
            else {
                return crossResult;
            }
        }
    }
    
    
    public static MaxArrayResult crossingMaxSubArray(int[] ary,
                                            int p,
                                            int q,
                                            int r){
        
        int thisSumL = 0; 
        int thisSumR = 0; 
        
        int leftMaxSum = - Integer.MAX_VALUE;
        int rightMaxSum = - Integer.MAX_VALUE;
        int mostLeft = q - 1;
        int mostRight = q;
        
        for (int i = q - 1 ; i >= 0 ; i--){
            thisSumL += ary[i];
            if (thisSumL > leftMaxSum){
                leftMaxSum = thisSumL;
                mostLeft = i;
            }
        }
        
        for (int j = q ; j <= ary.length - 1 ; j++){
            thisSumR += ary[j];
            if (thisSumR > rightMaxSum){
                rightMaxSum = thisSumR;
                mostRight = j;
            }
        }
        
        MaxArrayResult result = new MaxArrayResult(mostLeft, mostRight, (leftMaxSum + rightMaxSum));
        
        return result;
        
        
    }
    
}

class MaxArrayResult{
    public int mostLeft;
    public int mostRight;
    public int sum;
    
    public MaxArrayResult(int mostLeft,
                          int mostRight,
                          int sum){
        this.mostLeft = mostLeft;
        this.mostRight = mostRight;
        this.sum = sum;
    }
    
    public String toString(){
        return "mostLeft: " + mostLeft + "\n" +
                "mostRight: " + mostRight + "\n" +
                "sum: " + sum;
    }
}
