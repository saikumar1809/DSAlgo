
public class Main
{
    static int subSetSum(int arr[],int n,int target){
        if(target==0||n==0){
            return 0;
        }
        if(arr[n-1]<=target){
            return(Math.max(arr[n-1]+subSetSum(arr,n-1,target-arr[n-1]),subSetSum(arr,n-1,target)));
        }
        else{
            return(subSetSum(arr,n-1,target));
        }
    }
	public static void main(String[] args) {
	    int[] arr= new int[]{};
	    int sum=0;
	    
		if(sum==subSetSum(arr,arr.length,sum) )System.out.println("Yes");
		else System.out.println("No");
	}
}
