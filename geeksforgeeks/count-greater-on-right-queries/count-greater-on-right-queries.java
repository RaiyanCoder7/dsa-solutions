class Solution {
    int[] countGreater(int arr[], int indices[]) {
        int n = arr.length;
        int queries = indices.length;
        int[] ans = new int[queries];

        for (int q = 0; q < queries; q++) {
            int idx = indices[q];
            int target = arr[idx];
            int count = 0;

            // Scan strictly to the right of idx
            for (int j = idx + 1; j < n; j++) {
                if (arr[j] > target) {
                    count++;
                }
            }

            ans[q] = count;
        }

        return ans;
    }
}
