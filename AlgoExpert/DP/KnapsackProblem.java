import java.util.*;

public class KnapsackProblem {

	static int solver(int [][]arr,int n,int maxCapacity) {
		int [][]dp=new int[n+1][maxCapacity+1];

		for(int i=1;i<=n;i++) {
			int currValue=arr[i-1][0],currWeight=arr[i-1][1];

			for(int j=0;j<=maxCapacity;j++) {
				if(currWeight>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-currWeight]+currValue);
			}

		}
		System.out.println("Sequence: " +getKnapsackValues(dp,arr));
		return dp[n][maxCapacity];
	}

	static List<Integer> getKnapsackValues(int [][]dp,int [][]arr) {
		List<Integer> sequence=new ArrayList<>();
		int i=dp.length-1,j=dp[0].length-1;

		while(i>0 && j>0) {
			if(dp[i][j]==dp[i-1][j])
				i--;
			else {
				sequence.add(i-1);
				j-=arr[i-1][1];
				i--;
			}
		}
		Collections.reverse(sequence);
		return sequence;
	}

	public static void main(String[] args) {
		// 1st value represent the value and 2nd value represent weight of the item
		int [][]arr={{1,2},{4,3},{5,6},{6,7}};
		int maxCapacity=10;

		//number of items without exceeding maxCapacity having max value
		System.out.println("Knapsack Value: "+solver(arr,arr.length,maxCapacity));
	}
}