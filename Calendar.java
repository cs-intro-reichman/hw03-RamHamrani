public class Calendar {
    // Starting the calendar on 1/1/1900
    static int dayOfMonth = 1;
    static int month = 1;
    static int year = 1900;
    static int dayOfWeek = 2;      // 1.1.1900 was a Monday
    static int nDaysInMonth = 31;  // Number of days in January

    /**
     * Prints the calendars of all the years in the 20th century. Also prints the
     * number of Sundays that occurred on the first day of the month during this period.
     */
    public static void main(String args[]) {
        int debugDaysCounter = 0; // For debugging purposes
        int givenYear = Integer.parseInt(args[0]);

        while (year <= givenYear) {
            if (dayOfMonth == 1 && dayOfWeek == 7) {
                System.out.println(dayOfMonth + "/" + month + "/" + givenYear + " Sunday");
            } else {
                System.out.println(dayOfMonth + "/" + month + "/" + givenYear);
            }

            advance();
            debugDaysCounter++;

            if (dayOfMonth == 1 && dayOfWeek == 1 && year != 1900) {
                System.out.println();
            }
        }
    }

    // Advances the date (day, month, year) and the day-of-the-week.
    // If the month changes, sets the number of days in this month.
    // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
    private static void advance() {
        dayOfWeek = (dayOfWeek % 7) + 1;

        if (dayOfMonth == nDaysInMonth) {
            dayOfMonth = 1;

            if (month == 12) {
                month = 1;
                year++;

                if (isLeapYear(year)) {
                    nDaysInMonth = 29;
                } else {
                    nDaysInMonth = 28;
                }
            } else {
                month++;

                switch (month) {
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        nDaysInMonth = 30;
                        break;
                    case 2:
                        if (isLeapYear(year)) {
                            nDaysInMonth = 29;
                        } else {
                            nDaysInMonth = 28;
                        }
                        break;
                    default:
                        nDaysInMonth = 31;
                        break;
                }
            }
        } else {
            dayOfMonth++;
        }
    }

    // Returns true if the given year is a leap year, false otherwise.
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
