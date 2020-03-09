package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import frc.robot.commands.AutoShoot;
import frc.robot.commands.DistanceAlignment;
import frc.robot.commands.ManualIndex;
import frc.robot.commands.RotationAlignment;
import frc.robot.commands.automaticcommands.ShootBallAutomatic; 



public class RightAuto extends CommandGroup {
  public RightAuto() {

    addSequential(new DistanceAlignment(), 2);
    addSequential(new RotationAlignment(), 3);
    addSequential(new IndexAndShoot(), 4);


  }
}