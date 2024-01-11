
public class Calendar {
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 1; // 1.1.1900 was a Monday (0=Sunday, 1=Monday, ...)
    static int nDaysInMonth = 31; // Number of days in January

    public static void main(String args[]) {
        int givenYear = Integer.parseInt(args[0]);

        // Only process years greater than 1900
        if (givenYear <= 1900) {
            System.out.println("Year must be greater than 1900.");
            return;
        }

        while (year <= givenYear) {
            String dayString = dayOfMonth + "/" + month + "/" + givenYear;
           
            if (dayOfWeek == 0) {
                dayString += " Sunday";
            }

            System.out.println(dayString);

            advance();

           
            if (dayOfMonth > 31 && month == 12 && year == givenYear) {
                break;
            }
        }
    }

    private static void advance() {
        dayOfWeek = (dayOfWeek + 1) % 7;

        dayOfMonth++;

        if (dayOfMonth > nDaysInMonth) {
            dayOfMonth = 1;
            month++;

            if (month > 12) {
                month = 1;
                year++;
            }

            setDaysInMonth();
        }
    }

    private static void setDaysInMonth() {
        if (month == 2) {
            nDaysInMonth = isLeapYear(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            nDaysInMonth = 30;
        } else {
            nDaysInMonth = 31;
        }
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }
}

