package hk.edu.polyu.comp3222.vfs;

import java.util.HashMap;

/**
 * Created by Isaac on 1/24/17.
 */
public class Main {
    /**
     * Default main class
     */
    public static void main(String[] args){
        HashMap responseHandler = new HashMap();
        static {
            responseHandler.put("I", 1);
            responseHandler.put("IV", 4);
            responseHandler.put("V", 5);
            responseHandler.put("IX", 9);
            responseHandler.put("X", 10);
            responseHandler.put("XL", 40);
        }
        System.out.println("I love Coding");
    }
}
