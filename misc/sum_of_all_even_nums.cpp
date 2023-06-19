// sum of all even numbers from 1 to N
#include <iostream>
using namespace std;

int get_even_sum_till_N(int n)
{
    if (n == 0 || n == 1)
    {
        return 0;
    }
    return n + get_even_sum_till_N(n - 2);
};

int get_even_sum_till_N_using_while(int n)
{
    int sum = 0;
    int i = 2;
    while (i <= n)
    {
        cout << i << " " << endl;
        sum += i;
        i += 2;
    }
    return sum;
}

int main()
{
    int sum = 0, n, i = 2;

    cin >> n;

    cout << endl
         << get_even_sum_till_N_using_while(n) << endl;
    cout << get_even_sum_till_N(n) << endl;

    return 0;
}