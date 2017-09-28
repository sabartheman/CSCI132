

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;



import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class DrawSpace extends JComponent {

	// the Draw space is created form an Image.(all white)
	private Image image;
	// Graphics2D is the object used to draw on
	private Graphics2D g2;
	// helps with the mouse coordinates
	private int currentX, currentY, oldX, oldY, originalX, originalY;

	public DrawSpace() {
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				// save coordinates x,y when mouse in clicked
				oldX = e.getX();
				oldY = e.getY();
				originalX = e.getX();
				originalY = e.getY();
			}

			public void mouseReleased(MouseEvent e) {

				// switch to decide which direction user is dragging
				switch (shapeSelection) {
				case 1:
					//outline of oval method
					if (originalY < currentY && originalX > currentX) {
						g2.drawOval(currentX, originalY, originalX - currentX,
								currentY - originalY);
					} else if (originalY > currentY && originalX > currentX)
						g2.drawOval(currentX, currentY, originalX - currentX,
								originalY - currentY);
					else if (originalY < currentY && originalX < currentX)
						g2.drawOval(originalX, originalY, currentX - originalX,
								currentY - originalY);
					else
						g2.drawOval(originalX, currentY, currentX - originalX,
								originalY - currentY);
					repaint();
					break;
				case 2:
					//filled Oval method
					if (originalY < currentY && originalX > currentX) {
						g2.fillOval(currentX, originalY, originalX - currentX,
								currentY - originalY);
					} else if (originalY > currentY && originalX > currentX)
						g2.fillOval(currentX, currentY, originalX - currentX,
								originalY - currentY);
					else if (originalY < currentY && originalX < currentX)
						g2.fillOval(originalX, originalY, currentX - originalX,
								currentY - originalY);
					else
						g2.fillOval(originalX, currentY, currentX - originalX,
								originalY - currentY);
					repaint();
					break;
				case 3:
					//outline of rectangle method
					if (originalY < currentY && originalX > currentX) {
						g2.drawRect(currentX, originalY, originalX - currentX,
								currentY - originalY);
					} else if (originalY > currentY && originalX > currentX)
						g2.drawRect(currentX, currentY, originalX - currentX,
								originalY - currentY);
					else if (originalY < currentY && originalX < currentX)
						g2.drawRect(originalX, originalY, currentX - originalX,
								currentY - originalY);
					else
						g2.drawRect(originalX, currentY, currentX - originalX,
								originalY - currentY);
					repaint();
					break;
				case 4:
					//the filled oval method
					if (originalY < currentY && originalX > currentX) {
						g2.fillRect(currentX, originalY, originalX - currentX,
								currentY - originalY);
					} else if (originalY > currentY && originalX > currentX)
						g2.fillRect(currentX, currentY, originalX - currentX,
								originalY - currentY);
					else if (originalY < currentY && originalX < currentX)
						g2.fillRect(originalX, originalY, currentX - originalX,
								currentY - originalY);
					else
						g2.fillRect(originalX, currentY, currentX - originalX,
								originalY - currentY);
					repaint();
					break;
				case 5:
					//how to draw a line....
					g2.drawLine(originalX, originalY, currentX, currentY);
					repaint();
					break;

				}

			}

		});
		

		addMouseMotionListener(new MouseMotionAdapter() {

			public void mouseDragged(MouseEvent e) {
				// coordinates x,y from dragging the mouse to a new location
				currentX = e.getX();
				currentY = e.getY();

				if (shapeSelection == 0) {
					if (g2 != null) {
						// draw line if g2 context not null
						// straight line

						g2.drawLine(oldX, oldY, currentX, currentY);
						// refresh draw space to repaint
						repaint();
						// store current coords x,y as olds x,y
						oldX = currentX;
						oldY = currentY;
					}
				}

			}

		});
	}


	protected void paintComponent(Graphics g) {
		if (image == null) {
			// image created
			image = createImage(getSize().width, getSize().height);
			g2 = (Graphics2D) image.getGraphics();
			// enable analyzing pulled from google for fun i guess
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			// clear draw space
			clear();
		}
		g.drawImage(image, 0, 0, null);

	         
	         int width = getWidth();    // Width of the color palette
	         int height = getHeight();  // Height of the color palette
	         
	         // the spacing of the colors divided to assure the correct number of colors
	         int colorSpacing = (height - 56) / 7;
	         
	         //setting up the color palette background area and color for the colors being placed
	         g.setColor(Color.GRAY);
	         g.drawRect(0, 0, width-1, height-1);
	         g.drawRect(1, 1, width-3, height-3);
	         g.drawRect(2, 2, width-5, height-5);
	         
	        
	         g.fillRect(width - 60, 0, 60, height);      
	         

	         
	      // Draw the color as rectangles for the oh so pretty palette to the right of the program.
	         g.setColor(Color.BLACK);
	         g.fillRect(width-53, 3 + 0*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.RED);
	         g.fillRect(width-53, 3 + 1*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.GREEN);
	         g.fillRect(width-53, 3 + 2*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.BLUE);
	         g.fillRect(width-53, 3 + 3*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.CYAN);
	         g.fillRect(width-53, 3 + 4*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.MAGENTA);
	         g.fillRect(width-53, 3 + 5*colorSpacing, 50, colorSpacing-3);
	         g.setColor(Color.YELLOW);
	         g.fillRect(width-53, 3 + 6*colorSpacing, 50, colorSpacing-3);
	         
	         //border dimensions for the selected color
	         g.setColor(Color.WHITE);
	         g.drawRect(width-55, 1 + currColor*colorSpacing, 53, colorSpacing);
	         g.drawRect(width-54, 2 + currColor*colorSpacing, 51, colorSpacing-2);
	}
		

	public void clear() {
		g2.setPaint(Color.white);
		// draw white on entire draw space to simulate clearing or resetting
		g2.fillRect(0, 0, getSize().width, getSize().height);
		Stroke stroke = new BasicStroke(1f);
		g2.setPaint(Color.black);
		g2.setStroke(stroke);
		repaint();
	}
	
	//setColor method called by color palette button
	public void setTheColor(Color c){
		g2.setColor(c);
	}
	
	//save project method called by save dropdown in menu
	public void save(){
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("./"));
			if(chooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
				File fileName = new File(chooser.getSelectedFile() + ".png");
				RenderedImage rim = (RenderedImage) image;
				ImageIO.write(rim, "png", fileName);
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//open file option
	public void open(){
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.setCurrentDirectory(new File("./"));
			File fileName = new File(chooser.getSelectedFile() + ".png");
			if(chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
				FileImageInputStream newImage = new FileImageInputStream(fileName);
				image = ImageIO.read(newImage);
				repaint();
			}
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	
	int shapeSelection = 0;

	public void line() {
		//sets the line to be straight and not a free draw
		shapeSelection = 5;
	}
	
	public void freeDraw(){
		//free draw
		shapeSelection = 0;
		
	}
	public void oval() {
		// to draw the oval from the old coordinates to the new coordinates
		shapeSelection = 1;
		// g2.drawOval(originalX, currentY, currentX - originalX,
		// originalY-currentY);
	}

	public void filledoval() {
		// to draw a filled oval
		shapeSelection = 2;
		// g2.fillOval(originalX, currentY, currentX - originalX,
		// originalY-currentY);
	}

	public void rectangle() {
		shapeSelection = 3;
		// to draw a rectangle from the old coordinates to the new coordinates
		// g2.drawRect(originalX, currentY, currentX - originalX,
		// originalY-currentY);
	}

	public void filledrectangle() {
		// to draw a filled rectangle
		shapeSelection = 4;
		// g2.fillRect(originalX, currentY, currentX - originalX,
		// originalY-currentY);
	}
        public void setStrokeSize(float Bsize){
                shapeSelection = 0;
                Stroke stroke = new BasicStroke((Bsize));
                g2.getStroke();
                g2.setStroke(stroke);
                repaint();
        }

	public void strokesizesmall() {
		shapeSelection = 0;		//starting it out as the draw-line method
		Stroke stroke = new BasicStroke(1f);  //the normal size of the line 1 pixel
		g2.getStroke();
		g2.setStroke(stroke);
		repaint();
	}
	public void strokesizemed() {
		shapeSelection = 0;		//starting it out as the draw-line method
		Stroke stroke = new BasicStroke(5f);  //sets the line size to 5 pixels
		g2.getStroke();
		g2.setStroke(stroke);
		repaint();
	}
	public void strokesizelarge() {
		shapeSelection = 0;		//starting it out as the draw-line method
		Stroke stroke = new BasicStroke(10f); //sets the line size to 10 pixels
		g2.getStroke();
		g2.setStroke(stroke);
		repaint();
	}

	public void erase() {
		// erasing method
		shapeSelection = 0;
		Stroke stroke = new BasicStroke(10f);
		g2.setPaint(Color.white);
		g2.setStroke(stroke);
		repaint();
	}
	
	//adds entered text starting at location of current selection X and Y coordinates
	public void text(String s){
		//text method
		
		char [] abc = s.toCharArray();
		g2.drawChars(abc, 0, abc.length, currentX, currentY);
		
		repaint();
	}
	
	public void rotate(){
		
		g2.rotate(Math.toRadians(90));
		
                repaint();
	}
		
	private final static int BLACK = 0,RED = 1,GREEN = 2, BLUE = 3, //all colors needed
							 CYAN = 4, MAGENTA = 5,YELLOW = 6;		//for the case statements

	private int currColor = BLACK; 
	//setting the initial color to black
	public void color(int y) {
         
         int width = getWidth();           // Width 
         int height = getHeight();         // Height 
         int colorSpacing = (height - 56) / 7;  // the spacing of the colors
         int newColor = y / colorSpacing;       // determines which color was clicked
         
         if (newColor < 0 || newColor > 6)      //corresponding number of colors 
        	 									//0 through 6 making a total of 7
            return;
         
         Graphics g = getGraphics();
         g.setColor(Color.GRAY);			//color of border
         g.drawRect(width-55, 1 + currColor*colorSpacing, 53, colorSpacing);
         g.drawRect(width-54, 2 + currColor*colorSpacing, 51, colorSpacing-2);
         currColor = newColor;
         g.setColor(Color.WHITE);			//selected color border
         g.drawRect(width-55, 1 + currColor*colorSpacing, 53, colorSpacing);
         g.drawRect(width-54, 2 + currColor*colorSpacing, 51, colorSpacing-2);
         g.dispose();
         
      } 
	public void colorPalette(MouseEvent e) { 
		//tracking the mouse clicking events
	     
	     switch (currColor) {
	     case BLACK:
	    	 //case statements to set the color being used
	        g2.setColor(Color.BLACK);
	        break;
	     case RED:
	        g2.setColor(Color.RED);
                System.out.println("red has been chosen");
	        break;
	     case GREEN:
	        g2.setColor(Color.GREEN);
	        break;
	     case BLUE:
	        g2.setColor(Color.BLUE);
	        break;
	     case CYAN:
	        g2.setColor(Color.CYAN);
	        break;
	     case MAGENTA:
	        g2.setColor(Color.MAGENTA);
	        break;
	     case YELLOW:
	        g2.setColor(Color.YELLOW);
	        break;
	     }
	     g2.getColor();
             repaint();
	  }
	}


