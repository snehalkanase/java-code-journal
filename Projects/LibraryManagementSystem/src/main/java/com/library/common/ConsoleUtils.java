package com.library.common;

import java.util.Scanner;

public class ConsoleUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String msg){
        System.out.print(msg);
        return scanner.nextLine().trim();
    }
    public static int readInt(String msg){
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine().trim());
    }
}
