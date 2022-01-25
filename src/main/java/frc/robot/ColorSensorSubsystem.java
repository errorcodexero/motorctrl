package frc.robot;

import com.revrobotics.ColorSensorV3;
import org.xero1425.base.Subsystem;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.util.Color;

public class ColorSensorSubsystem extends Subsystem {
    ColorSensorV3 sensor_ ;
    Color color_ ;
    boolean connected_ ;
    
    public ColorSensorSubsystem(Subsystem parent, String name) {
        super(parent, name) ;

        sensor_ = new ColorSensorV3(Port.kOnboard) ;
    }

    @Override
    public void computeMyState() {
        connected_ = sensor_.isConnected();
        putDashboard("ColorConnected", DisplayType.Always, connected_);
        if (connected_)
        {
            color_ = sensor_.getColor() ;

            putDashboard("Red", DisplayType.Always, color_.red) ;
            putDashboard("Green", DisplayType.Always, color_.green) ;
            putDashboard("Blue", DisplayType.Always, color_.blue) ;
        }       
    }
}
