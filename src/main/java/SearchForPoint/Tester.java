package SearchForPoint;

import HelperClasses.GeneralHelpers;

import java.util.ArrayList;
import java.util.List;

public class Tester {

    private final int MAX_VAL = 2000;
    private final int MAX_LEN = 10000;

    public static void main(String[] args) {
        new Tester().test();
    }

    public void test() {
        int arrayLen = (int) (Math.random() * MAX_LEN);
        int[] xValues = GeneralHelpers.generateArray(arrayLen, MAX_VAL);
        int[] yValues = GeneralHelpers.generateArray(arrayLen, MAX_VAL);
        int[] pointValues = GeneralHelpers.generateArray(arrayLen, MAX_VAL);

        List<Triplet> triplets = getTriplets(arrayLen, xValues, yValues, pointValues);

        BinarySearchForAPoint binarySearchForAPoint = new BinarySearchForAPoint(triplets);
        SequentialSearchForAPoint sequentialSearchForAPoint = new SequentialSearchForAPoint(triplets);

        int randomXValue = (int) (Math.random() * MAX_VAL);
        int randomYValue = (int) (Math.random() * MAX_VAL);

        int binarySearchValue = binarySearchForAPoint.search(randomXValue, randomYValue);
        int sequentialSearchValue = sequentialSearchForAPoint.search(randomXValue, randomYValue);

        System.out.println("binarySearchValue = " + binarySearchValue);
        System.out.println("sequentialSearchValue = " + sequentialSearchValue);

        assert (binarySearchValue == sequentialSearchValue);

        int randomIdxInTriplets = (int) (Math.random() * arrayLen);
        binarySearchValue = binarySearchForAPoint.search(triplets.get(randomIdxInTriplets).x, triplets.get(randomIdxInTriplets).y);
        sequentialSearchValue = sequentialSearchForAPoint.search(triplets.get(randomIdxInTriplets).x, triplets.get(randomIdxInTriplets).y);

        System.out.println("binarySearchValue = " + binarySearchValue);
        System.out.println("sequentialSearchValue = " + sequentialSearchValue);

        assert (binarySearchValue == sequentialSearchValue);

    }

    private List<Triplet> getTriplets(int arrayLen, int[] xValues, int[] yValues, int[] pointValues) {
        List<Triplet> triplets = new ArrayList<>();
        for (int idx = 0; idx < arrayLen; ++idx) {
            triplets.add(new Triplet(xValues[idx], yValues[idx], pointValues[idx]));
        }

        return triplets;
    }
}
