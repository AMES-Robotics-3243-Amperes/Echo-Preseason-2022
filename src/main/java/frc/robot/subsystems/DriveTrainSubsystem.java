// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrainSubsystem extends SubsystemBase {
  // constants :)
  Constants constants = new Constants();
  
  VictorSP leftFrontMotor = new VictorSP(constants.leftFrontMotorChannel);
  VictorSP leftBackMotor = new VictorSP(constants.leftBackMotorChannel);
  VictorSP rightFrontMotor = new VictorSP(constants.rightFrontMotorChannel);
  VictorSP rightBackMotor = new VictorSP(constants.rightBackMotorChannel);

  public void driveLeftMotors(double input) {
    leftFrontMotor.set(input);
    leftBackMotor.set(input);
  }

  public void driveRightMotors(double input) {
    rightFrontMotor.set(input);
    rightBackMotor.set(input);
  }

  public DriveTrainSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
