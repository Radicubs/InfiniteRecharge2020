package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.AutoShoot; 


public class LeftAuto extends CommandGroup {
  public LeftAuto() {
    System.out.println("Testing");
  
    addSequential(new DriveForward(0.4), 1.5);  
    addSequential(new TurnRight(0.3), 1.4);
    addSequential(new DriveForward(0.4), 2);
    addSequential(new AutoShoot());

  }
}