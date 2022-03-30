import java.util.Scanner;

public class A {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int n=sc.nextInt();
		int []arr=new int[n];

		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		int left=0,right=n-1,res=0,p1=0,p2=0;
		boolean isChance=true;

		while(left<=right) {
			int tmp=0;

			if(arr[right]>arr[left]) {
				boolean isRun=false;
				while(right>0 && arr[right]>arr[left] && tmp+arr[right]>tmp) {
					tmp+=arr[right--];
					isRun=true;
				}

				if(!isRun) {
					tmp+=arr[right--];
				}

			}

			else {
				boolean isRun=false;
				while(left<n-1 && arr[left]>arr[right] && tmp+arr[left]>tmp) {
					tmp+=arr[left++];
					isRun=true;
				}
				if(!isRun) {
					tmp+=arr[left++];
				}
			}

			if(isChance) {
				p1+=tmp;
				isChance=false;
			}
			else {
				p2+=tmp;
				isChance=true;
			}
		}

		System.out.println(Math.abs(p1-p2));
    }

}