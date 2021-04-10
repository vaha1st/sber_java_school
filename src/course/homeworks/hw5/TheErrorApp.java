package course.homeworks.hw5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

// Try to cause all exceptions from pdf/Урок5.Исключения.pdf page 19
public class TheErrorApp {
    public static void main(String[] args) {

        // Checked exceptions

        // FileNotFoundException
        FileReader reader;
        try {
            reader = new FileReader("bla");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // SocketException
        try {
            ServerSocket server = new ServerSocket(12345);
            server.setSoTimeout(1);
            Socket socket = server.accept();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Unchecked exceptions

        // OutOfBounds
        try {
            List list = new ArrayList(Arrays.asList(1,2,3));
            list.get(3);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        // ArrayOutOfBounds
        try {
            int[] array = new int[1];
            array[1] = 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        // StackOverflow
        try {
            overflow();
        } catch (StackOverflowError e) {
            e.printStackTrace();
        }

        // Arithmetic
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }

        // IllegalArgument
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("asdsxczvg");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // NumberFormat
        try {
            String str = "bla";
            int i = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        // OutOfMemoryError
        try {
            String str = "lorem ipsum";
            List<String> list = new LinkedList<>();
            for (int i = 0; i >= 0; i++)
                list.add(str += str);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
    }
    private static void overflow() {
        overflow();
    }
}

