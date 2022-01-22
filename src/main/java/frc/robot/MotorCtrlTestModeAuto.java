package frc.robot;

import org.xero1425.base.controllers.TestAutoMode;
import org.xero1425.base.motorsubsystem.MotorEncoderPowerAction;
import org.xero1425.base.motorsubsystem.MotorEncoderVelocityAction;
import org.xero1425.base.motorsubsystem.PowerTestAction;
import org.xero1425.base.motorsubsystem.VelocityTestAction;

public class MotorCtrlTestModeAuto extends TestAutoMode {
    VelocityTestAction vaction_ = null ;
    PowerTestAction paction_ = null ;

    public MotorCtrlTestModeAuto(MotorCtrlAutoController ctrl) throws Exception {
        super(ctrl, "MotorCtrl-Test-Mode");

        MotorCtrlRobotSubsystem robotsub = (MotorCtrlRobotSubsystem) ctrl.getRobot().getRobotSubsystem();
        TestMotorSubsystem m1 = robotsub.getMotor1() ;
        TestMotorSubsystem m2 = robotsub.getMotor2() ;

        switch (getTestNumber()) {
            //
            // Numbers 0 - 9 are for the driverbase
            //
            case 0:
                addSubActionPair(m1, new MotorEncoderPowerAction(m1, getPower()), true);
                addSubActionPair(m2, new MotorEncoderPowerAction(m2, getPower()), true);
                break ;
            case 1:
                addSubActionPair(m1, new MotorEncoderVelocityAction(m1, "testvelaction", 100), true) ;
                addSubActionPair(m2, new MotorEncoderVelocityAction(m1, "testvelaction", 100), true) ;
                break ;     
        }
    }
}