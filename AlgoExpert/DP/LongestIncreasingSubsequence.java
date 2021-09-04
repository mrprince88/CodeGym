import java.util.Arrays;

public class LongestIncreasingSubsequence {

	// O(n^2) solution 
	static int solver(int []arr,int n) {
		int []dp=new int[n];
		int best=0;

		for(int i=1;i<n;i++) {
			dp[i]=1;

			for(int j=i-1;j>=0;j--) {
				if(arr[i]>arr[j])
					dp[i]=Math.max(dp[i],dp[j]+1);
			}
			best=Math.max(best,dp[i]);
		}
		return best;
	}


	//O(nlog n) Binary Search Solution

	static int solver2(int []arr,int n) {
		int []tmp=new int[n];
		tmp[0]=arr[0];
		int len=1;

		for(int i=1;i<n;i++) {
			if(arr[i]>tmp[len-1])
				tmp[len++]=arr[i];
			else {
				int j=upperBound(tmp,0,len-1,arr[i]);
				tmp[j]=arr[i];
			}
		}

		System.out.print("Squence: ");
		for(int i=0;i<len;i++)
			System.out.print(tmp[i]+" ");

		System.out.println();

		return len;
	}

	static int upperBound(int []arr,int min,int max,int n) {
		int res=0;

		while(min<=max) {
			int mid=min+(max-min)/2;
			if(arr[mid]>n) {
				res=mid;
				max=mid-1;
			}
			else
				min=mid+1;
		}

		return res;
	}

	public static void main(String[] args) {
		int []arr={5,7,-24,12,10,2,3,12,5,6,35};
		System.out.println("Minimum Increasing Subsequence Length: "+solver2(arr,arr.length));
	}
}