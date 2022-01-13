package frc.robot;

import org.xero1425.base.controllers.TestAutoMode;
import org.xero1425.base.motorsubsystem.PowerTestAction;
import org.xero1425.base.motorsubsystem.VelocityTestAction;

public class MotorCtrlTestModeAuto extends TestAutoMode {
    VelocityTestAction vaction_ = null ;
    PowerTestAction paction_ = null ;

    public MotorCtrlTestModeAuto(MotorCtrlAutoController ctrl) throws Exception {
        super(ctrl, "MotorCtrl-Test-Mode");

        MotorCtrlRobotSubsystem robotsub = (MotorCtrlRobotSubsystem) ctrl.getRobot().getRobotSubsystem();
        TestMotorSubsystem testmotors = robotsub.getTestmotors() ;

        if (vaction_ == null)
            vaction_ = new VelocityTestAction(testmotors) ;

        if (paction_ == null)
            paction_ = new PowerTestAction(testmotors) ;

        switch (getTestNumber()) {
            //
            // Numbers 0 - 9 are for the driverbase
            //
            case 0:
                addSubActionPair(testmotors, paction_, true);
                break ;
            case 1:
                addSubActionPair(testmotors, vaction_, true);
                break ;     
        }
    }
}