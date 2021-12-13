package br.com.curso.spring.data.classe;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {

    public static LocalDate getDataBanco(String pDataGUI) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(pDataGUI, formatter);
    }

    public static String getDataGUI(LocalDate pDataBanco) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return pDataBanco.format(formatter);
    }
}
