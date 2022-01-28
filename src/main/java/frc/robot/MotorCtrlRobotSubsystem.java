package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;

import edu.wpi.first.wpilibj.I2C;

public class MotorCtrlRobotSubsystem extends RobotSubsystem {
    TestMotorSubsystem sub1_ ;
    TestMotorSubsystem sub2_ ;
    ZekeColorSensor color_ ;

    public MotorCtrlRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "MotorCtrlSubsystem") ;

        sub1_ = new TestMotorSubsystem(this, "motor1") ;
        addChild(sub1_);

        sub2_ = new TestMotorSubsystem(this, "motor2") ;
        addChild(sub2_);

        color_ = new ZekeColorSensor(this, I2C.Port.kMXP, 0x70) ;
        addChild(color_) ;
    }

    public TestMotorSubsystem getMotor1() {
        return sub1_ ;
    }

    public TestMotorSubsystem getMotor2() {
        return sub2_ ;
    }    

    public ZekeColorSensor getColor() {
        return color_ ;
    }
}
