class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        solve(n, "", result);
        return result;
    }
    private void solve(int n, String current, List<String> result) {
        if(current.length() == n) {
            result.add(current);
            return;
        }
        solve(n, current + "1", result);
        if(current.isEmpty() || current.charAt(current.length()-1) == '1') {
            solve(n, current + '0', result);
        }
    }
}