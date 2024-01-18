// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

  private CANSparkMax frontMotor, backMotor;
  private MotorControllerGroup motors;


  /** Creates a new ShooterTest. */
  public ShooterSubsystem() {
    frontMotor = new CANSparkMax(16, MotorType.kBrushed);
    backMotor = new CANSparkMax(17, MotorType.kBrushed);

    motors = new MotorControllerGroup(frontMotor, backMotor);
  }

  public void testSpin(){
    motors.set(1);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
