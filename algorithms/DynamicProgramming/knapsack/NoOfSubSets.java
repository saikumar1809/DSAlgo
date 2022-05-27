/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

public class Main
{
    static int temp[][];
    static int countSubSets(int[] arr,int n,int k){
    for(int i=1;i<n+1;i++){
        for(int j=1;j<k+1;j++){
            if(arr[i-1]<=j){
                temp[i][j]=temp[i-1][j]+temp[i-1][j-arr[i-1]];
            }
            else{
                temp[i][j]=temp[i-1][j];
            }
        }
    }
    for(int i=0;i<n+1;i++){
		    for(int j=0;j<k+1;j++){
		        System.out.print(temp[i][j]+" ");
		    }
		    System.out.println();
		}
    return temp[n][k];
    }
	public static void main(String[] args) {
	//	System.out.println("Hello World");
		int arr[]=new int[]{3,5,6,7,9,2};
		int n=arr.length;
		int sum=9;
		temp=new int[n+1][sum+1];
		for(int i=0;i<n+1;i++){
		    for(int j=0;j<sum+1;j++){
		        if(i==0)temp[i][j]=0;
		       if(j==0) temp[i][j]=1;
		    }
		}
System.out.println(countSubSets(arr,n,sum));
	}
}
