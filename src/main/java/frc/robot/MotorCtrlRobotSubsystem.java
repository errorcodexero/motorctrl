package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;

public class MotorCtrlRobotSubsystem extends RobotSubsystem {
    TestMotorSubsystem sub_ ;

    public MotorCtrlRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "MotorCtrlSubsystem") ;

        sub_ = new TestMotorSubsystem(this) ;
        addChild(sub_);
    }

    public TestMotorSubsystem getTestmotors() {
        return sub_ ;
    }
}
