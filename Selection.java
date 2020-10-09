import java.util.Scanner;
public class Selection
{
public static void main(String[] args) 
{
int n, res,i;
Scanner s = new Scanner(System.in);
System.out.print("Enter length of array:");
n = s.nextInt();
int a[] = new int[n];
System.out.println("Enter "+n+" elements ");
for( i=0; i < n; i++)
{
a[i] = s.nextInt();
}
 
System.out.println( "elements in array ");
displayarray(a);
Sort(a);
System.out.println( "\nelements after sorting");
displayarray(a);
 
}
public static void Sort(int a[])
{ 
int n=a.length,i,j,p,tempspace;
for (i = 0; i < n - 1; i++) 
{ 
p = i; 
for (j=i+1; j < n; j++)
{ 
if (a[p]>a[j]) 
p=j; 
 
} 
tempspace=a[p];
a[p]=a[i];
a[i]=tempspace;
 
} 
}
public static void displayarray(int a[])
{
for(int i=0; i < a.length; i++)
{
 
System.out.println(a[i]+" ");
}
 
}
 
}