#include <iostream>
using namespace std;

// 0, 1, 1, 2, 3, 5, ...
void print_fibonacchi_sequence(int n)
{
    int current = 1, prev = 0, _, sum;

    for (int i = 0; i < n; i++)
    {
        cout << prev << endl;
        sum += prev;
        _ = current;
        current += prev;
        prev = _;
    }
    cout << "sum till " << n << " is: " << sum << endl;
}

int main()
{

    int n;
    cin >> n;

    print_fibonacchi_sequence(n);
    return 0;
}