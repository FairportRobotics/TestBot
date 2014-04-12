/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fairportfirst.test.subsystems;

import com.fairportfirst.test.RobotMap;
import com.fairportfirst.test.commands.TylersCommand;
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Tyler
 */
public class TylersSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    CANJaguar driveOne;
    
    public TylersSubsystem(){
        try {
            driveOne = new CANJaguar(RobotMap.DRIVE_ONE_ID);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new TylersCommand());
    }
    
    public void drive(int speed){
        try {
            driveOne.setX(speed);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}