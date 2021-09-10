package frc.robot.subsystems;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.HardwareAdapter;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase implements HardwareAdapter, Constants.GeneralConstants.SensorConstants {
  private boolean reversedTrajectory = false;

  public Drivetrain() {
    setupMotors();

  }

  /***********
   * DRIVING *
   ***********/

  public void tankDrive(double left, double right) {
    leftDriveMaster.set(left);
    rightDriveMaster.set(right);
  }

  public void tankDriveVolts(double leftVolts, double rightVolts) {
    // Comment these lines out and then stop multiplying constants by 10????
    leftVolts = leftVolts/12;
    rightVolts = rightVolts/12;

    System.out.println("leftVolts: " + leftVolts + "  rightVolts: " + rightVolts);

    if(Math.abs(leftVolts) > 12)
      leftVolts = Math.signum(leftVolts) * 12;

    if(Math.abs(rightVolts) > 12)
      rightVolts = Math.signum(rightVolts) * 12;    

    if(reversedTrajectory) {
      leftDriveMaster.setVoltage(-rightVolts);
      rightDriveMaster.setVoltage(-leftVolts);
    }
    else {
      leftDriveMaster.setVoltage(leftVolts);
      rightDriveMaster.setVoltage(rightVolts);
    }
  }

  /************
   * PERIODIC *
   ************/
  @Override
  public void periodic() {
  }

  /******************
   * SETTER METHODS *
   ******************/
  public void setTrajectoryReversed(boolean reversed) {
    reversedTrajectory = reversed;
  }

  /**********
   * CONFIG *
   **********/
  private void setupMotors() {
    boolean leftInverted = true;
    boolean rightInverted = false;

    leftDriveMaster.setInverted(leftInverted);
    leftDriveSlave1.follow(leftDriveMaster);
    leftDriveSlave1.setInverted(leftInverted);

    rightDriveMaster.setInverted(rightInverted);
    rightDriveSlave1.follow(rightDriveMaster);
    rightDriveSlave1.setInverted(rightInverted);

    setIdleMode(IdleMode.kBrake);
  }

  public void setIdleMode(IdleMode mode) {
    leftDriveMaster.setIdleMode(mode);
    leftDriveSlave1.setIdleMode(mode);

    rightDriveMaster.setIdleMode(mode);
    rightDriveSlave1.setIdleMode(mode);
  }

}