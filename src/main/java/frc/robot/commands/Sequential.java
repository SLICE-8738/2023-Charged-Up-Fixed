// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wrist;
import frc.robot.subsystems.Intake;

/** An example command that uses an example subsystem. */
public class Sequential extends SequentialCommandGroup {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public Sequential(Arm arm, Wrist wrist, Intake intake) {
  
    addCommands(
      new LimbMove(arm, 0),

      new LimbMove(wrist, 0),

      new Intaking(intake, false),

      new LimbMove(wrist, 0),

      new LimbMove(arm, 0));
    // Use addRequirements() here to declare subsystem dependencies.
  }
}

