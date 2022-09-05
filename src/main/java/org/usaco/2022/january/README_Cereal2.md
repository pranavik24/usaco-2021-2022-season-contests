# Description:

This was the third problem I solved on for the January 2022 Contest in the USACO 2021-2022 Season. 

# Problem Statement: 

Farmer John's cows like nothing more than cereal for breakfast! In fact, the cows have such large appetites that they will each eat an entire box of cereal for a single meal.
The farm has recently received a shipment with M different types of cereal (2≤M≤105). Unfortunately, there is only one box of each cereal! Each of the N cows (1≤N≤105) has a favorite cereal and a second favorite cereal. When given a selection of cereals to choose from, a cow performs the following process:

If the box of her favorite cereal is still available, take it and leave.
Otherwise, if the box of her second-favorite cereal is still available, take it and leave.
Otherwise, she will moo with disappointment and leave without taking any cereal.
Find the minimum number of cows that go hungry if you permute them optimally. Also, find any permutation of the N cows that achieves this minimum.

__INPUT FORMAT (input arrives from the terminal / stdin)__:

The first line contains two space-separated integers N and M.
For each 1≤i≤N, the i-th line contains two space-separated integers fi and si (1≤fi,si≤M and fi≠si) denoting the favorite and second-favorite cereals of the i-th cow.

__OUTPUT FORMAT (print output to the terminal / stdout)__:

Print the minimum number of cows that go hungry, followed by any permutation of 1…N that achieves this minimum. If there are multiple permutations, any one will be accepted.

__SAMPLE INPUT__:

8 10

2 1

3 4

2 3

6 5

7 8

6 7

7 5

5 8

__SAMPLE OUTPUT__:

1

1

3

2

8

4

6

5

7
