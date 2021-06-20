/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Nicholas Pohlmann
 */

package ex43;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.lang.Object;

public class WebsiteGenerator {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        WebsiteGenerator websiteGenerator = new WebsiteGenerator();

        String websiteName = websiteGenerator.getInputNames("Site name: ");
        String authorName = websiteGenerator.getInputNames("Author name: ");
        boolean javaScriptFolder = websiteGenerator.getInputFolder("Do you want a folder for JavaScript (y/n)? ");
        boolean cssFolder = websiteGenerator.getInputFolder("Do you want a folder for CSS (y/n)? ");
        websiteGenerator.createWebsite(websiteName, authorName, javaScriptFolder, cssFolder);
    }

    private void createWebsite(String websiteName, String authorName, boolean javaScriptFolder, boolean cssFolder) throws Exception {
        File file = new File(String.format("%s",websiteName));
        String currentDirectory = System.getProperty("user.dir");
        file.mkdir();

        createHTMLFile(websiteName, authorName);
        System.out.print(javaScriptFolder);
        System.out.print(cssFolder);
        if (javaScriptFolder){
            createFolder(currentDirectory, websiteName, "js");
        }
        if (cssFolder) {
            createFolder(currentDirectory, websiteName, "css");
        }
    }

    private void createFolder(String currentDirectory, String websiteName, String folderName) {
        File js = new File(String.format("%s/%s/%s", currentDirectory,websiteName, folderName));
        js.mkdir();
    }

    private void createHTMLFile(String websiteName, String authorName) throws IOException {
        File file = new File(String.format("%s/index.html",websiteName));
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(String.format("<html><title><h1> %s </h1><meta name=%s content=%s></html>", websiteName, "author", authorName));
        bw.close();
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
