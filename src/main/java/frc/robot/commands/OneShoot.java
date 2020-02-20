package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class OneShoot extends InstantCommand {
  public OneShoot() {

    requires(Robot.driveBase); // change to shooter once merged with master
  }

  // Time to Run command
  long endTime = System.currentTimeMillis() + 2000;
    private boolean distanceFinished = false;
    private double distanceFromTarget;

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    // Run shooter
    while (System.currentTimeMillis() < endTime) {
        Robot.driveBase.drive(1, 1); // change to shooter once merged with master
      } 

  }

  @Override
  protected boolean isFinished() {
    return distanceFinished;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    super.interrupted();
  }
}
