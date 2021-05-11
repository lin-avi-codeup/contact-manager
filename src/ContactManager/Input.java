package ContactManager;

import java.util.Scanner;

public class Input {

    private static Scanner scn;

    public String getString(String question){
        System.out.println(question);
        scn = new Scanner(System.in);
        return scn.nextLine();
    }

    public int getInt(String question){
        System.out.println(question);
        scn = new Scanner(System.in);
        return scn.nextInt();
    }
}
