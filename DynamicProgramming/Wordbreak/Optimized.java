class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashMap<String, Boolean> hm = new HashMap<>();
        
        canBuild(s, wordDict, hm);
        return hm.get(s);
    }
    
    public boolean canBuild(String target, List<String> wordDict,HashMap<String, Boolean> hm){
        if(target.isEmpty())
            return true;
        
        if(hm.containsKey(target))
            return hm.get(target);
        
        for(String word: wordDict){
            if(target.startsWith(word)){
                boolean cb = canBuild(target.substring(word.length()), wordDict, hm);
                if(cb){
                    hm.put(target, true);
                    return true;
                }
            }
        }
        hm.put(target, false);
        return false;
    }
    
}
