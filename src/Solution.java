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
        
        int thisSum = 0;
        int thisSumStart = -1;
        int thisSumEnd = -1;
        int maxSum = thisSum;
        int maxSumStart = thisSumStart;
        int maxSumEnd = thisSumEnd;
        
        int delta;
        
        
        for (int i = 1 ; i < prices.length ; i++){
            
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
    public static int[] maxSubArray(int[] nums) {
        
        if (nums.length == 0 || nums.length == 1) {return nums;}
        
        int thisSum = nums[0];
        int thisSumStart = 0;
        int thisSumEnd = 0;
        int maxSum = thisSum;
        int maxSumStart = thisSumStart;
        int maxSumEnd = thisSumEnd;
        
        for (int i = 1 ; i < nums.length ; i++){
            if ((thisSum + nums[i] >= nums[i])){
                thisSum += nums[i];
                thisSumEnd++;
            }
            else{
                thisSum = nums[i];
                thisSumStart = i;
                thisSumEnd = i;
            }
            
            if (thisSum >= maxSum){
                maxSum = thisSum;
                maxSumStart = thisSumStart;
                maxSumEnd = thisSumEnd;
            }
        }
        
        int[] result = new int[maxSumEnd - maxSumStart + 1];
        for (int j = 0 ; j < result.length ; j++){
            result[j] = nums[maxSumStart + j];
        }
        
        return result;

    } 
}
