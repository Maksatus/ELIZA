package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

// маленький регистр, лишние пробелы убирать
public class Main {

    public static final String PATH_TO_DATA = "C:\\Users\\elise\\IdeaProjects\\chat\\src\\com\\company\\askWords";
    public static final String PATH_TO_ANSWERS = "C:\\Users\\elise\\IdeaProjects\\chat\\src\\com\\company\\baseWords";


    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream_A = null;
        Properties prop = new Properties();
        Properties prop_a = new Properties();
        ArrayList<String> question = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();

        try {
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream(PATH_TO_DATA);
            prop.load(fileInputStream);

            fileInputStream_A = new FileInputStream(PATH_TO_ANSWERS);
            prop_a.load(fileInputStream_A);

            Scanner in = new Scanner(System.in);
            System.out.print("Input a word: ");
            // то что нужно разделить
            String s = in.nextLine();
            for (String shared : s.split(" ")){
                question.add(prop.getProperty(shared,"null"));
            }

            for (int i = 0; i < question.size(); i++) {
                answer.add(prop_a.getProperty(question.get(i)));
            }

            System.out.println(answer);

        } catch (IOException e) {
            System.out.println("Ошибка в программе: файл не обнаружен");
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (fileInputStream_A != null) {
                    try {
                        fileInputStream_A.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}