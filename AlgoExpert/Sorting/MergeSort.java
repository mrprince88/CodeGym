class MergeSort {

    static void merge(int []a, int l, int m, int r) {
        if(a[m]<=a[m+1])
            return;
        int n1 = m - l + 1;
        int n2 = r - m;
        int k = l, i = 0, j = 0;
        int []L = new int [n1];
        int []R = new int [n2];
        System.arraycopy(a, l, L, 0, n1);
        System.arraycopy(a, m + 1, R, 0, n2);
        while (i < n1 && j < n2)
            a[k++] = L[i] <= R[j] ? L[i++] : R[j++];
        while (i < n1)
            a[k++] = L[i++];
    }

    static void sort(int []a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String[] args) {

        int []a = {5, 6, 3, 7, 1};
        sort(a, 0, 4);
        for (int i = 0; i < 5; i++)
            System.out.println(a[i]);
    }
}