1class Solution {
2    public char nextGreatestLetter(char[] letters, char target) {
3        int left = 0;
4        int right = letters.length-1;
5        while(left <= right){
6            int mid = left + (right-left)/2;
7            if(letters[mid] <= target){
8                left = mid+1;
9            }
10            else{
11                right = mid-1;
12            }
13
14        }
15        if(left == letters.length){
16            return letters[0];
17        }
18        else{
19            return letters[left];
20        }
21    }
22}