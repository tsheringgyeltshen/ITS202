import java.util.*;

public class Mergesort
{
  public static void main(String args[])
  {
    int i, n;
    Scanner obj = new Scanner(System.in);
    System.out.print("Enter the length of the array:  ");
    n = obj.nextInt();
    int a[] = new int[n];

    System.out.print("Enter elements of the array: ");
    for(i=0; i<n; i++)
      a[i] = obj.nextInt();

    MyMergeSort.sort_unorthodox(a);
    System.out.print("\nSorted array: ");
    System.out.println(Arrays.toString(a));
  }
} 

class MyMergeSort
{
  public static void sort_unorthodox(int a[])
  {
    int sorted_a[] = divide(a);
    for(int i = 0; i < a.length; i++) // copying the sorted array into the original array
      a[i] = sorted_a[i];
  }

  static int[] divide(int a[])
  {
    if(a.length <= 1) // one element array, nothing to sort
      return a;

    int i, left_size = a.length/2, right_size;
    if(a.length % 2 == 0)
      right_size = left_size;
    else
      right_size = left_size + 1;
    int left_half[] = new int[left_size];
    int right_half[] = new int[right_size];

    for(i=0; i<left_size; i++)
      left_half[i] = a[i];
    for(i=0; i<right_size; i++)
      right_half[i] = a[left_size+i];

    left_half = divide(left_half);
    right_half = divide(right_half);
    return merge(left_half, right_half);
  }

  static int[ ] merge(int a[ ], int b[ ])
  {
    int i=0, j=0, k=0, m = a.length, n = b.length;
    int c[ ];
    c = new int[m+n];

    while(i<m && j<n)
    {
      if(a[i] < b[j])
        c[k++] = a[i++];
      else
        c[k++] = b[j++];
    }
    while(i<m)
      c[k++] = a[i++];
    while(j<n)  
      c[k++] = b[j++];
    return c;
  }
} 
  