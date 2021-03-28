package contest;

public class Population {
    public static void main(String[] args) {
        System.out.println(inviteFriend(12));
    }

    private static int inviteFriend(int month) {
        int result = 0;
        if (month > 2) {
            month -= 2;
            for (int i = month; i >= 0; i--) {
                result += inviteFriend(i);
            }
            return result;
        }
        return 1;
    }
}
