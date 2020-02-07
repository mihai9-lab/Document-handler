package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AboutDialog extends JDialog {
	
	public AboutDialog() {
		initialise();
	}
	
	private void initialise() {
		pack();
		Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 3, screenHeight / 2);
        setTitle("About");
        setLayout(new GridLayout(1,2));
        JLabel labelAleksa = new JLabel("Aleksa Milisavljević RN16/2018");
        JLabel labelMihailo = new JLabel("Mihailo Milićević RN13/2018");
        JPanel nameAleksa = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel nameMihailo = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameAleksa.add(labelAleksa);
        nameMihailo.add(labelMihailo);
        ImagePanel pictureAleksa = new ImagePanel("images/aleksa_slika.jpg");
        ImagePanel pictureMihailo = new ImagePanel("images/mihailo_slika.jpg");
        JPanel panelAleksa = new JPanel(new BorderLayout());
        JPanel panelMihailo = new JPanel(new BorderLayout());
        panelAleksa.add(pictureAleksa,BorderLayout.CENTER);
        panelMihailo.add(pictureMihailo,BorderLayout.CENTER);
        panelAleksa.add(nameAleksa,BorderLayout.SOUTH);
        panelMihailo.add(nameMihailo,BorderLayout.SOUTH);
        add(panelAleksa);
        add(panelMihailo);
        setLocationRelativeTo(Frame.getInstance());
	}
	
	class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		  }

		  public void paintComponent(Graphics g) {
		    g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
		    				 (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
		  }
	}
}
