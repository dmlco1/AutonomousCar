import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;

import java.util.Scanner;

public class AutonomousCar {
    public static void main(String[] args) {
        String filename = "fcls/action.fcl";
        FIS fis = FIS.load(filename, true);
        if (fis == null) {
            System.err.println("Can't load file: '" + filename + "'");
            System.exit(1);
        }

        // create a scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("What's the velocity of the car? ");
        // velocity is the input from the user
        double velocity = scanner.nextDouble();
        System.out.println("What's the distance to the obstacle? ");
        // distance is the input from the user
        double distance = scanner.nextDouble();

        // default function block
        FunctionBlock fb = fis.getFunctionBlock(null);

        // set the inputs
        fb.setVariable("velocity", velocity);
        fb.setVariable("distance", distance);
        // evaluate
        fb.evaluate();

        // show output variable's chart
        fb.getVariable("execute").defuzzify();

        // print the result
        System.out.println(fb);
        System.out.println("Action: " + fb.getVariable("execute").getValue());
    }
}
