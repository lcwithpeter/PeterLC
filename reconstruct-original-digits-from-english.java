/*
Source : https://leetcode.com/problems/reconstruct-original-digits-from-english/
Author : Jiayi Lei
Date   : Nov 12, 2015

Description:
	Given a non-empty string containing an out-of-order English representation 
	of digits 0-9, output the digits in ascending order.

Note:
	Input contains only lowercase English letters.
	Input is guaranteed to be valid and can be transformed to its original 
	digits. That means invalid inputs such as "abc" or "zerone" are not 
	permitted.
	Input length is less than 50,000.
Example 1:
	Input: "owoztneoer"
	Output: "012"

Example 2:
	Input: "fviefuro"
	Output: "45"
*/

// version 1
// 55 ms
public class Solution {
    public String originalDigits(String s) {
        int[] alphabet = new int[26];
        
        for(char c : s.toCharArray()){
            alphabet[c - 'a']++;
        }
        
        String[] nums = {"zero", "two", "six", "eight", "three", "four", "seven",
		"one", "five", "nine"};
        PriorityQueue<Integer> heap = new PriorityQueue();
        StringBuilder sb = new StringBuilder();
        
        
        outter:
        for(int i = 0; i < nums.length;){
            for(char c : nums[i].toCharArray()){
                if(alphabet[c - 'a'] == 0){
                    i++;
                    continue outter;
                }
            }
            for(char c : nums[i].toCharArray()){
                alphabet[c - 'a']--;
            }			
            heap.offer(getNum(nums[i]));
        }
        
        while(!heap.isEmpty()){
            sb.append(heap.poll());
        }
        return sb.toString();
    }
    private int getNum(String s){
        switch(s){
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return -1;
        }
    }
}

// version 2
// 16 ms
public class Solution {
    public String originalDigits(String s) {
        int[] t = new int[26];        
        for(char c : s.toCharArray()){
            t[c - 'a']++;
        }
        
        int[] counter = new int[10];        
        while(true){
            // zero
            if(t['z' - 'a'] > 0){
                t['z' - 'a']--;
                t['e' - 'a']--;
                t['r' - 'a']--;
                t['o' - 'a']--;
                counter[0]++;
            }
            // two
            else if(t['w' - 'a'] > 0){
                t['t' - 'a']--;
                t['w' - 'a']--;
                t['o' - 'a']--;
                counter[2]++;
            }
            // six
            else if(t['x' - 'a'] > 0){
                t['s' - 'a']--;
                t['i' - 'a']--;
                t['x' - 'a']--;
                counter[6]++;
            }
            // eight
            else if(t['g' - 'a'] > 0){
                t['e' - 'a']--;
                t['i' - 'a']--;
                t['g' - 'a']--;
                t['h' - 'a']--;
                t['t' - 'a']--;
                counter[8]++;
            }
            // three
            else if(t['h' - 'a'] > 0){
                t['t' - 'a']--;
                t['h' - 'a']--;
                t['r' - 'a']--;
                t['e' - 'a'] -= 2;
                counter[3]++;
            }
            // four
            else if(t['u' - 'a'] > 0){
                t['f' - 'a']--;
                t['o' - 'a']--;
                t['u' - 'a']--;
                t['r' - 'a']--;
                counter[4]++;
            }
            // seven
            else if(t['s' - 'a'] > 0){
                t['s' - 'a']--;
                t['e' - 'a'] -= 2;
                t['v' - 'a']--;
                t['n' - 'a']--;
                counter[7]++;
            }
            // one
            else if(t['o' - 'a'] > 0){
                t['o' - 'a']--;
                t['n' - 'a']--;
                t['e' - 'a']--;
                counter[1]++;
            }
            // five
            else if(t['f' - 'a'] > 0){
                t['f' - 'a']--;
                t['i' - 'a']--;
                t['v' - 'a']--;
                t['e' - 'a']--;
                counter[5]++;
            }
            // nine
            else if(t['n' - 'a'] > 0){
                t['n' - 'a'] -= 2;
                t['i' - 'a']--;
                t['e' - 'a']--;
                counter[9]++;
            }
            else break;
        }
        
        StringBuilder sb = new StringBuilder();        
        for(int i = 0; i < counter.length; i++){
            while(counter[i]-- > 0){
                sb.append(i);
            }
        }
        
        return sb.toString();
    }
}
