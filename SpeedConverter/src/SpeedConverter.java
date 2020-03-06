public class SpeedConverter {
    public static void main(String[] args) {
        long milesPerHour = toMilesPerHour(1.5);
        System.out.println("milesPerHour = " + milesPerHour);
        milesPerHour =toMilesPerHour(10.25);
        System.out.println("milesPerHour = " + milesPerHour);
        milesPerHour =toMilesPerHour(-5.6);
        System.out.println("milesPerHour = " + milesPerHour);

        printConversion(1.5);
        printConversion(10.25);
        printConversion(-5.6);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        long milesPerHour = -1;
        if(kilometersPerHour >= 0) {
            milesPerHour = Math.round (kilometersPerHour / 1.609d);
        }
        return  milesPerHour;
    }

    public static void printConversion(double kilometersPerHour) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if(milesPerHour >= 0) {
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        } else {
            System.out.println("Invalid value");
        }
    }

}
