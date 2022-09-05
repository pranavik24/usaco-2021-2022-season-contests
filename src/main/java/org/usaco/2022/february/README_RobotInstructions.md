# Description: 

I solved this problem for the February 2022 Contest for the 2021-2022 USACO Season. 

# Problem Statement:

Bessie is learning how to control a robot she has recently received as a gift.
The robot begins at point (0,0) on the coordinate plane and Bessie wants the robot to end at point (xg,yg). Bessie initially has a list of N (1≤N≤40) instructions to give to the robot, the i-th of which will move the robot xi units right and yi units up (or left or down when xi and yi are negative, respectively).

For each K from 1 to N, help Bessie count the number of ways she can select K instructions from the original N such that after the K instructions are executed, the robot will end at point (xg,yg).

__INPUT FORMAT (input arrives from the terminal / stdin)__:

The first line contains N. The next line contains xg and yg, each in the range −109…109. The final N lines describe the instructions. Each line has two integers xi and yi, also in the range −109…109.
It is guaranteed that (xg,yg)≠(0,0) and (xi,yi)≠(0,0) for all i.

__OUTPUT FORMAT (print output to the terminal / stdout)__:

Print N lines, the number of ways Bessie can select K instructions from the original N for each K from 1 to N.

__SAMPLE INPUT__:

7

5 10

-2 0

3 0

4 0

5 0

0 10

0 -10

0 10

__SAMPLE OUTPUT__:

0

2

0

3

0

1

0
