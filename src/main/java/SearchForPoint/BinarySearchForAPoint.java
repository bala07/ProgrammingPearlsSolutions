package SearchForPoint;

import java.util.Collections;
import java.util.List;

public class BinarySearchForAPoint {
    List<Triplet> triplets;

    public BinarySearchForAPoint(List<Triplet> triplets) {
        this.triplets = triplets;
        Collections.sort(triplets);
    }

    public int search(int x, int y) {
        int leftEnd = getLeftEndForY(y);
        int rightEnd = getRightEndForY(y);
        return (leftEnd == -1 || rightEnd == -1) ? -1 : binarySearchForX(leftEnd, rightEnd, x);
    }

    private int binarySearchForX(int low, int high, int x) {
        while(low <= high) {
            int mid = (low + high)/2;
            Triplet point = triplets.get(mid);
            if(x == point.x) {
                return point.value;
            }
            else if(x < point.x) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private int getLeftEndForY(int y) {
        int low = 0, high = triplets.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Triplet point = triplets.get(mid);
            if (y < point.y) {
                high = mid - 1;
            } else if (y > point.y) {
                low = mid + 1;
            } else {
                if (mid == low || y > triplets.get(mid - 1).y) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    private int getRightEndForY(int y) {
        int low = 0, high = triplets.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Triplet point = triplets.get(mid);
            if (y < point.y) {
                high = mid - 1;
            } else if (y > point.y) {
                low = mid + 1;
            } else {
                if (mid == high || y < triplets.get(mid + 1).y) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }

}
