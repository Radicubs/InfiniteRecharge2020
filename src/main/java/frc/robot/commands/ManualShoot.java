package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class ManualShoot extends Command {
  private double speed;
  private static double shootState = 1.0;
  private static String dashboardState = "OFF";

  public ManualShoot(double speed) {
    requires(Robot.shooter);
    this.speed = speed;
  }

  @Override
  protected void execute() {
    Robot.shooter.shoot(speed * shootState);
    SmartDashboard.putString("Shooter State", dashboardState);
  }

  public static void shootOnOff() {
    if (shootState == 0.0) {
      shootState = 1.0;
      dashboardState = "ON";
    } else {
      shootState = 0.0;
      dashboardState = "OFF";
    }
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

  @Override
  protected void end() {
    Robot.shooter.shoot(0);
  }

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
