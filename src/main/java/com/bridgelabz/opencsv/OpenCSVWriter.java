package com.bridgelabz.opencsv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {

    private static final String OBJECT_WRITE_FILE_PATH = "./Object-List-Sample.csv";

    public static void main(String[] args) throws IOException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(OBJECT_WRITE_FILE_PATH));
        ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<CSVUser> csvUsers = new ArrayList<>();
            csvUsers.add(new CSVUser("Amrut","amrutpanda@gmail.com","9987454321","India"));
            csvUsers.add(new CSVUser("Amrut","amrutpanda@gmail.com","9678554321","India"));
            csvUsers.add(new CSVUser("Deepak","deepak7789@gmail.com","9995074321","India"));
            csvUsers.add(new CSVUser("Deepak","deepak7789@gmail.com","9123454321","India"));
            beanToCsv.write(csvUsers);
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }

    }
}
