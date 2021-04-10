package course.exceptions.bestPractice;

import java.io.*;

/**
 * Best practice 11
 * Помните о принципе "throw early catch late"
 *
 */
public class Practice11 {
    public static void main(String[] args) {
        // Пример Throw early

        File propFile = new File("");
//        try{
////            readFile(propFile);
//            readFileRight(propFile);
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }


        // Пример Catch late

//        readFileAndCatch(propFile);  // Нежелательно так делать

        // Так лучше
        try{
            readFileRight(propFile);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // ======================= Throw early =========================

    // Важно выбросить исключение как можно быстрее после обнаружения ошибки.
    // Здесь исключение не дает нужной информации об истинной причине.
    private static void readFile(File filename) throws FileNotFoundException {
        InputStream in = new FileInputStream(filename);
    }

    // Здесь перед открытием файла может быть выброшено исключение
    // после проверки аргумента (имени файла), не дожидаясь
    // создания объекта для работы с этим файлом.
    // То есть в стектрейсе можно будет увидеть конкретную информацию
    // об ошибке, вместо общей.
    private static void readFileRight(File fileName)
            throws FileNotFoundException, IllegalArgumentException
    {
        if(fileName == null || fileName.getPath().equals("")){
            throw new IllegalArgumentException("File Name not given");
        }
        InputStream in = new FileInputStream(fileName);
    }


    // ======================= Catch late =========================
    // Не торопитесь перехватывать исключения. Лучше выбросить их из
    // метода и обработать выше по стеку вызовов, где может быть
    // доступна дополнительная информация о проблеме.
    private static void readFileAndCatch(File fileName) {
        InputStream in = null;
        try {
            in = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
