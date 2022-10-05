package com.ifsc.secstor.library;

import com.ifsc.secstor.library.facade.EngineMaker;

public class Example {
    public static void main(String[] args) throws Exception {
        int N = 10;
        int K = 5;

        EngineMaker engineMaker = new EngineMaker(N, K);

        //Informação a ser dividida e reconstruída
        String data = "teste";

        //Divisão
        engineMaker.split(data, "pvss");

        //Printando as chaves geradas, lembre-se de utilizar o get na engine que você realizou split
        engineMaker.getPvss().getPieces().forEach(System.out::println);

        //Reconstrução com N chaves
        String reconstructed = engineMaker.reconstruct("pvss");
        System.out.println("\n" + reconstructed);

        //Reconstrução com K chaves ou um número de chaves, onde K <= número de chaves <= N
        reconstructed = engineMaker.reconstruct("pvss", K);
        System.out.println("\n" + reconstructed);
    }
}
