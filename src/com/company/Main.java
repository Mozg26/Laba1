package com.company;
import java.util.Scanner;

/**
 * Main class
 */
public class Main {

    /**
     * A method with a user interface.
     * @return The number of the action selected by the user.
     */
    public static int interface_() {
        int num;
        Scanner in = new Scanner(System.in);

        System.out.println("Choose:");
        System.out.println("1.Add from left");
        System.out.println("2.Add from right");
        System.out.println("3.Delete");
        System.out.println("4.Search for");
        System.out.println("5.Exit");

        for (num = in.nextInt(); num <= 0 || num > 5; num = in.nextInt()) {
            System.out.println("Error, try again");
        }
        return num;
    }

    /**
     * Main method
     * @param args main arguments
     */
    public static void main(String[] args) {

        System.out.println("Enter number of elements:");
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        System.out.println("Enter " + N + " elements:");
        int num = in.nextInt();
        Set<Integer> Obj = new Set<>(num);

        for (int i = 1; i < N; i++) {
            num = in.nextInt();
            Obj.addition_tail(num);
        }

        System.out.println(Obj);
        num = interface_();

        do {

            if (num == 1) {
                System.out.println("Enter insertable:");
                num = in.nextInt();
                Obj.addition_head(num);
                System.out.println("New list:");
                System.out.println(Obj);

            } else if (num == 2) {
                System.out.println("Enter insertable:");
                num = in.nextInt();
                Obj.addition_tail(num);
                System.out.println("New list:");
                System.out.println(Obj);

            } else if (num == 3) {
                System.out.println("Enter deletable:");
                num = in.nextInt();

                if (Obj.search(num)) {
                    Obj.delete_elem(num);
                    System.out.println("New list:");
                    System.out.println(Obj);

                } else {
                    System.out.println("Elem not found!");
                }

            } else {
                System.out.println("Enter searchable:");
                num = in.nextInt();

                if (Obj.search(num)) {
                    System.out.println("Elem found!");

                } else {
                    System.out.println("Elem not found!");
                }
            }

            num = interface_();
        } while (num != 5);
    }
}
