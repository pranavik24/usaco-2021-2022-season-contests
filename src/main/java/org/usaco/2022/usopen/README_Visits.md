# Description:

I solved this problem for the 2022 US Open Contest for the 2021-2022 USACO Contest. 

# Problem Statement: 

Each of Bessie’s N (2≤N≤105) bovine buddies (conveniently labeled 1…N) owns her own farm. For each 1≤i≤N, buddy i wants to visit buddy ai (ai≠i).

Given a permutation (p1,p2,…,pN) of 1…N, the visits occur as follows.

For each i from 1 up to N:

If buddy api has already departed her farm, then buddy pi remains at her own farm.
Otherwise, buddy pi departs her farm to visit buddy api’s farm. This visit results in a joyful "moo" being uttered vpi times (0≤vpi≤109).
Compute the maximum possible number of moos after all visits, over all possible permutations p.

__INPUT FORMAT (input arrives from the terminal / stdin)__:

The first line contains N.
For each 1≤i≤N, the i+1-st line contains two space-separated integers ai and vi.

__OUTPUT FORMAT (print output to the terminal / stdout__):

A single integer denoting the answer.
Note that the large size of integers involved in this problem may require the use of 64-bit integer data types (e.g., a "long long" in C/C++).

__SAMPLE INPUT__:

4

2 10

3 20

4 30

1 40

__SAMPLE OUTPUT__:

90
