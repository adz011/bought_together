public class Link {
    private Item item;
    private int sells;
    private double probability;
    private double range;

    public Link(Item item){
        this.item = item;
        sells = 0;
    }

    public void increment() {
        this.sells ++;
    }

    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    public Item getItem() {
        return item;
    }

    public int getSells(){
        return sells;
    }

    @Override
    public String toString() {
        return "Link{" +
                "item=" + item.getName() +
                ", sells=" + sells +
                '}';
    }
}
