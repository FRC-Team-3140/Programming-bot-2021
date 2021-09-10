/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.drivetrain.Drive;
import frc.robot.subsystems.Drivetrain;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer implements Constants.ElectricalPortConstants {
  // The robot's subsystems and OI devices
 
  // Subsystems and class objects used elsewhere in the code
  //  are declared here.
  // All classes required by any class instantiated here must, be instantiated before the instatiated class.
  public static final Drivetrain dt = new Drivetrain();
 
  // e.x. AutoGenerator uses Drivetrain classes, so it must be made after drivetrain

  // Xbox controllers
  public static final XboxController xbox = new XboxController(xboxPrimaryDriver);

  
  public RobotContainer() {
    configureButtonBindings();
    configureDefaultCommands();
  }

  private void configureButtonBindings() {
    // Primary Driver Controls
    //xbox.leftBumper.whileHeld(new HoldPositionController());

  }

  private void configureDefaultCommands() {
    dt.setDefaultCommand(new Drive());
  }

}
