package frc.robot;

import edu.wpi.first.wpilibj.XboxController;

public class JoyUtil extends XboxController {
    private Constants constants = new Constants();
    private Math math = new Math();

    // this is used for the joysticks
    private double deadzone(double input, boolean deadzoneInner, boolean deadzoneOuter)
    {
        boolean isNegative = input < 0;
        if (isNegative)
            input *= -1;

        double innerDeadzone = deadzoneInner ? constants.innerDeadzone : 0;
        double outerDeadzone = deadzoneOuter ? constants.outerDeadzone : 1;

        input = math.remap(true, input, innerDeadzone, outerDeadzone, 0, 1);
        input *= input * input * input;
        if (isNegative)
            input *= -1;

        return input;
    } 

    // constructor
    public JoyUtil(int port) { super(port); }

    public double getDeadzoneLeftY(boolean deadzoneInner, boolean deadzoneOuter)
    {
        return deadzone(getLeftY(), deadzoneInner, deadzoneOuter);
    }
    public double getDeadzoneRightY(boolean deadzoneInner, boolean deadzoneOuter)
    {
        return deadzone(getRightY(), deadzoneInner, deadzoneOuter);
    }

    public double getDeadzoneLeftX(boolean deadzoneInner, boolean deadzoneOuter)
    {
        return deadzone(getLeftX(), deadzoneInner, deadzoneOuter);
    }
    public double getDeadzoneRightX(boolean deadzoneInner, boolean deadzoneOuter)
    {
        return deadzone(getRightX(), deadzoneInner, deadzoneOuter);
    }
}