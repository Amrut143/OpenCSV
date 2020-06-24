package com.bridgelabz.opencsv;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "./users-with-header.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBeanBuilder csvToBeanBuilder = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class).withIgnoreLeadingWhiteSpace(true);
            CsvToBean csvToBean = csvToBeanBuilder.build();

            Iterator csvUserIterator = csvToBean.iterator();

            while (((Iterator) csvUserIterator).hasNext()) {
                CSVUser csvUser = (CSVUser) csvUserIterator.next();
                System.out.println("Name : " + csvUser.getName());
                System.out.println("Email : " + csvUser.getEmail());
                System.out.println("PhoneNo : " + csvUser.getPhoneNo());
                System.out.println("Country : " + csvUser.getCountry());
                System.out.println("==========================");
            }
        }
    }
}
