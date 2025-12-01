// Ross Elliott
//  221
// Unit Converter project 1 -

import java.util.Scanner;

public class UnitConverter {

    //main method
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("welcome to the converter!");
        System.out.println("example: convert feet to meters 10");
        System.out.println("type exit to quit\n");

        while (true) {
            System.out.print("enter conversion: ");
            String user = input.nextLine().toLowerCase();

            // exit the project
            if (user.equals("exit")) {
                System.out.println("thanks for using the converter!");
                break;
            }

            String[] parts = user.split(" ");

            // check the format and the wording count
            if (parts.length != 5 || !parts[0].equals("convert") || !parts[2].equals("to")) {
                System.out.println("invalid format. try: convert feet to meters 10\n");
                continue;
            }

            String start = parts[1];
            String end = parts[3];
            double num = 0;

            try {
                num = Double.parseDouble(parts[4]);
            } catch (Exception e) {
                System.out.println("that’s not a number.\n");
                continue;
            }

            // weight cant be negative
            if ((start.equals("kilograms") || start.equals("pounds") ||
                start.equals("grams") || start.equals("ounces")) && num < 0) {
                System.out.println("weight cant be negative.\n");
                continue;
            }

            double result = convertunits(start, end, num);
            System.out.println(num + " " + start + " = " + result + " " + end + "\n");
        }

        input.close();
    }

    //  converting math 
    public static double convertunits(String start, String end, double num) {

        // length conversions
        if (start.equals("meters") && end.equals("feet"))
            return num * 3.28;
        if (start.equals("feet") && end.equals("meters"))
            return num / 3.28;
        if (start.equals("kilometers") && end.equals("miles"))
            return num * 0.62;
        if (start.equals("miles") && end.equals("kilometers"))
            return num / 0.62;

        // weight conversions
        if (start.equals("kilograms") && end.equals("pounds"))
            return num * 2.2;
        if (start.equals("pounds") && end.equals("kilograms"))
            return num / 2.2;
        if (start.equals("grams") && end.equals("ounces"))
            return num / 28.3;
        if (start.equals("ounces") && end.equals("grams"))
            return num * 28.3;

        // temperature conversions
        if (start.equals("celsius") && end.equals("fahrenheit"))
            return (num * 9 / 5) + 32;
        if (start.equals("fahrenheit") && end.equals("celsius"))
            return (num - 32) * 5 / 9;
        if (start.equals("celsius") && end.equals("kelvin"))
            return num + 273.15;
        if (start.equals("kelvin") && end.equals("celsius"))
            return num - 273.15;

        // currency conversions
        if (start.equals("usd") && end.equals("eur"))
            return num * 0.9;
        if (start.equals("eur") && end.equals("usd"))
            return num / 0.9;
        if (start.equals("usd") && end.equals("bitcoin"))
            return num * 0.00002; // idk about this part 
        if (start.equals("bitcoin") && end.equals("usd"))
            return num / 0.00002;

        // extra 
        if (start.equals("kph") && end.equals("mph"))
            return num * 0.621;

        System.out.println("can't convert those units lol.");
        return 0;
    }
}
