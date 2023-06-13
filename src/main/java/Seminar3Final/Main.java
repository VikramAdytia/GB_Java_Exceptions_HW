package Seminar3Final;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.function.DoubleToIntFunction;


public class Main {
    public static void main(String[] args) {

        try {
            makeRecord();
            System.out.println("success");
        }catch (FileSystemException fse){
            System.out.println(fse.getMessage());
        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }

    private static void makeRecord() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");

        String text;
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
            text = bfr.readLine();
        }catch (IOException ioe){
            throw new RuntimeException("Произошла ошибка при работе с консолью");
        }

        String[] array = text.split(" ");
        if (array.length != 6){
            throw new RuntimeException("Введено неверное количество параметров");
        }

        String surname = array[0];
        String name = array[1];
        String patroname = array[2];

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthdate;
        try {
            birthdate = simpleDateFormat.parse(array[3]);
        }catch (ParseException paE) {
            throw new ParseException("Неверный формат даты рождения", paE.getErrorOffset());
        }

        int phone;
        try {
            phone = Integer.parseInt(array[4]);
        }catch (NumberFormatException nufe){
            throw new NumberFormatException("Неверный формат телефона");
        }

        String sex = array[5];
        if (!sex.equalsIgnoreCase("m") && !sex.equalsIgnoreCase("f")  ){
            throw new RuntimeException("Неверно введен пол");
        }

        String fileName = surname.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0 ){
                fileWriter.write("\n");
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", surname, name, patroname, simpleDateFormat.format(birthdate), phone, sex));
        }catch (IOException ioe){
            throw new FileSystemException("Возникла ошибка при работе с файлом");
        }

    }


}
