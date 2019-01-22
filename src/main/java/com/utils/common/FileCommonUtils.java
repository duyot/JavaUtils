package com.utils.common;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileCommonUtils {
    private static Logger log = LoggerFactory.getLogger(FileCommonUtils.class);

    public static void main(String[] args) {
        //FileCommonUtils.deleteFile("D:\\province_id1.csv");
        FileCommonUtils.moveAndDeleteFile("D:\\province_id.csv", "D:\\logs\\province_id1.csv");
    }

    private static void processFileByLine(String path){
        File file = new File(path);
        try (LineIterator it = FileUtils.lineIterator(file, "UTF-8")){
            while (it.hasNext()) {
                String line = it.nextLine();
                log.info(line);
            }
        } catch (IOException e) {
            log.error(e.toString());
        }
    }

    public static void deleteFile(String filePath) {
        try {
            File file = new File(filePath);
            FileUtils.forceDelete(file);
            log.info("Del file: " + filePath + " successfully");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public static void moveAndDeleteFile(String source, String des) {
        try {
            File sourceFile = new File(source);
            File desFile = new File(des);
            FileUtils.copyFile(sourceFile, desFile);
            FileUtils.forceDelete(sourceFile);
            log.info("Move file: " + source + " to " + des + " successfully");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    public static List<String> readFileByLine(String filePath) {
        try {
            return IOUtils.readLines(new FileInputStream(filePath), "UTF-8");
        } catch (IOException e) {
            log.error("File " + filePath + " not found: " + e.toString());
            return new ArrayList<>();
        }
    }

    public static List<String> readFileByLineUsingFile(String filePath) {
        try {
            File file = new File(filePath);
            return FileUtils.readLines(file, "UTF-8");
        } catch (IOException e) {
            log.error("File " + filePath + " not found: " + e.toString());
            return new ArrayList<>();
        }
    }


    public static void readFromURL(String url) {
        try (InputStream in = new URL(url).openStream()) {
            System.out.println(IOUtils.toString(in));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
