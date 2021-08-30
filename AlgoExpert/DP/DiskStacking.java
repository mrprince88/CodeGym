import java.util.*;
import java.util.stream.Collectors;

public class DiskStacking {

	static int solver(int [][]arr,int n) {
		int []dp=new int[n];
		int []seq=new int[n];
		int maxIdx=0;
		Arrays.sort(arr,(a,b)->(a[2]-b[2]));

		for(int i=0;i<n;i++) {
			dp[i]=arr[i][2];
			seq[i]=-1;
		}

		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i][0]>arr[j][0] && arr[i][1]>arr[j][1] && arr[i][2]>arr[j][2]) {
					if(dp[i]<=arr[i][2]+dp[j]) {
						dp[i]=arr[i][2]+dp[j];
						seq[i]=j;
					}
				}
			}
			if(dp[i]>dp[maxIdx])
				maxIdx=i;
		}

		int i=maxIdx;
		List<List<Integer>> res=new ArrayList<>();

		while(i!=-1) {
			res.add(Arrays.stream(arr[i]).boxed().collect(Collectors.toList()));
			i=seq[i];
		}

		System.out.println("Max Stack Sequence: "+ res);

		return dp[maxIdx];
	}
	public static void main(String[] args) {
		//{width,depth,height}
		int [][]arr={{2,2,1},{2,1,2},{3,2,3},{2,3,4},{4,4,5},{2,2,3}};
		System.out.println("Max height: "+ solver(arr,arr.length));
	}
}