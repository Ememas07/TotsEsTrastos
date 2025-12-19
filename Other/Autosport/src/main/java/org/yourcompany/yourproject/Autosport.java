/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-test.txt to change this license
 */
package org.yourcompany.yourproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marc Mas
 */
public class Autosport {

    public static void main(String[] args) throws IOException {
        findDriver(1);
    }

    public static void findDriver(int driver) {
        try (Scanner s = new Scanner(new BufferedReader(new FileReader("input.txt")))) {
            while (s.hasNextInt()) {
                int n = 0;
                if (s.hasNextInt()) {
                    n = s.nextInt();
                }
                String d1 = "";
                if (s.hasNext()) {
                    d1 = s.next();
                }
                String d2 = " ";
                if (s.hasNext()) {
                    d2 += s.next();
                }
                if (driver == n) {
                    System.out.println(d1 + d2);
                    findDriver(driver + 1);
                }
            }
        } catch (FileNotFoundException ex) {
            System.getLogger(Autosport.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }
}
