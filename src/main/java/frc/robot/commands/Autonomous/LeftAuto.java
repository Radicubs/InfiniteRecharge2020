package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Robot;
import frc.robot.commands.AutoShoot; 


public class LeftAuto extends CommandGroup {
  public LeftAuto() {
    System.out.println("Testing");
    requires(Robot.driveBase);
  
    addSequential(new DriveForward(0.3), 1.5);  
    addSequential(new TurnLeft(0.3), .4667); // perfect right angle
    addSequential(new DriveForward(0.5), 2);
    addSequential(new TurnLeft(0.3), .4667);
    //addSequential(new AutoShoot());

  }
}