package frc.robot.commands.onofftoggles;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.commands.defaultcommands.*;

public class DriveMode extends InstantCommand {
  @Override
  protected void initialize() {
    ArcadeDrive.changeDriveMode();
  }
}
