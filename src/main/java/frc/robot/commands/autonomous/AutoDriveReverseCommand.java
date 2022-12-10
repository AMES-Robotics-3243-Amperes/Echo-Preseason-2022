// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;

public class AutoDriveReverseCommand extends CommandBase {
  // constants :)
  private Constants constants = new Constants();

  // used to measure execution time
  Timer clock;

  // subsystem
  DriveTrainSubsystem m_subsystem;

  double _time;

  /** Creates a new AutoDriveCommand. */
  public AutoDriveReverseCommand(DriveTrainSubsystem subsystem)
  {
    m_subsystem = subsystem;
    clock = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    m_subsystem.driveLeftMotors(constants.autoRetreatDriveSpeed);
    m_subsystem.driveRightMotors(-constants.autoRetreatDriveSpeed);
    clock.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted)
  {
    m_subsystem.driveLeftMotors(0);
    m_subsystem.driveRightMotors(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished()
  {
    return clock.get() >= constants.autoRetreatDriveTime;
  }
}
