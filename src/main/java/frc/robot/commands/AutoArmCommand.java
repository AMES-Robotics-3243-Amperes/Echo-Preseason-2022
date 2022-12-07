// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class AutoArmCommand extends CommandBase {
  
  // used to manage how long the auto runs
  private Timer clock;

  // subsystem
  private final ArmSubsystem m_subsystem;

  Constants constants = new Constants();

  /** Creates a new AutoDrive. */
  public AutoArmCommand(ArmSubsystem subsystem) {
    m_subsystem = subsystem;
    clock = new Timer();

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize()
  {
    m_subsystem.moveArm(constants.autoArmSpeed);

    clock.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    m_subsystem.moveArm(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return clock.get() > constants.autoArmTime;
  }
}
