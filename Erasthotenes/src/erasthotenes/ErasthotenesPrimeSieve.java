/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package erasthotenes;

/**
 *
 * @author Marcel.Lindinger
 */
public class ErasthotenesPrimeSieve implements PrimeSieve {

    public ErasthotenesPrimeSieve() {

    }

    @Override
    public boolean isPrime(int p) {
        boolean prime[] = new boolean[p + 1];
        for (int i = 0; i <= p; i++) {
            prime[i] = true;
        }
        for (int n = 2; n * n <= p; n++) {
            if (prime[p] == true) {

            }
            for (int i = p * p; i <= n; i += p) {
                prime[i] = false;
            }
        }
        return false;
    }

    @Override
    public void printPrimes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
