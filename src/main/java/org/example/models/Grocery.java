package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("0 - Cikis");
            System.out.println("1 - Urun ekle");
            System.out.println("2 - Urun cikar");
            System.out.print("Seciminiz: ");

            if (!scanner.hasNextLine()) {
                break;
            }

            String selection = scanner.nextLine().trim();
            switch (selection) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    System.out.print("Eklemek istediginiz urunleri giriniz: ");
                    addItems(scanner.nextLine());
                    break;
                case "2":
                    System.out.print("Cikarmak istediginiz urunleri giriniz: ");
                    removeItems(scanner.nextLine());
                    break;
                default:
                    System.out.println("Gecersiz secim.");
                    break;
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String normalizedItem = item.trim();
            if (!normalizedItem.isEmpty() && !checkItemIsInList(normalizedItem)) {
                groceryList.add(normalizedItem);
            }
        }

        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String normalizedItem = item.trim();
            if (!normalizedItem.isEmpty() && checkItemIsInList(normalizedItem)) {
                groceryList.remove(normalizedItem);
            }
        }

        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        for (String item : groceryList) {
            System.out.println(item);
        }
    }
}
