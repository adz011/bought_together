/**
 *
 * @version 1.0
 * @date 06.02.2022
 */

import java.util.ArrayList;

public class Bought_together {
    ArrayList<Item> items;
    Item boughtItem;
    Item boughtItemByLink;
    private int sells;
    private static final int numberOfOperations = 0;

    public Bought_together() {
        items = new ArrayList<>();
        sells = 0;
    }

    public void calculateProb1stItem() {
        for (int i = 0; i < items.size(); i++) {
            double prob = (double) (items.get(i).getSells() + 1) / (sells + items.size());
            items.get(i).setProbability(prob);
        }
    }

    public void calculateProb2ndItem() {
        if (boughtItem != null) {
            for (Link link : boughtItem.getLinks()) {
                double prob = (double) (link.getSells() + 1) / (boughtItem.getSells() + items.size() - 1);
                link.setProbability(prob);
            }
        } else System.out.println("No item bought in the first phase!");
    }

    /**
     * algorithm to randomly buy a single item depending on items' sells
     */
    public void buy1stItem() {
        calculateProb1stItem();
        double random = Math.random();
        double range = 0;
        for (Item item : items) {
            range += item.getProbability();
            item.setRange(range);
        }
        for (Item item : items) {
            if (item.getRange() > random) {
                boughtItem = item;
                break;
            }
        }
    }

    /**
     * algorithm to randomly buy a item depending on links' sales
     */
    public void buy2ndItem() {
        calculateProb2ndItem();
        double random = Math.random();
        double range = 0;
        for (Link link : boughtItem.getLinks()) {
            range += link.getProbability();
            link.setRange(range);
        }
        for (Link link : boughtItem.getLinks()) {
            if (link.getRange() > random) {
                boughtItem.incrementSells();
                boughtItemByLink = link.getItem();
                boughtItemByLink.incrementSells();
                boughtItemByLink.searchForALink(boughtItem).increment();
                boughtItem.searchForALink(boughtItemByLink).increment();
                sells += 2;
                break;
            }
        }
    }

    public void init() {
        for (int i = 0; i < items.size(); i++) {
            for (int j = 1 + i; j < items.size(); j++) {
                items.get(i).setNewLink(items.get(j));
            }
        }
        int k = 1;
        for (int i = items.size() - 1; i > 0; i--) {
            k++;
            for (int j = items.size() - k; j >= 0; j--) {
                items.get(i).setNewLink(items.get(j));
            }
        }

    }

    public void runAlgorithms() {
        for (int i = 0; i < numberOfOperations; i++) {
            buy1stItem();
            buy2ndItem();
        }
    }

    public void result() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        Bought_together app = new Bought_together();
        app.init();
        app.runAlgorithms();
        app.result();
    }
}
