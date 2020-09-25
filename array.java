public class array{
    static int[] a1;
    public static int[] resize(int length){
        int[] forawhile=new int[length];

    for(int i=0; i<a1.length;i++){
        forawhile[i]=a1[i];
    }
    forawhile[length-1]=4;
    a1=forawhile;
    return a1;
    }
    public static void main(String[] args){
        a1=new int[3];
        a1[0]=1;
        a1[1]=2;
        a1[2]=3;
        int[] a2=resize(4);

        for(int i=0; i<a2.length; i++){
            System.out.println(a2[i]);
        }
    }
}