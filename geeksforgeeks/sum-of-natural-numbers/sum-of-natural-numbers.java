import java.util.Scanner;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // code here
        System.out.println(findSum(n));
        sc.close();
    }
    
    private static int findSum(int n) {
        if(n <= 0) {
            return 0;
        }
        return n + findSum(n-1);
    }
}