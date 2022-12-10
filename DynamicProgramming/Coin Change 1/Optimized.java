
class Solution {
    public int coinChange(int[] coins, int amount) {
        
        /* DP Variable */
        /* This variable is going to represent the current amount we are at. */
        /* Since this is the Top-Down approach, we will start at 0..1..2....amount */
        int[] dp = new int[amount+1];
        
        
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        /* dp[x] -> Minimum # of Coins needed to get to 0 from x */
        
        /* Base Case - Amount = 0 */
        /* Because if the amount is 0, we don't need any coins to get to 0 */
        dp[0] = 0;
        
        
        
        /* Now we can solve this from dp[0] ... dp[amount] */
        for(int currentAmount = 1; currentAmount < amount+1; currentAmount++){
            /* Right now, we're at amount currentAmount. What is the minimum amount of coins it takes to get to 0 from currentAmount? */
            
            /* Here, we need to make the decision of what coin we want to use. */
            for(int coin: coins){
                if(currentAmount - coin >= 0){
                    /* Check if we can even use any coins to get to zero */
                    if(dp[currentAmount - coin] != Integer.MAX_VALUE){
                        
                        /* Add 1 to represent taking another coin */
                        /* Check if this choice leads to the LEAST amount of coins we need to get to 0 */
                        dp[currentAmount] = Math.min(dp[currentAmount], 1 + dp[currentAmount-coin]);
                    }
                        
                }
            }
        }
       
        /* Check if there's no no way these coins add up to 0 */
        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        
        /* Return the minimum amount */
        return dp[amount];
    }
}
