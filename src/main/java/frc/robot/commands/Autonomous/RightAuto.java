package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup; 
import frc.robot.commands.AutoShoot; 



public class RightAuto extends CommandGroup {
  public RightAuto() {

    addSequential(new AutoShoot());

  }
}