/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erasthotenes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcel.Lindinger
 */
public class ErasthotenesPrimeSieve implements PrimeSieve {

    public int number;
    public int og;

    public ErasthotenesPrimeSieve(int number, int og) {
        this.number = number;
        this.og = og;
    }

    @Override
    public boolean isPrime(int og) {

        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < og; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;

    }

    public void PrimesAdd(int o) {
        ErasthotenesPrimeSieve eps = new ErasthotenesPrimeSieve(number, og);
        int n = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < o; i++) {
            if (eps.isPrime(i) == true) {
                x = i;
            }

            for (int j = 10; j <= o; j--) {
                if (eps.isPrime(j) == true) {
                    y = j;
                }
                n = x + y;
                if (n % 2 == 0) {
                    System.out.println(n + "= " + x + "+ " + y);
                }
            }

        }

    }

    @Override
    public void printPrimes() {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < og; i++) {
            if (ErasthotenesPrimeSieve.this.isPrime(i) == true) {
                primes.add(i);
            }

        }
        System.out.println(primes);
    }

}
