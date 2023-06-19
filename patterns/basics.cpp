#include <iostream>
#include <string.h>
using namespace std;

void square(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << "* ";
        }
        cout << endl;
    }
}

void square_numbered(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << i + 1 << " ";
        }
        cout << endl;
    }
}

void square_increasing_numbered(int n)
{
    int x = 1;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << x << "\t";
            x++;
        }
        cout << endl;
    }
}

void half_pyramid(int n)
{
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j <= i; j++)
        {
            cout << "* ";
        }
        cout << endl;
    }
}

int main()
{

    int n;

    cin >> n;
    cout << "\n";

    // square(n);
    // square_numbered(n);
    square_increasing_numbered(n);
    // half_pyramid(n);

    return 0;
}
