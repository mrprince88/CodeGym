class MoveElementToEnd {

	public static void main(String[] args) {
		int n = 5;
		int toMove = 2;
		int []arr = {2, 2, 3, 3, 4};
		int i = 0, j = n - 1;
		while (i < j) {
			while (i < j && arr[j] == toMove)
				j--;
			if (arr[i] == toMove) {  //swap arr[i] & arr[j]
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
			}
			i++;
		}
		for (i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}