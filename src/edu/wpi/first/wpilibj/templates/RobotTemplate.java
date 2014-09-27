/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import robot.util.control.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    private XboxController controller;
    private SpeedController motors1;
    private SpeedController motors2;
    public static final double TOLERANCE = 0.05;
    public void robotInit() {
        controller = new XboxController();
        motors1 = new Talon(1);
        motors2 = new Talon(2);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        double x = -controller.getAxis(XboxController.LEFT_X);
        double y = controller.getAxis(XboxController.RIGHT_X);
        if(Math.abs(x) < TOLERANCE){
            x = 0;
        }
        if(Math.abs(y) < TOLERANCE){
            y = 0;
        }
        motors1.set(x);
        motors2.set(y);
        if(controller.getButton(XboxController.LB)){
            motors1.set(0);
            motors2.set(0);
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
