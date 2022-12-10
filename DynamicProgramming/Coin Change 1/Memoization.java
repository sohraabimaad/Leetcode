class Solution {
    public int coinChange(int[] coins, int amount) {
        
        /* Memoisation Code */
        HashMap<Integer, Integer> memo = new HashMap<>();
        
        int minimumCoins = dfs(coins, amount, memo);
        
        /* Check if there's no way these coins add up to 0 */
        if(minimumCoins == Integer.MAX_VALUE)
            return -1;
        
        /* Return the minimum value */
        return minimumCoins;
    }
    
    public int dfs(int[] coins, int amount, HashMap<Integer, Integer> memo){
        /* Base Case - We hit our total */
        if(amount == 0)
            return 0;
        
        /* If we've already been down this decision tree, we can just return the value we've stored */
        if(memo.get(amount) != null)
            return memo.get(amount);
        
        /* Variable to store the minimum amount of coins it takes to get to 0 from here. */
        int min = Integer.MAX_VALUE;
        
        /* We still have to hit our total, see if we can use any coins */
        
        /* Pick each coin... */
        for(int coin: coins){
            /* Can we use this coin? We can only use it if it's bigger than amount */
            if(amount - coin >= 0){
                /* We can use this coin! */
                
                /* Find out how many coins it takes to get to 0 from here. */
                int coinsToGetToZero = dfs(coins, amount - coin, memo);
                
                /* Check if we can even use any coins to get to zero */
                if(coinsToGetToZero != Integer.MAX_VALUE){
                    /* Each time we make a recursive call, we need to add 1 representing another coin we used. */
                    coinsToGetToZero = 1 + coinsToGetToZero;
                        
                    /* Check if this choice leads to the LEAST amount of coins we need to get to 0*/
                    min = Math.min(min, coinsToGetToZero);
                }
            }
        }
        
        /* Save this tree to avoid re-doing work */
        memo.put(amount, min);
        
        /* We can return the minimum amount of coins it takes to get to 0 from here */
        return min;
    }
}
