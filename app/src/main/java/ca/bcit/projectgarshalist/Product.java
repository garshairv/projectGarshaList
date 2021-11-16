package ca.bcit.projectgarshalist;

import java.util.ArrayList;

public class Product {
    public static ArrayList<Data> getProduct() {
        ArrayList<Data> product = new ArrayList<>();
        int img = R.drawable.apple;
        String[] productNames = {"Apple 1", "Apple 2", "Apple 3", "Apple 4", "Apple 5"};

        for (int i = 0; i < productNames.length; i++) {
            Data data = new Data();
            data.prodName = productNames[i];
            data.img = img;
            product.add(data);
        }

        return product;
    }
}
