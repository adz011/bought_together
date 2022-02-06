import java.util.ArrayList;

public class Item {
    private String name;
    private int sells;
    private ArrayList<Link> links;
    private double probability;
    private double range;

    /**
     *
     * @param name indicator of an item
     */
    public Item(String name) {
        this.name = name;
        sells = 0;
        links = new ArrayList<>();
    }

    /**
     *
     * @param item
     */
    public void setNewLink(Item item) {
        Link link = new Link(item);
        links.add(link);
    }

    public void incrementSells() {
        sells++;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public int getSells() {
        return sells;
    }

    public String getName() {
        return name;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public double getProbability() {
        return probability;
    }

    public double getRange() {
        return range;
    }

    public ArrayList<Link> getLinks() {
        return links;
    }

    public void showLinks() {
        System.out.println("This item " + this.name + " is linked to: ");
        for (Link link : links) {
            System.out.println(link.getItem().toString());
        }
    }

    public Link searchForALink(Item item) {
        Link linkRef = null;
        for (Link link : links) {
            if (link.getItem().equals(item)) {
                linkRef = link;
            }
        }

        return linkRef;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", sells=" + sells + links.toString() +
                '}';
    }
}
