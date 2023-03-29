import java.util.Hashtable;

public class Library extends Building {
    private Hashtable<String, Boolean> collection = new Hashtable<>();

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
    }

    public void addTitle(String title) {
        if (collection.containsKey(title)) {
            throw new RuntimeException("Book already exists in inventory.");
        }
        collection.put(title, true);
    }
    
    public String removeTitle(String title) {
        if (!collection.containsKey(title)) {
            throw new RuntimeException("Book not found in inventory.");
        }
        collection.remove(title);
        return title;
    }

    public void checkOut(String title) {
      if (collection.containsKey(title) && collection.get(title)) {
          collection.put(title, false);
      }
  }  

    public void returnBook(String title) {
        collection.put(title, true);
    }

    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    public boolean isAvailable(String title) {
        return collection.containsKey(title) && collection.get(title);
    }

    public void printCollection() {
        System.out.println("Library Collection:");
        for (String title : collection.keySet()) {
            System.out.println(title + " - " + (collection.get(title) ? "Available" : "Checked out"));
        }
    }

}
