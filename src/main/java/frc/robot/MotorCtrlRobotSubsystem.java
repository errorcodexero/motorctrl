package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;

public class MotorCtrlRobotSubsystem extends RobotSubsystem {
    TestMotorSubsystem sub1_ ;
    TestMotorSubsystem sub2_ ;

    public MotorCtrlRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "MotorCtrlSubsystem") ;

        sub1_ = new TestMotorSubsystem(this, "motor1") ;
        addChild(sub1_);

        sub2_ = new TestMotorSubsystem(this, "motor2") ;
        addChild(sub2_);
    }

    public TestMotorSubsystem getMotor1() {
        return sub1_ ;
    }

    public TestMotorSubsystem getMotor2() {
        return sub2_ ;
    }    
}
