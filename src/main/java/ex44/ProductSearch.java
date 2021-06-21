/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex44;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.Scanner;
import java.io.*;
import java.util.*;


public class ProductSearch {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ProductSearch productSearch = new ProductSearch();

        JsonObject productListJsonObject = productSearch.getJSONFile();
        HashMap<String, Product> productMap = productSearch.createHashMap(productListJsonObject);
        String productName = productSearch.getProductName(productMap);
        String outputString = productSearch.generateOutputString(productMap, productName);
        System.out.println(outputString);
    }

    private String generateOutputString(HashMap<String, Product> productMap, String productName) {
        String outputString = "Name: ";
        outputString += productMap.get(productName).getName();
        outputString += "\n";
        outputString += "Price: ";
        outputString += productMap.get(productName).getPrice();
        outputString += "\n";
        outputString += "Quantity: ";
        outputString += productMap.get(productName).getQuantity();
        return outputString;
    }

    private boolean isProductInSystem(String productName, HashMap<String, Product> productMap) {
        if(productMap.containsKey(productName)) {
            return true;
        } else {
            return false;
        }
    }

    private HashMap<String, Product> createHashMap(JsonObject productListJSONObject) {
        Gson gson = new Gson();
        HashMap<String, Product> productList = new HashMap<String, Product>();
        JsonArray products = productListJSONObject.getAsJsonArray("products");

        for (int i = 0; i < products.size(); i++) {
            Product product = gson.fromJson(products.get(i), Product.class);
            productList.put(product.getName(), product);
        }
        return productList;
    }

    private JsonObject getJSONFile() {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = new JsonObject();
        try {
            Object obj = jsonParser.parse(new FileReader("/Users/nicholaspohlmann/IdeaProjects/pohlmann-cop3330-assignment3/src/main/resources/exercise44_input.json"));
            jsonObject = (JsonObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private String getProductName(HashMap<String, Product> productHashMap) {
        boolean inProductMap = false;
        String productName = "";
        while (!inProductMap) {
            System.out.print("What is the product name? ");
            productName = in.nextLine();
            inProductMap = isProductInSystem(productName, productHashMap);
            if(!inProductMap) {
                System.out.println("Sorry, that product was not found in our inventory.");
            }
        }
        return productName;
    }
}
