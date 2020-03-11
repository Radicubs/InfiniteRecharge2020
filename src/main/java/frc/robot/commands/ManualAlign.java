package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class ManualAlign extends CommandGroup {
  public ManualAlign() {

    requires(Robot.driveBase);
    addSequential(new RotationAlignment(), 1);
    addSequential(new DistanceAlignment(), 1.5);
    addSequential(new RotationAlignment(), 1);

  }
}
