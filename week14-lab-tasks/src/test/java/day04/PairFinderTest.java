package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PairFinderTest {

    @Test
    void testCountPairs() {
        assertEquals(0, PairFinder.findPairs(new int[]{4, 2, 1, 6, 8}));
        assertEquals(1, PairFinder.findPairs(new int[]{4, 2, 4, 6}));
        assertEquals(4, PairFinder.findPairs(new int[]{1, 3, 3, 5, 3, 3, 5, 8, 5, 8}));
    }

    @Test
    void testCountPairsB() {
        assertEquals(0, PairFinder.findPairsB(new int[]{4, 2, 1, 6, 8}));
        assertEquals(1, PairFinder.findPairsB(new int[]{4, 2, 4, 6}));
        assertEquals(4, PairFinder.findPairsB(new int[]{1, 3, 3, 5, 3, 3, 5, 8, 5, 8}));
    }
}