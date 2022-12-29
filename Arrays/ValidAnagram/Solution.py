class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        hashmap = {}

        for letter in s:
            hashmap[letter] = hashmap.get(letter, 0) + 1
        
        for letter in t:
            if hashmap.has_key(letter):
                hashmap[letter] = hashmap.get(letter) - 1
                if hashmap[letter] == 0:
                    hashmap.pop(letter)
            else:
                return False
        
        if len(hashmap) > 0:
            return False

        return True
