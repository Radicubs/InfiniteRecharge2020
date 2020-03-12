package frc.robot.commands.defaultcommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ClimberControl extends Command {

  // 0.4 for Slow mode, 0.8 for fast mode
  double res;
  double speed = 0.5; // calibrate this later

  public ClimberControl() {
    requires(Robot.elevator);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    res = 0;

    // Get Raw Axis Amounts
    double rt = Robot.oi.controller.getRawAxis(RobotMap.RT_AXIS);
    double lt = Robot.oi.controller.getRawAxis(RobotMap.LT_AXIS);
    if (rt > lt && rt > 0.5) {
      res = speed;
    } else if (lt > rt && lt > 0.5) {
      res = -speed;
    }

    Robot.elevator.elevatorRise(res);
  }

  @Override
  protected boolean isFinished() {
    // Make this return true when this Command no longer needs to run execute()
    return false;
  }

    @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
