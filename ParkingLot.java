import java.util.PriorityQueue;
/*
Design a Parking Lot
approach: always start from the members of bigger class i.e Parking Lot
 */
public class ParkingLot {
    PriorityQueue<int[]> pq;
    int floors, spotsPerFloor;
    public ParkingLot(int floors, int spotsPerFloor) {
        this.floors = floors;
        this.spotsPerFloor = spotsPerFloor;
        this.pq = new PriorityQueue<>((a,b)-> {
            if (a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
    }

    //time: O(1)
    private void park() {
        if (pq.size()==0) {
            throw new IllegalStateException("parking lot is full");
        }
        pq.poll();
    }

    //time: O(1)
    private void unPark(int floor, int spot) {
        pq.add(new int[]{floor, spot});
    }

    //time: O(1)
    private int[] getAvailableSpot() {
        return pq.peek();
    }

    //time: O(log N)
    private void addParkingSpot(int floor, int spot) {
        if (floor>this.floors) {
            throw new IllegalStateException("floor exceeds available floors");
        }
        if (spot>this.spotsPerFloor) {
            throw new IllegalStateException("spot exceeds spots per floor");
        }
        pq.add(new int[]{floor, spot});
    }
    public static void main(String []args) {
        ParkingLot pl = new ParkingLot(10, 20);
        pl.addParkingSpot(1, 1);
        pl.addParkingSpot(2, 1);
        pl.addParkingSpot(3, 1);
        pl.addParkingSpot(1, 2);
        pl.addParkingSpot(2, 2);
        pl.addParkingSpot(3, 2);
        int[] n = pl.getAvailableSpot();  // 1,1
        System.out.println("Parked at Floor: " + n[0] + ", Slot: " + n[1]);
        pl.park();
         n = pl.getAvailableSpot(); //1,2
        System.out.println("Parked at Floor: " + n[0] + ", Slot: " + n[1]);
        pl.unPark(1, 1);
        n = pl.getAvailableSpot();
        System.out.println("Parked at Floor: " + n[0] + ", Slot: " + n[1]);
    }
}
