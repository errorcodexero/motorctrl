package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;

public class MotorCtrlRobotSubsystem extends RobotSubsystem {
    TestMotorSubsystem sub_ ;
    ColorSensorSubsystem color_ ;

    public MotorCtrlRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "MotorCtrlSubsystem") ;

        sub_ = new TestMotorSubsystem(this) ;
        addChild(sub_);

        color_ = new ColorSensorSubsystem(this, "color") ;
        addChild(color_) ;
    }

    public TestMotorSubsystem getTestmotors() {
        return sub_ ;
    }
}
