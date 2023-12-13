// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  CANSparkMax frontLeftMotor;
  CANSparkMax frontRightMotor;
  CANSparkMax backLeftMotor;
  CANSparkMax backRightMotor;

  MotorControllerGroup leftMotors;
  MotorControllerGroup rightMotors;

  DifferentialDrive driveTrain;
  
  /** Creates a new ExampleSubsystem. */
  public DriveTrain() {
    frontLeftMotor = new CANSparkMax(16, MotorType.kBrushed);
    frontRightMotor = new CANSparkMax(17, MotorType.kBrushed);
    backLeftMotor = new CANSparkMax(15, MotorType.kBrushed);
    backRightMotor = new CANSparkMax(18, MotorType.kBrushed);
    frontLeftMotor.setInverted(true);

    leftMotors = new MotorControllerGroup(frontLeftMotor, backLeftMotor);
    rightMotors = new MotorControllerGroup(frontRightMotor, backRightMotor);

    driveTrain = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void drive(double speed, double turnSpeed) {
    driveTrain.arcadeDrive(speed, turnSpeed);
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