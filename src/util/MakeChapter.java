package util;

import java.io.File;
import java.io.IOException;

public class MakeChapter {
    private static final String CHAPTER = "Hash";
    private static final int N = 5;
    private static final String root = System.getProperty("user.dir");
    private static final String path = "\\src";

    public static void main(String[] args) {
        for(int i = 1; i <= N; i++){
            String filePath = String.format(root + path + "\\%s%02d.java", CHAPTER, i);
            File file = new File(filePath);
            try{
                if(file.createNewFile()){
                    System.out.println(String.format("File created : %s%02d.java", CHAPTER, i));
                } else {
                    System.out.println("File already exists");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
