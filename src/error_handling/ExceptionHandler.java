package error_handling;

import javax.swing.JOptionPane;

public class ExceptionHandler implements IExceptionHandler {
	
	public void handleException(String s) {
		Exception e = ExceptionFactory.createException(s);
		e.printStackTrace();
		JOptionPane.showMessageDialog(gui.Frame.getInstance(), e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
	}
}
