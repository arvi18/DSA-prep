#include <iostream>
#include <string.h>
using namespace std;

void square(int n)
/*
square

* * * *
* * * *
* * * *
* * * *

*/
{
    cout << "square" << endl;
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
/*
square_numbered

1 1 1 1
2 2 2 2
3 3 3 3
4 4 4 4

*/
{
    cout << "square_numbered" << endl;
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
/*
square_increasing_numbered

1       2       3       4
5       6       7       8
9       10      11      12
13      14      15      16

*/
{
    cout << "square_increasing_numbered" << endl;
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

void square_increasing_numbered_same_row(int n)
/*
square_increasing_numbered_same_row
1
2       3
3       4       5
4       5       6       7

*/
{
    cout << "square_increasing_numbered_same_row" << endl;

    for (int i = 1; i <= n; i++)
    {
        for (int j = 0; j < i; j++)
        {

            cout << i + j << "\t";
        }
        cout << endl;
    }
}

void half_pyramid(int n)
/*
half_pyramid
*
* *
* * *
* * * *

*/

{
    cout << "half_pyramid" << endl;

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
    // square_increasing_numbered(n);
    // square_increasing_numbered_same_row(n);
    half_pyramid(n);

    return 0;
}
