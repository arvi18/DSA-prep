#include <bits/stdc++.h>
using namespace std;

int main()
{
    cout << endl;

    class Solution
    {
    public:
        int bitwiseComplement(int n)
        {
            if (n == 0)
            {
                return 1;
            }
            string num = "", comple = "";
            while (n != 0)
            {
                num += to_string(n % 2);
                n = n / 2;
            }
            for (int i = 0; i < num.length(); i++)
            {
                if (num[i] == '0')
                {
                    comple += '1';
                }
                else
                {
                    comple += '0';
                }
            }
            int ans = 0;

            for (int i = 0; i < comple.length(); i++)
            {
                ans += pow(2, (i)) * ((comple[i]) - '0');
            }
            return ans;
        }
    };

    cout << endl
         << endl;
    return 0;
}