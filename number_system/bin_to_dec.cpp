#include <bits/stdc++.h>
using namespace std;

string bin_to_dec(int n)
{
    int start;
    string num = "";
    while (n != 0)
    {
        start = n % 2;
        n = n / 2;
        string to_append = to_string(start);
        num += to_append;
    }
    reverse(num.begin(), num.end());
    return num;
}

int main()
{
    int n;
    cin >> n;

    cout << bin_to_dec(n) << endl;
    return 0;
}