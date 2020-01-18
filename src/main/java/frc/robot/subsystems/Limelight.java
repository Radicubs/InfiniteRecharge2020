package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Limelight extends Subsystem {

    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    double ledState = 0.0;

    public Limelight(){
      
    }

    public void setLedOn() {

        ledState = 3.0;  
      }
    
      public void setLedOff() {
    
        ledState = 1.0;
      }
    
      public void setLedBlink() {
    
        ledState = 2.0; 
      }

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());

        // setDefaultCommand(new UpdateLimeLight()); }
    }

}