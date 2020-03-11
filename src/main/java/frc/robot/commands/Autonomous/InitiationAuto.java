package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;

public class InitiationAuto extends CommandGroup {
  public InitiationAuto() {
    requires(Robot.driveBase);
    addSequential(new DriveBackward(0.4), 3);
  }
}
