#include <bits/stdc++.h>
using namespace std;
#define ll long long

string bin_to_dec(int n)
{
    int start;
    string num = "";
    if (n == 0)
        return "0";
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
    cout << endl;
    int n;
    cin >> n;

    cout << "Binary of " << n << " is: " << bin_to_dec(n);

    // ll max = INT_MAX, min = INT_MIN;
    // cout << max << " " << min << " " << abs(min) - abs(max);

    cout << endl
         << endl;

    return 0;
}