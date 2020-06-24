package com.bridgelabz.opencsv;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "./Object-List-Sample.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "./user.json";

    public static void main(String[] args) {
        System.out.println(SAMPLE_CSV_FILE_PATH);
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CSVUser> csvUserCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvUserCsvToBeanBuilder.withType(CSVUser.class);
            csvUserCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvUserCsvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson= new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] userObj = gson.fromJson(br, CSVUser[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

