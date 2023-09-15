// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DriveStraight;
import frc.robot.subsystems.DrivetrainSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the [Robot]
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // Hardware and subsystem initialization

  private DrivetrainSubsystem drivetrainSubsystem = new DrivetrainSubsystem();
  private XboxController primaryController = new XboxController(0);

  public RobotContainer() {
    configureButtonBindings();
    configureAutoOptions();
  }

  private SendableChooser<Command> autoCommandChooser = new SendableChooser<>();

  /**
   * Controller ([GenericHID], [XboxController]) mapping.
   */
  private void configureButtonBindings() {
    drivetrainSubsystem.setDefaultCommand(new DriveStraight(drivetrainSubsystem, primaryController));
  }

  private void configureAutoOptions() {
    // Drive forwards for 1.5s to clear tarmac [2pt]
  }

  public Command getAutonomousCommand() {
    return autoCommandChooser.getSelected();
  }
}
