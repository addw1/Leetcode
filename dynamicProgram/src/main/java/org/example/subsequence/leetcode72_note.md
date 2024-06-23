## Edit Distance
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

- Insert a character
- Delete a character
- Replace a character

**Example 1:**
<br>Input: word1 = "horse", word2 = "ros"
<br>Output: 3
<br>**Explanation:**
horse -> rorse (replace 'h' with 'r')
<br>rorse -> rose (remove 'r')
<br>rose -> ros (remove 'e')
**Example 2:**
<br>Input: word1 = "intention", word2 = "execution"
<br>Output: 5
<br>**Explanation:**
<br>intention -> inention (remove 't')
<br>inention -> enention (replace 'i' with 'e')
<br>enention -> exention (replace 'n' with 'x')
<br>exention -> exection (replace 'n' with 'c')
<br>exection -> execution (insert 'u')
<br>Constraints:<br>
> 0 <= word1.length, word2.length <= 500<br>
    word1 and word2 consist of lowercase English letters.

### define the state
For two strings questions, we always choose to set two index for i and j.
<br> `dp[x][y]` is used to represent how many steps need when i in the x position and j in the y positon.

### state change equation 
base state: i = 0, j = 0. so `dp[0][0]=0`. Because both word1 and word2 are empty words.
use some examples to find the pattern:
<br> word1: ap`p`le 
<br>word2: b`e`le 
<br> make `e` and `p` equal, you have **three** choices.
<br> 1 change e to p. and then you can move i and j
<br> 2 delete e, you can move j.
<br> 3 insert p you can move i.
<br> when i and j equal to 0, it means that you find the answer.
<br>**move condition**
<br> all the chars after i and j are equal.