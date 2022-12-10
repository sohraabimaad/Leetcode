class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        return canBuild(s, wordDict);
    }
    
    public boolean canBuild(String target, List<String> wordDict){
        
        /* If there are no more words to build */
        if(target.isEmpty())
            return true;
        
        /* See if you can build any words by checking if target starts with any word*/
        for(String word: wordDict){
            if(target.startsWith(word)){
                /* See if you can build the rest of the words */
                return canBuild(target.substring(word.length()), wordDict);
            }
        }
        
        /* Can't build */
        return false;
    }
}
