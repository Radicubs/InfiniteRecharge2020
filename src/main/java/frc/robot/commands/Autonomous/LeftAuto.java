package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.DistanceAlignment;
import frc.robot.commands.RotationAlignment;


public class LeftAuto extends CommandGroup {
  public LeftAuto() {
    requires(Robot.driveBase);
  
    requires(Robot.driveBase);
    addSequential(new DriveForward(0.3), 1.5);  
    // addSequential(new TurnLeft(0.3), .4667); // perfect right angle
    // addSequential(new DriveForward(0.5), 1.7);
    // addSequential(new TurnLeft(0.3), .4667);
    // addSequential(new DistanceAlignment(), 3);
    // addSequential(new RotationAlignment(), 2);
    // addSequential(new IndexAndShoot(),4);

  }
}