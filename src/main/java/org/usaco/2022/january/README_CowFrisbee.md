# Description:

I worked on this problem for the January 2022 Contest for the USACO 2021-2022 Season. 

# Problem Statement:

Farmer John's N cows (N≤3×105) have heights 1,2,…,N. One day, the cows are standing in a line in some order playing frisbee; let h1…hN denote the heights of the cows in this order (so the h's are a permutation of 1…N).
Two cows at positions i and j in the line can successfully throw the frisbee back and forth if and only if every cow between them has height lower than min(hi,hj).

Please compute the sum of distances between all pairs of locations i<j at which there resides a pair of cows that can successfully throw the frisbee back and forth. The distance between locations i and j is j−i+1.

__INPUT FORMAT (input arrives from the terminal / stdin)__:

The first line of input contains a single integer N. The next line of input contains h1…hN, separated by spaces.

__OUTPUT FORMAT (print output to the terminal / stdout)__:
Output the sum of distances of all pairs of locations at which there are cows that can throw the frisbee back and forth. Note that the large size of integers involved in this problem may require the use of 64-bit integer data types (e.g., a "long long" in C/C++).

__SAMPLE INPUT__:

7

4 3 1 2 5 6 7

__SAMPLE OUTPUT__:

24
