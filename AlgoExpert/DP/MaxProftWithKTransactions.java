// one transaction is buying and selling stock combined.
// Transactions can be atmost k

public class MaxProftWithKTransactions {
	public static void main(String[] args) {
		int []prices={5,11,3,50,60,90};
		int k=2,days=prices.length;
		int [][]profit=new int[k+1][days];

		for(int i=1;i<=k;i++) {
			int maxSoFar=Integer.MIN_VALUE;
			for(int j=1;j<days;j++) {
				maxSoFar=Math.max(maxSoFar,profit[i-1][j-1]-prices[j-1]);
				profit[i][j]=Math.max(profit[i][j-1],prices[j]+maxSoFar);
			}
		}

		System.out.println("Max Proft With K Transactions: "+profit[k][days-1]);
	}
}