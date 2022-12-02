// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class AutoDriveCommand extends CommandBase {
  
  // used to manage how long the auto runs
  private long calls = 0;

  // subsystem
  private final DriveTrainSubsystem m_subsystem;

  Constants constants = new Constants();

  /** Creates a new AutoDrive. */
  public AutoDriveCommand(DriveTrainSubsystem subsystem) {
    m_subsystem = subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    m_subsystem.driveLeftMotors(constants.autoDriveSpeed);
    m_subsystem.driveRightMotors(constants.autoDriveSpeed);

    calls = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    m_subsystem.driveLeftMotors(constants.autoDriveSpeed);
    m_subsystem.driveRightMotors(constants.autoDriveSpeed);

    calls++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_subsystem.driveLeftMotors(0);
    m_subsystem.driveRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (calls >= constants.driveCalls) ? true : false;
  }
}
