package SearchForPoint;

import java.util.List;

public class SequentialSearchForAPoint {
    List<Triplet> triplets;

    public SequentialSearchForAPoint(List<Triplet> triplets) {
        this.triplets = triplets;
    }

    public int search(int x, int y) {
        for (Triplet triplet : triplets) {
            if (triplet.x == x && triplet.y == y) {
                return triplet.value;
            }
        }

        return -1;
    }
}
