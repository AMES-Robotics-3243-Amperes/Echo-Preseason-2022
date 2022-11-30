// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

import frc.robot.Constants;
import frc.robot.JoyUtil;

public class ArmCommand extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ArmSubsystem m_subsystem;
    
    JoyUtil driveController;
  
    Constants constants = new Constants();
  
    /**
     * Creates a new ExampleCommand.
     *
     * @param subsystem The subsystem used by this command.
     */
    public ArmCommand(ArmSubsystem subsystem, JoyUtil _driveController) {
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
      double moveSpeed = 0;

      int povDegrees = driveController.getPOV();

      if ((povDegrees < 90 && povDegrees != -1) || povDegrees > 270)
        moveSpeed += 1;
      else if (povDegrees > 90 && povDegrees < 270)
        moveSpeed -= 1;
  
      moveSpeed -= driveController.getLeftBumper() ? 1 : 0;
      moveSpeed += driveController.getRightBumper() ? 1 : 0;
  
      if (moveSpeed < -1 || moveSpeed > 1)
        moveSpeed /= 2;

      m_subsystem.moveArm(moveSpeed * constants.armSpeed);
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
  