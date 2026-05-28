package ATOZsheet.GreedyAlgo;

import java.util.Arrays;

public class fractionalKnapsack {
    static class Item {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {

        int n = val.length;

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            items[i] = new Item(val[i], wt[i]);
        }

        // sort by ratio descending
        Arrays.sort(items, (a, b) ->
                Double.compare(b.ratio, a.ratio)
        );

        double totalValue = 0.0;

        for (Item item : items) {

            // take whole item
            if (capacity >= item.weight) {

                totalValue += item.value;
                capacity -= item.weight;

            } else {

                // take fraction
                totalValue += item.ratio * capacity;
                break;
            }
        }

        return Math.round(totalValue * 1_000_000.0) / 1_000_000.0;
    }
}
