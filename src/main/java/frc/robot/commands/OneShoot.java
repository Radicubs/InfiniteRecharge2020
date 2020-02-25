package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class OneShoot extends InstantCommand {
  public OneShoot() {
    super();
    requires(Robot.driveBase); // change to shooter once merged with master
  }

  // Time to Run command
    long endTime = System.currentTimeMillis() + 2000;
    private boolean distanceFinished = false;
    private double distanceFromTarget;

  @Override
  protected void initialize() {
    // Run shooter
    while (System.currentTimeMillis() < endTime) {
        Robot.driveBase.drive(1, 1); // change to shooter once merged with master
      } 

  }
}
