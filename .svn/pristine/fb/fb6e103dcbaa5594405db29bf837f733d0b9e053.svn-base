package gui.listeners.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class MinipageSizeActionListener  implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Double t = new Double(((JTextField)(arg0.getSource())).getText());
			if(t<0 || t>1) {
				gui.Frame.getInstance().getExceptionHandler().handleException("invalid_minipage_size");
			}
			else {
				gui.Frame.getInstance().getIConfigurations().setMinipageScalingCoef(t);
			}
		}
		catch(Exception e) {
			gui.Frame.getInstance().getExceptionHandler().handleException("invalid_minipage_size");
		}
	}
}
