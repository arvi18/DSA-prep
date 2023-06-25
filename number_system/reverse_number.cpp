#include <bits/stdc++.h>
using namespace std;

void reverse_number(int n)
{
    if (n == 0)
        cout << 0;

    while (n != 0)
    {
        cout << abs(n) % 10;
        n = n / 10;
    }
}

int main()
{
    cout << endl;
    int n;
    cin >> n;

    reverse_number(n);

    cout << endl
         << endl;
    return 0;
}