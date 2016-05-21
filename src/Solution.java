/**
 * Created by ghufran on 5/21/16.
 */
public class Solution {
    public static int maxProfit(int[] prices) {
        
        // input array must have at least 2 elements
        if (prices.length == 0 || prices.length == 1) { return 0; }
        
        // if expected profit is negative, then we have the option to NOT buy
        // therefore, thisSum should be initialized to zero, as this is the 'profit' 
        // that a trade must exceed
        
        int thisSum = prices[1] - prices[0];
        int thisSumStart = 0;
        int thisSumEnd = 1;
        int maxSum = thisSum;
        int maxSumStart = thisSumStart;
        int maxSumEnd = thisSumEnd;
        
        int delta;
        
        
        for (int i = 2 ; i < prices.length ; i++){
            
            delta = prices [i] - prices[i - 1];
            
            if ((thisSum + delta) >= delta){
                thisSum += delta;
                thisSumEnd++;
            }
            else{
                thisSum = delta;
                thisSumStart = i - 1;
                thisSumEnd = i;
            }
            
            if (thisSum >= maxSum){
                maxSum = thisSum;
                maxSumStart = thisSumStart;
                maxSumEnd = thisSumEnd;
            }
            
        }
        //System.out.println("Sequence Start:" + maxSumStart);
        //System.out.println("Sequence End:" + maxSumEnd);
        
        return maxSum; 
    }
}
