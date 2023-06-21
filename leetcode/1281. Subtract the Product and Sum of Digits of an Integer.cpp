#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int subtractProductAndSum(int n)
    {
        int sum = 0, mul = 1;
        string hehe = to_string(n);
        for (int i = 0; i < hehe.length(); i++)
        {
            sum += (hehe[i]) - '0';
            mul *= (hehe[i]) - '0';
        }
        return mul - sum;
    }
};