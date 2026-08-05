1class Solution {
2
3    public int findInMountainArray(int target, MountainArray mountainArr) {
4
5        int n = mountainArr.length();
6
7        int peak = findPeak(mountainArr, n);
8
9        if (mountainArr.get(peak) == target)
10            return peak;
11
12        int left = binarySearchAsc(mountainArr, target, 0, peak - 1);
13
14        if (left != -1)
15            return left;
16
17        return binarySearchDesc(mountainArr, target, peak + 1, n - 1);
18    }
19
20    private int findPeak(MountainArray arr, int n) {
21
22        int left = 0;
23        int right = n - 1;
24
25        while (left < right) {
26
27            int mid = left + (right - left) / 2;
28
29            if (arr.get(mid) < arr.get(mid + 1)) {
30                left = mid + 1;
31            } else {
32                right = mid;
33            }
34        }
35
36        return left;
37    }
38
39    private int binarySearchAsc(MountainArray arr, int target, int left, int right) {
40
41        while (left <= right) {
42
43            int mid = left + (right - left) / 2;
44
45            int value = arr.get(mid);
46
47            if (value == target)
48                return mid;
49
50            if (value < target)
51                left = mid + 1;
52            else
53                right = mid - 1;
54        }
55
56        return -1;
57    }
58
59    private int binarySearchDesc(MountainArray arr, int target, int left, int right) {
60
61        while (left <= right) {
62
63            int mid = left + (right - left) / 2;
64
65            int value = arr.get(mid);
66
67            if (value == target)
68                return mid;
69
70            if (value > target)
71                left = mid + 1;
72            else
73                right = mid - 1;
74        }
75
76        return -1;
77    }
78}