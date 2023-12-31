package study;

class Permutations{
    public static boolean[] visited;
    public static int[] result;
    public static void main(String[] args){
        int[] arr = new int[]{1, 2, 3, 4};
        int r = 2;
        visited = new boolean[arr.length];
        result = new int[r];
        backtracking(arr, 0, 2);
    }

    public static void backtracking(int[] arr, int level, int end){
        if(level == end){
            for(int a: result){
                System.out.print(a  + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;

                result[level] = arr[i];
                backtracking(arr, level + 1, end);

                visited[i] = false;
            }
        }
    }

}
