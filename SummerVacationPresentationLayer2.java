
import java.io.Console;
import java.util.List;
import java.util.Scanner;

public class SummerVacationPresentationLayer2 extends SummerVacationDALTest
{
    private static Scanner activityScanner;
    public static Scanner getActivityScanner() {
        return activityScanner;
    }
    public static void setActivityScanner(Scanner activityScanner) {
        SummerVacationPresentationLayer2.activityScanner = activityScanner;
    }
    private static SummerVacationDAL GetDAL(SummerVacationDAL2 summerVacationDAL2)
    {
        @SuppressWarnings("resource")
        Scanner CredentialScanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        // String input
        String userName = CredentialScanner.nextLine();

        System.out.print("Enter password: ");
        Console console = System.console();
        char[] password = console.readPassword();
        return new SummerVacationDAL("Vacation", userName, new String(password));
    }
    public static void main(String[] args)
    {
        SummerVacationDAL dal = GetDAL(new SummerVacationDAL2(null, null, null));
        System.out.println("Welcome to your summer vacation planner! Please enter an activity name to see potential vacation options!");
        @SuppressWarnings("resource")
        Scanner activityScanner = new Scanner(System.in);
        String activityName = activityScanner.nextLine();
        List<String> parks = dal.TryGetDestinationForActivity(activityName);
        for(int i = 0; i < parks.size(); i++)
        {
            System.out.println(parks.get(i));
        }
    }
}
