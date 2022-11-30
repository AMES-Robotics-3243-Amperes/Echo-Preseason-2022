// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

import frc.robot.Constants;
import frc.robot.JoyUtil;

public class ElevatorCommand extends CommandBase {

  // used for the "move elevator to top" command
  boolean moveToTop = false;

  // epic gamer constants
  Constants constants = new Constants();

  // :| our subsystem
  ElevatorSubsystem m_subsystem;

  // controller
  JoyUtil driveController;

  // limit switch
  DigitalInput limitSwitch = new DigitalInput(constants.elevatorLimitSwitchChannel);

  /** Creates a new ElevatorCommand. */
  public ElevatorCommand(ElevatorSubsystem subsystem, JoyUtil _driveController) {
    driveController = _driveController;
    m_subsystem = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    boolean isAtTop = limitSwitch.get();
    double moveSpeed = 0;

    moveSpeed -= driveController.getAButton() || driveController.getLeftBumper() ? 1 : 0;
    moveSpeed += driveController.getYButton() || driveController.getRightBumper() ? 1 : 0;

    // make sure the speed doesn't double if multiple
    // buttons of the same direction are pressed
    if (moveSpeed < -1 || moveSpeed > 1)
      moveSpeed /= 2;

    // multiply the correct speed (if the limit switch is pressed, don't move up)
    if (moveSpeed > 0)
      moveSpeed *= isAtTop ? 0 : constants.elevatorSpeedUpManual;
    else if (moveSpeed < 0)
      moveSpeed *= constants.elevatorSpeedDown;

    if (driveController.getBButton() || moveSpeed < 0 || isAtTop)
      moveToTop = false;
    else if (driveController.getXButton())
      moveToTop = true;

    // if move to top is true, move the elevator up
    if (moveToTop && moveSpeed == 0 && !isAtTop)
      moveSpeed = constants.elevatorSpeedUpLimit;

    m_subsystem.moveElevator(moveSpeed);

    SmartDashboard.putBoolean("Elevator at Top", isAtTop);
    SmartDashboard.putBoolean("Moving to Top", moveToTop);
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