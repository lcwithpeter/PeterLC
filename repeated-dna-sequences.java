/*
Source : https://leetcode.com/problems/repeated-dna-sequences/
Author : Jiayi Lei
Date   : Jul 9, 2015

Description:
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and 
    T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to 
    identify repeated sequences within the DNA.

    Write a function to find all the 10-letter-long sequences (substrings) that
    occur more than once in a DNA molecule.

For example,
    Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
    Return:
    ["AAAAACCCCC", "CCCCCAAAAA"].
    
Tags: Bit Manipulation; Hash Table
*/

// solution 1
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<String>();
		if(s.length() > 10){
			Set<Integer> once = new HashSet<Integer>();
			Set<Integer> twice = new HashSet<Integer>();
			char[] map = new char[26];
			map['A' -'A'] = 0;
			map['C' -'A'] = 1;
			map['G' -'A'] = 2;
			map['T' -'A'] = 3;
			
			for(int i = 0; i < s.length() - 10 + 1; i++){
				int v = 0;
				for(int j = i; j < i + 10; j++){
					v <<= 2;
					v |= map[s.charAt(j) - 'A'];
				}
				if(!once.add(v) && twice.add(v)){
					list.add(s.substring(i, i + 10));
				}
			}
		}
		return list;
    }
}

//solution 2
public List<String> findRepeatedDnaSequences(String s) {
    List<String> list = new ArrayList<String>();
    if(s.length() > 10){
        Set<Integer> once = new HashSet<Integer>();
        Set<Integer> twice = new HashSet<Integer>();
        
        for(int i = 0; i < s.length() - 10 + 1; i++){
            int v = 0;
            for(int j = i; j < i + 10; j++){
                v <<= 2;
                v |= trans(s.charAt(j));
            }
            if(!once.add(v) && twice.add(v)){
                list.add(s.substring(i, i + 10));
            }
        }
    }
    return list;
}
private int trans(char c){
    switch(c){
    case 'A': return 0;
    case 'C': return 1;
    case 'G': return 2;
    case 'T': return 3;
    }
    return 0;
}
