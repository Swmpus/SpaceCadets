import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Image;

class ImageHelper 
{
	/*
	public static void Show(ImageIcon toShow) 
	{
  		JFrame frame = new JFrame();

		frame.add(new JLabel(toShow));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
 	}
	*/
	public static void Show(BufferedImage toShow) 
	{
  		JFrame frame = new JFrame();

		frame.add(new JLabel(new ImageIcon(toShow)));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
 	}

 	public static BufferedImage ConvertToGreyScale(Image input) 
 	{
 		for (int y = 0; y < height; y++) {
  			for (int x = 0; x < width; x++) {
  				int p = img.getRGB(x,y);
				int a = (p>>24)&0xff;
				int r = (p>>16)&0xff;
				int g = (p>>8)&0xff;
				int b = p&0xff;

				int avg = (r+g+b)/3;

				p = (a<<24) | (avg<<16) | (avg<<8) | avg;
				img.setRGB(x, y, p);
  			}
		}
 	}
}