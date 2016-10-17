/*
Source : https://leetcode.com/problems/subsets/
Author : Jiayi Lei
Date   : Jul 7, 2015

Description:
    Given a set of distinct integers, nums, return all possible subsets.

    Note:
    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.
    For example,
    If nums = [1,2,3], a solution is:
        [
          [3],
          [1],
          [2],
          [1,2,3],
          [1,3],
          [2,3],
          [1,2],
          []
        ]
    
Tags: Bit Manipulation; Array; Backtracking
*/

/*
This is an amazing solution.Learnt a lot.Let me try to explain this to those 
who didn't get the logic.

 Number of subsets for {1 , 2 , 3 } = 2^3 .
 why ? 
case    possible outcomes for the set of subsets
  1   ->          Take or don't take = 2 
  2   ->          Take or don't take = 2  
  3   ->          Take or don't take = 2 

therefore , total = 2*2*2 = 2^3 = {
    { } , {1} , {2} , {3} , {1,2} , {1,3} , {2,3} , {1,2,3} 
    }

Lets assign bits to each outcome  -> First bit to 1 , Second bit to 2 and third
bit to 3
Take = 1
Don't take = 0

0) 0 0 0  -> Don't take 3 , Don't take 2 , Don't take 1 = { } 
1) 0 0 1  -> Don't take 3 , Don't take 2 ,   take 1     = {1} 
2) 0 1 0  -> Don't take 3 ,    take 2    , Don't take 1 = {2} 
3) 0 1 1  -> Don't take 3 ,    take 2    ,   take 1     = {1, 2} 
4) 1 0 0  ->    take 3    , Don't take 2 , Don't take 1 = {3} 
5) 1 0 1  ->    take 3    , Don't take 2 ,   take 1     = {1, 3} 
6) 1 1 0  ->    take 3    ,    take 2    , Don't take 1 = {2, 3} 
7) 1 1 1  ->    take 3    ,    take 2    ,   take 1     = {1, 2, 3} 

In the above logic ,Insert S[i] only if (j>>i)&1 == true   
{ j E { 0,1,2,3,4,5,6,7 }   i = i-th element in the input array }

element 1 is inserted only into those places where 1st bit of j is 1 
   if( j >> 0 &1 )  ==> for above above eg. 
   this is true for sl.no.( j )= 1 , 3 , 5 , 7 

element 2 is inserted only into those places where 2nd bit of j is 1 
   if( j >> 1 &1 )  == for above above eg. 
   this is true for sl.no.( j ) = 2 , 3 , 6 , 7

element 3 is inserted only into those places where 3rd bit of j is 1 
   if( j >> 2 & 1 )  == for above above eg. 
   this is true for sl.no.( j ) = 4 , 5 , 6 , 7 

Time complexity : O(n*2^n) , for every input element loop traverses the whole 
solution set length i.e. 2^n
*/

// solution 1
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.length > 0){
            Arrays.sort(nums);
            int lenEle = nums.length;
            int lenSub = (int) Math.pow(2, lenEle);
            for(int i = 0; i < lenEle; i++){
                for(int j = 0; j < lenSub; j++){
                    try{
                        list.get(j);
                    }catch(IndexOutOfBoundsException e){
                        list.add(new ArrayList<Integer>());
                    }
                    if(((j >> i) & 1) == 1) list.get(j).add(nums[i]);
                }
            }
        }
        return list;
    }
}

// solution 2
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(nums.length == 0) return list;
        Arrays.sort(nums);
        for(int n = 0; n < Math.pow(2, nums.length); n++){
            List<Integer> sub = new LinkedList<Integer>();
            for(int i = 1, j = 0; i <= n; i <<= 1, j++){
                if((i&n) != 0){
                    sub.add(nums[j]);
                }
            }
            list.add(sub);
        }
        
        return list;
    }
}
