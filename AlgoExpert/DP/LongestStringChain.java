import java.util.*;

public class LongestStringChain {

	/*
	String chain are formed by strings which become equal on removing atmost character
	from a string
	Eg - ae,abe,abde form a chain of length 3
	*/

	static int solver(String []arr,int n) {
		Map<String,Integer> map=new HashMap<>();

		Arrays.sort(arr,(a,b)->a.length()-b.length());

		int max=Integer.MIN_VALUE;

		for(int i=0;i<n;i++) {
			int count=1,len=arr[i].length();
			for(int j=0;j<len;j++) {
				String newStr=arr[i].substring(0,j)+arr[i].substring(j+1,len);
				if(map.containsKey(newStr))
					count=Math.max(count,map.get(newStr)+1);
			}
			max=Math.max(max,count);
			map.put(arr[i],count);
		}
		return max;
	}

	public static void main(String[] args) {
		String []arr={"abde","abc","abd","abcde","ade","ae","labde","abcdef"};
		System.out.println("Longest chain length: "+solver(arr,arr.length));
	}
}