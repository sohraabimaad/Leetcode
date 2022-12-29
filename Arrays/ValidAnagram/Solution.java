class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        
        char[] charArray = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        
        
        
        for(int i = 0; i < charArray.length; i++){
            
            if( hm.get(charArray[i]) == null)
                hm.put(charArray[i], 1);
            else
                hm.put(charArray[i], hm.get(charArray[i])+1);
        }
        
        for(int i = 0; i < charArrayT.length; i++){
           if(hm.get(t.charAt(i)) == null)
                return false;
           else if(hm.get(t.charAt(i)) == 1)
               hm.remove(t.charAt(i));
            else if(hm.get(t.charAt(i)) > 1)
                hm.put(t.charAt(i), hm.get(t.charAt(i))-1);
        }
        if(hm.size() > 0)
            return false;
        
        return true;
    }
}
 
