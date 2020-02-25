package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class DriveMode extends InstantCommand {
  public DriveMode() {
      
  }

  @Override
  protected void initialize() {    
    ArcadeDrive.changeDriveMode();
} 

  }