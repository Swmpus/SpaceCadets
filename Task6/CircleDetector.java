import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

class CircleDetector 
{
	private ImageIcon imageIcon;
	private BufferedImage grey;

	public CircleDetector()
	{
		try {
    		imageIcon = new ImageIcon("Apple.jpg");
		} catch (Exception e) {
			System.out.println("Error loading image");
		}
		try{
    		grey = BufferedImage(ImageIO.read(new File("Apple.jpg")), BufferedImage.TYPE_BYTE_GRAY);
		} catch(Exception e){e.printStackTrace();

		}
		//grey = new BufferedImage(imageIcon.getIconWidth(), imageIcon.getIconHeight(), BufferedImage.TYPE_BYTE_GRAY);

		grey.creatGraphics();
	}

	public ImageIcon GetImageIcon() 
	{
		return imageIcon;
	}

	public BufferedImage GetImageGrey() 
	{
		return grey;
	}
}