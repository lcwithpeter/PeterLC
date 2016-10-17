/*
Source : https://leetcode.com/problems/unique-word-abbreviation/
Author : Jiayi Lei
Date   : Oct 11, 2015
Description:
    An abbreviation of a word follows the form 
	<first letter><number><last letter>
	
Below are some examples of word abbreviations:
	a) it                      --> it    (no abbreviation)

		 1
	b) d|o|g                   --> d1g

				  1    1  1
		 1---5----0----5--8
	c) i|nternationalizatio|n  --> i18n

				  1
		 1---5----0
	d) l|ocalizatio|n          --> l10n

Assume you have a dictionary and given a word, find whether its abbreviation is 
unique in the dictionary. A word's abbreviation is unique if no other word from 
the dictionary has the same abbreviation.

Example: 
	Given dictionary = [ "deer", "door", "cake", "card" ]

	isUnique("dear") -> false
	isUnique("cart") -> true
	isUnique("cane") -> false
	isUnique("make") -> true

Tags:
	Hash Table; Design
*/

public class ValidWordAbbr {
    Map<String, List<String>> map = new HashMap<String, List<String>>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abbr = helper(s);
            if(!map.containsKey(abbr)) map.put(abbr, new LinkedList());
            map.get(abbr).add(s);
        }
    }

    public boolean isUnique(String word) {
        if(map.size() == 0) return true;
        String abbr = helper(word);
        if(map.containsKey(abbr)){
            if(map.get(abbr).contains(word)){
                return map.get(abbr).size() == 1;
            }else return false;
        }else return true;
    }
    
    private String helper(String s){
        if(s.length() > 2){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(0));
            sb.append(s.length() - 2);
            sb.append(s.charAt(s.length() - 1));
            return sb.toString();
        }
        return s;
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
