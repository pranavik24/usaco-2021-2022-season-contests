# Description:
This is one of the problems I worked on for Uthe SACO 2021-2022 season in the December 2021 contest. 

# Problem: 
Bessie the cow is trying to walk from her favorite pasture back to her barn.
The pasture and farm are on an N×N grid (2≤N≤50), with her pasture in the top-left corner and the barn in the bottom-right corner. Bessie wants to get home as soon as possible, so she will only walk down and to the right. There are haybales in some locations that Bessie cannot walk through; she must walk around them.

Bessie is feeling a little tired today, so she wants to change the direction she walks at most K times (1≤K≤3) .

How many distinct paths can Bessie walk from her favorite pasture to the barn? Two paths are distinct if Bessie walks in a square in one path but not in the other.

**INPUT FORMAT (input arrives from the terminal / stdin)**:

The input for each test case contains T sub-test cases, each describing a different farm and each of which must be answered correctly to pass the full test case. The first line of input contains T (1≤T≤50). Each of the T sub-test cases follow.
Each sub-test case starts with a line containing N and K.
The next N lines each contain a string of N characters. Each character is either . if it is empty or 𝙷 if it has a haybale. It is guaranteed the top-left and bottom-right corners of the farm will not contain haybales.

**OUTPUT FORMAT (print output to the terminal / stdout)**:

Output T lines, the ith line containing the number of distinct paths Bessie can take in the ith sub-test case.
