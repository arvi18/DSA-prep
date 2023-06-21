#include <bits/stdc++.h>
using namespace std;

class Solution
{
public:
    int hammingWeight(uint32_t n)
    {
        string bin = bitset<32>(n).to_string();
        int sum = 0;
        for (int i = 0; i < bin.length(); i++)
        {
            if (bin[i] - '0' == 1)
            {
                sum++;
            }
        }
        return sum;
    }
};