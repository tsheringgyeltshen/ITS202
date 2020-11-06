import java.util.Arrays;

public class Keyindex {
    public static void main(String[] args){
        int r = 6;
        
        //Can only contain elements 0<=i<=5 as r = 6
        int a[] = {2,3,1,1,1,0,5,1,1,2,3,0};
        int N = a.length;
        
        //Count array to keep track of the number of type of 
        //different elements
        int count[] = new int[r+1];
        int aux[]=new int[N];
        
        for(int i=0;i<N;++i){
            count[a[i]+1]++;
        }
        
        for(int i=0;i<r;++i){
            count[i+1] += count[i];
        }
        
        for(int i=0; i<N; i++)
            aux[count[a[i]]++]=a[i];

        for(int i=0; i<N; i++)
            a[i]=aux[i]; 

        for(int i=0; i<N; i++){
            System.out.print(a[i]);
        } 

        System.out.println("");       
        }
    
}
