package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.Robot;
import frc.robot.commands.DistanceAlignment;
import frc.robot.commands.RotationAlignment;

public class ShootingAuto extends CommandGroup {
  public ShootingAuto() {

    requires(Robot.driveBase);
    addSequential(new DistanceAlignment(), 3);
    addSequential(new RotationAlignment(), 2);
    addSequential(new RunShooter(), 4.5);
    addSequential(new IndexAndShoot(), 3);
    addSequential(new WaitCommand(3), 3);
    addSequential(new DriveBackward(0.4), 3);
  }
}
