public class WaterArea {

	static int solver(int []arr,int n) {
		int maxLeft=0,maxRight=0;
		int left=0,right=n-1,area=0;

		while(left<right) {
			if(arr[left]<=arr[right]) {
				if(arr[left]>maxLeft) maxLeft=arr[left];
				else area+=maxLeft-arr[left];
				left++;
			}
			else {
				if(arr[right]>maxRight) maxRight=arr[right];
				else area+=maxRight-arr[right];
				right--;
			}
		}
		return area;
	}
	public static void main(String[] args) {
		int []arr={0,8,0,0,5,0,0,10,0,0,1,1,0,3};
		System.out.println(solver(arr,arr.length));
	}
}

//Result: 48