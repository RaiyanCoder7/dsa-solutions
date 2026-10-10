class Solution {
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // code here
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr) {
            list.add(num);
        }
        Collections.sort(list, (a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if(freqA != freqB) {
                return freqB - freqA;
            }
            return a - b;
        });
        return list;
    }
}