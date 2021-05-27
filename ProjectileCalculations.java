import java.util.Scanner;

public class ProjectileCalculations {
    // gravitational constant
    public static final double ACCELERATION = -9.81;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        while (!console.toString().contains("stop")) {

            System.out.print("velocity (meters/second)? ");
            double velocity = console.nextDouble();
            System.out.print("angle (degrees)? ");
            double angle = Math.toRadians(console.nextDouble());
            System.out.print("number of steps to display? ");
            int steps = console.nextInt();
            System.out.println();

            // x = v*cos(theta)
            // y = v*sin(theta)
            double xVelocity = velocity * Math.cos(angle);
            double yVelocity = velocity * Math.sin(angle);
            double totalTime = -2.0 * yVelocity / ACCELERATION;
            double timeIncrement = totalTime / steps;
            double xIncrement = xVelocity * timeIncrement;

            double x = 0.0;
            double y = 0.0;
            double t = 0.0;
            System.out.println("step\tx\ty\ttime");
            System.out.println("0\t0.0\t0.0\t0.0");
            for (int i = 1; i <= steps; i++) {
                t += timeIncrement;
                x += xIncrement;
                y = yVelocity * t + 0.5 * ACCELERATION * t * t;
                System.out.println(i + "\t" + round(x) + "\t" + round(y) + "\t" + round(t));
            }
        }

    }

    public static double round(double n) {
        return (int) (n * 100.0 + 0.5) / 100.0;
    }
}
