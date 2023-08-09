class Backtracking01 {
    public static boolean[] visited;
    public static int[] result;

    public static void main(String[] args){
        int arr[] = {1, 2 ,3 ,4};
        int r = 2;
        result = new int[2];
        visited = new boolean[arr.length + 1];
        backtracking(arr, 0, 0, r);
    }

    public static void backtracking(int[] arr, int level, int start, int end){
        if(level == end){
            for(int num : result) System.out.print(num + " ");
            System.out.println();
            return;
        }

        for(int i = 0; i < arr.length; i++){
            if(!visited[i]){
                visited[i] = true;

                result[level] = arr[i];
                backtracking(arr, level + 1, start + 1, end);

                visited[i] = false;
            }
        }
    }
}
