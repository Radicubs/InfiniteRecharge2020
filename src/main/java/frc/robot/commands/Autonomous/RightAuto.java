package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.Autonomous.DriveBackward;
import frc.robot.commands.Autonomous.DriveForward;

public class RightAuto extends CommandGroup{
  public RightAuto() {
    addSequential(new DriveForward(2000));
    addSequential(new DriveBackward(2000));

    
  }

}