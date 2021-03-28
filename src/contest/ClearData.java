package contest;

import java.util.*;

public class ClearData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> conf = convertStrArrayToList(scanner.nextLine().strip().split(" "));
        ArrayList<Long> sample = convertStrArrayToList(scanner.nextLine().strip().split(" "));

        double disp = calculateDisp(sample);

        if (disp > conf.get(2)) {
            for (int i = 0; i < conf.get(1) / 2; i++) {
                sample.remove(Collections.max(sample));
                sample.remove(Collections.min(sample));
            }
        }

        printArrayList(sample);

    }

    private static void printArrayList(ArrayList<Long> list) {
        ListIterator litr = list.listIterator();
        while (litr.hasNext()) {
            System.out.print(litr.next());
            if (litr.hasNext()) {
                System.out.print(" ");
            }
        }
    }

    private static double calculateDisp(ArrayList<Long> sample) {
        int n = sample.size();
        long sum = 0;
        double avg;
        double disp = 0;

        for (long num : sample) {
            sum += num;
        }
        avg = sum / sample.size();
        for (int i = 0; i <= n - 1; i++) {
            disp += Math.pow(sample.get(i) - avg, 2);
        }
        disp /= n - 1;
        return (disp);
    }

    private static ArrayList<Long> convertStrArrayToList(String[] array) {
        ArrayList<Long> list = new ArrayList<>();
        for (String str : array) {
            list.add(Long.parseLong(str));
        }
        return list;
    }
}
