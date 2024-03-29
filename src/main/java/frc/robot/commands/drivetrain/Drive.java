package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class Drive extends CommandBase {
  public Drive() {
    addRequirements(RobotContainer.dt);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    double leftspeed = RobotContainer.xbox.getSmoothedAltY();
    double rightspeed = RobotContainer.xbox.getSmoothedMainY();

    RobotContainer.dt.tankDrive(.2*leftspeed,.2*rightspeed);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
