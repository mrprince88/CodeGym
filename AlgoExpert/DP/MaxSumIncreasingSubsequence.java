import java.util.*;
public class MaxSumIncreasingSubsequence {

	static void solver(int []arr,int n) {
		int []sum=new int[n];
		int []seq=new int[n];
		int maxIdx=0;

		for(int i=0;i<n;i++) {
			sum[i]=arr[i];
			seq[i]=-1;
		}

		for(int i=0;i<n;i++) {
			int currNum=arr[i]; 
			for(int j=0;j<i;j++) {
				if(arr[j]<currNum && sum[j]+currNum>=sum[i]) {
					sum[i]=sum[j]+currNum;
					seq[i]=j;
				}
			}
			if(sum[i]>=sum[maxIdx])
				maxIdx=i;
		}

		List<Integer> ans=new ArrayList<>();

		int i=maxIdx;

		while(i!=-1) {
			ans.add(arr[i]);
			i=seq[i];
		}

		System.out.println(ans);
	}

	public static void main(String[] args) {
		int []arr={8,12,2,3,15,5,7};
		solver(arr,arr.length);
	}
}

// Result: [8,12,15]