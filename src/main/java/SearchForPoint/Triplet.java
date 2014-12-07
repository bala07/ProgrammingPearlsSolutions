package SearchForPoint;

public class Triplet implements Comparable<Triplet> {
   int x, y, value;

   public Triplet(int x, int y, int value) {
       this.x = x;
       this.y = y;
       this.value = value;
   }

   @Override
   public int compareTo(Triplet triplet) {
       if (this.y != triplet.y) {
           return this.y - triplet.y;
       }

       return this.x - triplet.x;
   }
}
