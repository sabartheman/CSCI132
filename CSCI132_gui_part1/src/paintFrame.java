import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class paintFrame {
	// the buttons used
	JButton clearBtn, medsizeBtn, eraseBtn, sizeBtn, largesizeBtn,
                filledovalBtn, ovalBtn, filledrectangleBtn, textBtn,
                rectangleBtn, rotateBtn, lineBtn, freeDrawBtn, colorBtn,brushSBtn;
        
        //for defining the size of the brush
        JTextField brushSize;
        float BrushSize;
        
        //
	DrawSpace drawSpace;

	ActionListener actionListener = new ActionListener() {

		public void actionPerformed(ActionEvent e) { // defining the button

														// actions
			if (e.getSource() == clearBtn) {
				drawSpace.clear();


			} else if (e.getSource() == lineBtn) {
				drawSpace.line();
			} else if (e.getSource() == freeDrawBtn) {

				drawSpace.freeDraw();
			} else if (e.getSource() == filledovalBtn) {
				drawSpace.filledoval();
			} else if (e.getSource() == ovalBtn) {
				drawSpace.oval();
			} else if (e.getSource() == filledrectangleBtn) {
				drawSpace.filledrectangle();
			} else if (e.getSource() == rectangleBtn) {
				drawSpace.rectangle();
			} else if (e.getSource() == sizeBtn) {
				drawSpace.strokesizesmall();
			} else if (e.getSource() == medsizeBtn) {
				drawSpace.strokesizemed();
			} else if (e.getSource() == largesizeBtn) {
				drawSpace.strokesizelarge();
			}else if(e.getSource() == brushSize){
                                BrushSize = Float.valueOf(brushSize.getText());
                                drawSpace.setStrokeSize(BrushSize);
                        }else if (e.getSource() == eraseBtn) {
				drawSpace.erase();
			} else if (e.getSource() == textBtn) {
				//prompts user for string input to put onto canvas
				JLabel lbl = new JLabel();
				
				String s = JOptionPane.showInputDialog(lbl, "Enter text", null);
				drawSpace.text(s);

			} else if (e.getSource() == colorBtn) {

				Color c = JColorChooser.showDialog(null, "Choose a Color",
						Color.RED);
				drawSpace.setTheColor(c);

			}else if(e.getSource() == rotateBtn){

				drawSpace.rotate();

			}
		}
                
        
        };

	public static void main(String[] args) {
		new paintFrame().show();
	}

	public void show() {
		// create main frame
		JFrame frame = new JFrame("Paint");

		Container content = frame.getContentPane();
		// set layout on content panel
		content.setLayout(new BorderLayout());
		// create draw area
		drawSpace = new DrawSpace();
		//setting up the menu bar

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menu = new JMenuBar();
		
		//file button needed
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		menu.add(file);
		JMenuItem start = new JMenuItem("New", KeyEvent.VK_N);
		JMenuItem save = new JMenuItem("Save", KeyEvent.VK_K);
		JMenuItem open = new JMenuItem("Open", KeyEvent.VK_K);
		//random extra button to assure drop down menu works
		
		//edit button required
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_F);
		menu.add(edit);
		JMenuItem item = new JMenuItem("Rotate", KeyEvent.VK_W);
		//random extra button to assure drop down menu works
		
		//choices button required
		JMenu choices = new JMenu("Choices");
		choices.setMnemonic(KeyEvent.VK_F);
		menu.add(choices);
		JMenuItem items = new JMenuItem("Stuff", KeyEvent.VK_Y);
		//random extra button to assure drop down menu works
		
		//help button required
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_F);
		menu.add(help);
		JMenuItem mitem = new JMenuItem("About", KeyEvent.VK_Z);
		//dropdown menu buttons
                file.add(start);
                file.add(save);
                file.add(open);
                edit.add(item);
                choices.add(items);
                help.add(mitem);
////////////////////////////////////////////////////////////////////////////////////////////////
		
		save.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				drawSpace.save();
			}
			
		});
		open.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				drawSpace.open();
			}
		});
		
		//adds action listener and displays JLabel picture
		mitem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				JLabel lbl = new JLabel(new ImageIcon("logo.jpg"));
				JOptionPane.showMessageDialog(null, lbl,"Logo", JOptionPane.PLAIN_MESSAGE, null);
				
			}
		});
		// add to content pane

		content.add(drawSpace, BorderLayout.CENTER);
		// create controls to apply colors and call clear feature
		JPanel controls = new JPanel();
		// setting up the buttons for the paint program
//////////////////////////////////////////////////////////////////////                
		clearBtn = new JButton("Clear");                
		clearBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
		lineBtn = new JButton();
		//creating a image to put on top of the button.
		BufferedImage li = new BufferedImage(50,50,2);
		Graphics2D lc = li.createGraphics();
		lc.setColor(Color.black);
		lc.drawLine(10,10,40,40);
		ImageIcon lii = new ImageIcon(li);
		lineBtn.setIcon(lii);
		lineBtn.setToolTipText("Line");
		lineBtn.setOpaque(false);
		lineBtn.setBorderPainted(false);
		lineBtn.setContentAreaFilled(false);
		lineBtn.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////                
		freeDrawBtn = new JButton("FreeDraw");
		freeDrawBtn.setToolTipText("Free Draw");
		freeDrawBtn.setOpaque(false);
		freeDrawBtn.setBorderPainted(true);
		freeDrawBtn.setContentAreaFilled(true);
		freeDrawBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
                filledovalBtn = new JButton();
		//creating a image to put on top of the button.
		BufferedImage foi = new BufferedImage(50,50,2);
		Graphics2D foc = foi.createGraphics();
		foc.setColor(Color.black);
		foc.fillOval(10,10,30,30);
		ImageIcon foii = new ImageIcon(foi);
		filledovalBtn.setIcon(foii);

		filledovalBtn.setToolTipText("Filled oval");
		filledovalBtn.setOpaque(false);
		filledovalBtn.setBorderPainted(false);
		filledovalBtn.setContentAreaFilled(false);
		filledovalBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
		ovalBtn = new JButton();
		BufferedImage ovi = new BufferedImage(50,50,2);
		Graphics2D ovc = ovi.createGraphics();
		ovc.setColor(Color.black);
		ovc.drawOval(10,10,30,30);
		ImageIcon ovii = new ImageIcon(ovi);
		ovalBtn.setIcon(ovii);
		ovalBtn.setToolTipText("Empty oval");
		ovalBtn.setOpaque(false);
		ovalBtn.setBorderPainted(false);
		ovalBtn.setContentAreaFilled(false);
		ovalBtn.addActionListener(actionListener);
		
                
//////////////////////////////////////////////////////////////////////                
		filledrectangleBtn = new JButton();
		BufferedImage fri = new BufferedImage(50,50,2);
		Graphics2D frc = fri.createGraphics();
		frc.setColor(Color.black);
		frc.fillRect(10,10,30,30);
		ImageIcon frii = new ImageIcon(fri);
		filledrectangleBtn.setIcon(frii);
		filledrectangleBtn.setToolTipText("Filled rectangle");
		filledrectangleBtn.setOpaque(false);
		filledrectangleBtn.setBorderPainted(false);
		filledrectangleBtn.setContentAreaFilled(false);
		filledrectangleBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
		rectangleBtn = new JButton();
		BufferedImage dri = new BufferedImage(50,50,2);
		Graphics2D drc = dri.createGraphics();
		drc.setColor(Color.black);
		drc.drawRect(10,10,30,30);
		ImageIcon drii = new ImageIcon(dri);
		rectangleBtn.setIcon(drii);
		rectangleBtn.setToolTipText("Empty rectangle");
		rectangleBtn.setOpaque(false);
		rectangleBtn.setBorderPainted(false);
		rectangleBtn.setContentAreaFilled(false);
		rectangleBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
                eraseBtn = new JButton("Erase");
		eraseBtn.addActionListener(actionListener);
                

//////////////////////////////////////////////////////////////////////                
                brushSize = new JTextField();
                brushSize.setColumns(1);
                brushSize.setSize(10, 100);
                brushSize.addActionListener(actionListener);
                
                
//////////////////////////////////////////////////////////////////////                
		sizeBtn = new JButton("Brush(small)");
		sizeBtn.addActionListener(actionListener);
		medsizeBtn = new JButton("Brush(medium)");
		medsizeBtn.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////                
		largesizeBtn = new JButton("Brush(large)");
		largesizeBtn.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////                
		rotateBtn = new JButton("Rotate");
		rotateBtn.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////                
		textBtn = new JButton("Text");
		textBtn.addActionListener(actionListener);
//////////////////////////////////////////////////////////////////////                
                brushSBtn = new JButton("BrushSize:");
                brushSBtn.setBorderPainted(false);
                brushSBtn.setContentAreaFilled(false);

//////////////////////////////////////////////////////////////////////                
		colorBtn = new JButton("Color");
		colorBtn.addActionListener(actionListener);
		
//////////////////////////////////////////////////////////////////////                
//////////////////////////////////////////////////////////////////////                
                ////all the shape buttons
                controls.add(lineBtn);
		controls.add(filledovalBtn);
		controls.add(ovalBtn);
		controls.add(filledrectangleBtn);
		controls.add(rectangleBtn);



                //the buttons to change brushsize and other things
                controls.add(brushSBtn);
		controls.add(brushSize);
		controls.add(freeDrawBtn);
                controls.add(textBtn);
		controls.add(rotateBtn);
		controls.add(colorBtn);
		controls.add(eraseBtn);
                controls.add(clearBtn);




		// add to content panel/                
		content.add(controls, BorderLayout.NORTH);
		frame.setSize(2000, 2000);
		frame.setJMenuBar(menu);
                frame.setVisible(true);
		// close frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// show the swing paint result
		frame.setVisible(true);
	}

}