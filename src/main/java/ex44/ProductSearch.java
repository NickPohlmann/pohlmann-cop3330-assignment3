/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex44;

import java.util.Scanner;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class ProductSearch {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProductSearch productSearch = new ProductSearch();

        JSONObject productListJSONObject = productSearch.getJSONFile();
        HashMap<String, Product> productList = productSearch.createHashMap(productListJSONObject);
        System.out.println(productList);
        String productName = productSearch.getProductName();
        //boolean ProductInSystem = productSearch.isProductInSystem(productName, productList);
    }

    private HashMap<String, Product> createHashMap(JSONObject productListJSONObject) {
        HashMap<String, Product> productList = new HashMap<String, Product>();

        for (int i = 0; i < productListJSONObject.size(); i++) {
          //productList.put(productListJSONObject.getString("Name") , productListJSONObject.get(i));
        }
        return productList;
    }

    private JSONObject getJSONFile() {
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            Object obj = jsonParser.parse(new FileReader("/Users/nicholaspohlmann/IdeaProjects/pohlmann-cop3330-assignment3/src/main/resources/exercise44_input.json"));
            jsonObject = (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private boolean isProductInSystem(String productName, JSONObject productList) {
        return true;
    }

    private String getProductName() {
        System.out.print("What is the product name? ");
        String input = in.nextLine();
        return input;
    }
}
