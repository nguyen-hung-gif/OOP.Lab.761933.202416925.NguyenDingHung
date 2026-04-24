package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;

    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered = 0;
    private int totalCost;

    // Thêm DVD vào giỏ
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
                this.itemsOrdered[qtyOrdered] = disc;
                qtyOrdered++;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
            } else {
                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
                break;
            }
        }
    }
//    
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc disc : dvds) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                this.itemsOrdered[qtyOrdered] = disc;
//                qtyOrdered++;
//                System.out.println("The disc \"" + disc.getTitle() + "\" has been added.");
//            } else {
//                System.out.println("The cart is almost full. Cannot add: " + disc.getTitle());
//                break;
//            }
//        }
//    }
    
 // 2.2. Overloading
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1); 
        addDigitalVideoDisc(dvd2);
    }

    // Xóa DVD khỏi giỏ
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;

        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;

                // Dịch mảng sang trái
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;

                System.out.println("The disc has been removed");
                break;
            }
        }

        if (!found) {
            System.out.println("The disc was not found in the cart");
        }
    }

    // Tính tổng tiền
    public float totalCost() {
        float sum = 0;

        for (int i = 0; i < qtyOrdered; i++) {
            sum += itemsOrdered[i].getCost();
        }

        return sum;
    }

    public void print() {
    	totalCost = 0;
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		System.out.println(itemsOrdered[i].toString());
    		totalCost += itemsOrdered[i].getCost();
    	}
    	System.out.println("Total Cost: " + totalCost);
    	System.out.println("***************************************************");
    }
    
    public void searchByID(int targetID) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].getid() == targetID) {
    			System.out.println("DVD Found:");
    			System.out.println(itemsOrdered[i].toString());
    			return;
    		}
    	}
    	System.out.println("No DVD with ID " + targetID + " found!");
    }
    
    public void searchByTitle(String targetTitle) {
    	for (int i = 0; i < qtyOrdered; i++) {
    		if (itemsOrdered[i].isMatch(targetTitle)) {
    			System.out.println("DVD Found:");
    			System.out.println(itemsOrdered[i].toString());
    			return;
    		}
    	}
    	System.out.println("No DVD with title \"" + targetTitle + "\" found!");
    }
}
