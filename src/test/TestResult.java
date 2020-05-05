package test;

import domain.*;
import java.util.Scanner;

public class TestResult {

    public static void main(String[] args) {
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        //System.out.println("String read from console is : \n"+inputString);
        System.out.println("Encoded message : " + Exercise.Calculate(inputString));
    }
}
