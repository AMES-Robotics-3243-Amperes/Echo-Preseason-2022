// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants;
import frc.robot.JoyUtil;
import frc.robot.Math;

/** An example command that uses an example subsystem. */
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveTrainSubsystem m_subsystem;
  
  JoyUtil driveController;

  private Constants constants = new Constants();
  private Math math = new Math();

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveTrainSubsystem subsystem, JoyUtil _driveController) {
    m_subsystem = subsystem;
    driveController = _driveController;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // turn the value read from each trigger to a value from 1 to the value set in constants
    double rightTriggerAdjustment = math.remap(true, driveController.getRightTriggerAxis(), 0, 1, 1, constants.rightTriggerSpeedModifier);
    double leftTriggerAdjustment = math.remap(true, driveController.getLeftTriggerAxis(), 0, 1, 1, constants.leftTriggerSpeedModifier);

    m_subsystem.driveLeftMotors(-driveController.getDeadzoneLeftY(true, true) * constants.driveSpeed * rightTriggerAdjustment * leftTriggerAdjustment);
    m_subsystem.driveRightMotors(driveController.getDeadzoneRightY(true, true) * constants.driveSpeed * rightTriggerAdjustment * leftTriggerAdjustment);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
