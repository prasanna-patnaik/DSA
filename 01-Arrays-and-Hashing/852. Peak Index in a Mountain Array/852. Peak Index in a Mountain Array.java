1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3
4        int left = 0;
5        int right = arr.length - 1;
6
7        while (left < right) {
8
9            int mid = left + (right - left) / 2;
10
11            if (arr[mid] < arr[mid + 1]) {
12                left = mid + 1;
13            } else {
14                right = mid;
15            }
16        }
17
18        return left;
19    }
20}