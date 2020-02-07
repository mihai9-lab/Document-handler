package configuration;

import actions.AbstractIconAction;
import observer.interfaces.IObserver;

public interface IConfigurations extends IObserver {
	
	public Boolean isActionInToolbar(AbstractIconAction a);
	
	public void setActionInToolbar(AbstractIconAction a,Boolean t);
	
	public void setMinipageScalingCoef(double minipageScalingCoef);
	
	public double getMinipageScalingCoef();
	
}
