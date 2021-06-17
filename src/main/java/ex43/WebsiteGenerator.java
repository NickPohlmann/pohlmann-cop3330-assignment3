/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex43;

import java.util.Scanner;
import java.io.File;
import java.lang.Object;

public class WebsiteGenerator {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();

        String websiteName = websiteGenerator.getInputNames("Site name: ");
        String authorName = websiteGenerator.getInputNames("Author name: ");
        boolean javaScriptFolder = websiteGenerator.getInputFolder("Do you want a folder for JavaScript (y/n)? ");
        boolean cssFolder = websiteGenerator.getInputFolder("Do you want a folder for CSS (y/n)? ");

    }


    private boolean getInputFolder(String str) {
        System.out.print(str);
        String input = in.nextLine();
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    private String getInputNames(String str) {
        System.out.print(str);
        String input = in.nextLine();
        return input;
    }

}
