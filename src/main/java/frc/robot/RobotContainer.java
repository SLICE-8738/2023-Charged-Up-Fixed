// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Intaking;
import frc.robot.commands.ShooterTest;
import frc.robot.commands.StopShooterTest;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private Joystick joystick = new Joystick(0);
  private JoystickButton intakeButton = new JoystickButton(joystick, 3);
  private JoystickButton outtakeButton = new JoystickButton(joystick, 4);
  private Intake intaking = new Intake();
  private Intaking in = new Intaking(intaking, true);
  private Intaking out = new Intaking(intaking, false);



  private final PS4Controller controller = new PS4Controller(0);
  private final Trigger shooterButton = new JoystickButton(controller, PS4Controller.Button.kCircle.value);
  private final Trigger stopShooterButton = new JoystickButton(controller, PS4Controller.Button.kCross.value);

  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ShooterTest shooterTest = new ShooterTest(shooterSubsystem);
  private final StopShooterTest stopShooterTest = new StopShooterTest(shooterSubsystem);



  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    intakeButton.whileTrue(in);
    outtakeButton.whileTrue(out);

    shooterButton.toggleOnTrue(shooterTest);
    stopShooterButton.toggleOnTrue(stopShooterTest);
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(null);
  }
}
