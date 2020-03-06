package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoShoot; 


public class MiddleAuto extends CommandGroup {
  public MiddleAuto() {

    requires(Robot.driveBase);
    addSequential(new DriveForward(0.3), 1.5);  
    addSequential(new TurnLeft(0.3), .4667); // perfect right angle
    addSequential(new DriveForward(0.5), 1);
    addSequential(new TurnLeft(0.3), .4667);
    addSequential(new AutoShoot());

  }
}