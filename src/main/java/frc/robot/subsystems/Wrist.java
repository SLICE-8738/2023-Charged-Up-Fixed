// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.slicelibs.PositionalSubsystem;

public class Wrist extends PositionalSubsystem {
  /** Creates a new ExampleSubsystem. */
  public Wrist() {
    super(new int[]{0},new boolean[]{true}, 0.1,0,0,0,0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}