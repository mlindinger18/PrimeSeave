/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erasthotenes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marcel.Lindinger
 */
public class ErasthotenesPrimeSieve implements PrimeSieve {

    private int maxHeight;
    private boolean[] array;

    public ErasthotenesPrimeSieve(int maxHoehe) {
        this.maxHeight = maxHeight;
        array = new boolean[maxHeight];
        for (int i = 0; i < array.length; i++) {
            array[i] = true;

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Geben sie die maximale Höhe ein:");
        int height = Integer.parseInt(sc.nextLine());
        ErasthotenesPrimeSieve eps = new ErasthotenesPrimeSieve(height);
        eps.array[0] = false;
        eps.array[1] = false;
        eps.array[2] = true;
        for (int i = 2; i < eps.array.length; i++) {
            for (int j = 2; j < eps.array.length && eps.array[i] == true && i * j < eps.array.length; j++) {
                eps.array[i * j] = false;
            }
        }

        eps.printPrimes();

        System.out.println("");

        eps.findSum(eps.array);
    }

    @Override
    public boolean isPrime(int p) {
        if (array[p] == true) {
            return true;
        }
        return false;

    }

    @Override
    public void printPrimes() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == true) {
                System.out.print(i + ",");
            }
        }
    }

    public void findSum(boolean[] primesBoolean) {
        ArrayList<Integer> primes = new ArrayList<>();
        ArrayList<String> erg = new ArrayList<>();

        for (int i = 0; i < primesBoolean.length; i++) {
            if (primesBoolean[i] == true) {
                primes.add(i);
            }
        }

        boolean b = true;
        for (int i = 2; i < primesBoolean.length; i += 2) {
            b = true;
            for (int j = 0; j < primes.size() && b == true; j++) {

                for (int k = 0; k < primes.size() && b == true; k++) {
                    if (i == primes.get(j) + primes.get(k)) {
                        b = false;
                        int ergebnis = primes.get(j) + primes.get(k);
                        erg.add(ergebnis + " summe: " + ergebnis + " = " + primes.get(j) + " + " + primes.get(k));
                    }
                }
            }
        }
        for (int i = 0; i < erg.size(); i++) {
            System.out.println(erg.get(i));

        }
    }

}
