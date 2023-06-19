#include <iostream>
using namespace std;

int fact(int n)
{
    if (n == 0 || n == 1)
    {
        cout << "fact(" << n << ") = " << 1 << endl;
        return 1;
    }
    cout << "fact(" << n << ") = " << n << " * fact(" << n - 1 << ")" << endl;
    return n * fact(n - 1);
}

int main()
{
    int n;
    cin >> n;
    fact(n);

    return 0;
}