package course.homeworks.hw6;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

    private static final String file = "course/homeworks/hw6/log.log";

    public static void main(String[] args) {
        List <LogElement> list = null;
        try(BufferedReader reader = new BufferedReader(
                new FileReader(file))) {
            list = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(parseString(line));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Cannot open the " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            for (LogElement element : list) {
                System.out.println(element);
            }
        }
    }

    private static LogElement parseString(String str) {
        LogElement element = null;
        String[] words = str.split("\\t");
        try {
            if (words.length >= 5) {
                int i = 0;
                element = new LogElement();
                element.setIp(words[i++]);
                element.setUser(words[i++]);
                element.setDate(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(words[i++]));
                Event event = Event.valueOf(words[i++]);
                element.setEvent(event);
                if (words.length == 6)
                    element.setEventNum(Integer.parseInt(words[i++]));
                Status status = Status.valueOf(words[i]);
                element.setStatus(status);
            }
        } catch (IllegalArgumentException | ParseException e) {
            e.printStackTrace();
        }

        return element;
    }
}
