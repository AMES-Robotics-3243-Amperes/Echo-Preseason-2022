// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // fun deadzone stuff (keep deadzones positive)
    public final double innerDeadzone = 0.06;
    public final double outerDeadzone = 0.08;

    public final boolean doInnerDeadzone = true;
    public final boolean doOuterDeadzone = true;

    // channels
    public final int leftFrontMotorChannel = 9;
    public final int leftBackMotorChannel = 8;
    public final int rightFrontMotorChannel = 7;
    public final int rightBackMotorChannel = 6;

    public final int elevatorTopMotorChannel = 5;
    public final int elevatorBottomMotorChannel = -1;
    public final int armMotorChannel = 4;

    public final int elevatorLimitSwitchChannel = 0;

    // speeds
    public final double driveSpeed = 0.35;
    public final double rightTriggerSpeedModifier = 1.6;
    public final double leftTriggerSpeedModifier = 0.55;

    public final double armSpeed = 0.5;
    public final double elevatorSpeedUpLimit = 0.38;
    public final double elevatorSpeedUpManual = 0.5;
    public final double elevatorSpeedDown = 0.3;

    // auto stuff (time is in seconds)
    public final double autoArmTime = 2.2;
    public final double autoArmSpeed = 0.53;

    public final double autoElevatorSpeed = 0.35;

    public final double autoDriveTime = 1.35;
    public final double autoDriveSpeed = 0.35;
}