package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.commands.automaticcommands.ShootBallAutomatic;

public class ShootState extends InstantCommand {
  public ShootState() {
      
  }

  @Override
  protected void initialize() {    
    ShootBallAutomatic.shootOnOff();
} 

  }