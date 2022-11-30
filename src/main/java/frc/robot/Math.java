package frc.robot;

public class Math {
    public double abs(double input) { return input < 0 ? -input : input; }

    public double remap(boolean clamp, double input, double minIn, double maxIn, double minOut, double maxOut)
    {
        double inRange = maxIn - minIn;
        double outRange = maxOut - minOut;

        input = (input - minIn) / inRange;
        input *= outRange;
        input += minOut;

        // move the input to the nearest bound of the ouput if clamp is true and it isn't in the output range
        // sorry for spaghetti code
        // lmao
        if (clamp && input < minOut && minOut < maxOut)
            input = minOut;
        else if (clamp && input > maxOut && minOut < maxOut)
            input = maxOut;
        else if (clamp && input < maxOut && minOut > maxOut)
            input = maxOut;
        else if (clamp && input > minOut && minOut > maxOut)
            input = minOut;

        return input;
    }
}