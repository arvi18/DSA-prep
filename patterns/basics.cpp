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

void square_lettered(int n)
/*
square_lettered
A A A A
B B B B
C C C C
D D D D

*/
{
    cout << "square_lettered" << endl;
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cout << char(65 + i) << " ";
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

void square_increasing_numbered_decreasing_same_row(int n)
/*
1
2 1
3 2 1
4 3 2 1

*/
{
    int i = 1;
    while (i <= n)
    {
        int j = 0;
        while (j < i)
        {
            cout << i - j << " ";
            j++;
        }
        i++;
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

void half_pyramid_right_reversed(int n)
/*
half_pyramid
       *
     * *
   * * *
 * * * *

*/

{
    cout << "half_pyramid_right_reversed" << endl;

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (j < n - i - 1)
                cout << "  ";
            else
                cout << "* ";
        }
        cout << endl;
    }
}

void sqaure_perimeter(int n)
{
    /*

    * * * *
    *     *
    *     *
    * * * *

    */
    int i = 0;
    while (i < n)
    {
        int j = 0;
        while (j < n)
        {
            if (j == 0 || i == 0 || i == n - 1 || j == n - 1)

                cout << "* ";
            else
                cout << "  ";
            j++;
        }
        i++;
        cout << endl;
    }
}

void master(int n)
{
    /*
    5*10

    1 2 3 4 5 5 4 3 2 1
    1 2 3 4 * * 4 3 2 1
    1 2 3 * * * * 3 2 1
    1 2 * * * * * * 2 1
    1 * * * * * * * * 1
    */

    int i = 1;
    while (i <= n)
    {
        int j = 1;
        // int star_counter = 0;
        // first half
        while (j <= 2 * n)
        {
            if (j <= n - i + 1)
            {
                cout << j << " ";
            }
            else if (j > i && j < n + i)
            {
                cout << "* ";
            }
            else
            {
                cout << 2 * n - j + 1 << " ";
            }
            j++;
        }
        i++;
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
    // square_lettered(n);
    // square_increasing_numbered(n);
    // square_increasing_numbered_same_row(n);
    // square_increasing_numbered_decreasing_same_row(n);
    // half_pyramid_right_reversed(n);
    // sqaure_perimeter(n);
    master(n);

    return 0;
}
