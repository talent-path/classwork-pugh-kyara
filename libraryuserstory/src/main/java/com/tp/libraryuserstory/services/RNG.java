package com.tp.libraryuserstory.services;

import java.util.Random;

public class RNG {
    static Random rng = new Random();

    public static int randomIndex( int maxIndexInc ){

        return rng.nextInt(maxIndexInc + 1);
    }
}
