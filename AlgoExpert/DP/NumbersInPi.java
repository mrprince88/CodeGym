import java.util.*;

public class NumbersInPi {


	static int solver(String num,Set<String> set,Integer[] dp,int idx) {
		if(idx==num.length())
			return -1;

		if(dp[idx]!=null)
			return dp[idx];

		int res=Integer.MAX_VALUE-1;

		for(int i=idx;i<num.length();i++) {
			String prefix=num.substring(idx,i+1);
			if(set.contains(prefix)) {
				int minSpaceSuffix=solver(num,set,dp,i+1);
				res=Math.min(res,minSpaceSuffix+1);
			}
		}
		return dp[idx]=res;
	}

	public static void main(String[] args) {
		String []arr={"3141","5","31","2","4159","9","42"};
		String num="3141592";
		int n=num.length();
		Integer []dp=new Integer[n];
		Set<String> set=new HashSet<>();

		for(String s:arr)
			set.add(s);


		//Approach 1: Starting from 0th index
		// Time Complexity: O(n^3+m) time | O(n+m)  space.
		//Extra n in time complexity because of immutable string

		int minSpaces=solver(num,set,dp,0);
		minSpaces= minSpaces==Integer.MAX_VALUE-1 ? -1 : minSpaces;
		System.out.println("Minimum Spaces needed: " + minSpaces);


		//Approach 2: Bottom Up
		// Time Complexity: O(n^3+m) time | O(n+m)  space.
		//Extra n in time complexity because of immutable strin

		dp=new Integer[n];

		for(int i=n-1;i>=0;i--)
			solver(num,set,dp,i);

		System.out.println("Minimum Spaces needed: "+ dp[0]);

	}
}
