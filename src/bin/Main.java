package bin;

import java.awt.Color;

import de.informatics4kids.Picture;
import de.informatics4kids.PictureViewer;

public class Main {
	
	static void SaveShit(String filepath) {
		Picture picture = new Picture(filepath);

		for (int i = 0; i < picture.widthX(); i++) {
			for (int j = 0; j < picture.heightY(); j++) {
				picture.setColor(i, j, picture.getColor(i, j));
				if (((int) (0.3 * picture.getColor(i, j).getRed() + 0.59 * picture.getColor(i, j).getGreen()
						+ 0.11 * picture.getColor(i, j).getBlue())) <= 150) {
					picture.setColor(i, j, Color.BLACK);
				} else
					picture.setColor(i, j, Color.WHITE.darker());
			}
		}
		
		picture.save("picture.png");
	}
	

	public static void main(String[] args) {

		Picture pic = new Picture("src/picture.png");
		Picture pic2 = new Picture(pic.widthX()*2,pic.heightY()*2);
		Picture pic3 = new Picture(pic.widthX()*2,pic.heightY()*2);
		

		
		
		
		
		for (int i = 0; i < pic.widthX()*2; i+=2) {
			for (int j = 0; j < pic.heightY()*2; j+=2) {
				if(pic.getColor(i/2, j/2).getGreen()>=155) {
				
					
					
				if(Math.random()>=0.5) {
					pic2.setColor(i+0, j+0, Color.WHITE);
					pic2.setColor(i+1, j+0, Color.BLACK);
					pic2.setColor(i+0, j+1, Color.WHITE);
					pic2.setColor(i+1, j+1, Color.BLACK);
					
					pic3.setColor(i+0, j+0, Color.WHITE);
					pic3.setColor(i+1, j+0, Color.BLACK);
					pic3.setColor(i+0, j+1, Color.WHITE);
					pic3.setColor(i+1, j+1, Color.BLACK);
				} else {
					pic2.setColor(i+0, j+0, Color.BLACK);
					pic2.setColor(i+1, j+0, Color.WHITE);
					pic2.setColor(i+0, j+1, Color.BLACK);
					pic2.setColor(i+1, j+1, Color.WHITE);
					
					pic3.setColor(i+0, j+0, Color.BLACK);
					pic3.setColor(i+1, j+0, Color.WHITE);
					pic3.setColor(i+0, j+1, Color.BLACK);
					pic3.setColor(i+1, j+1, Color.WHITE);
				}
				
			} else if(pic.getColor(i/2, j/2).getGreen()<155) {
				
				if(Math.random()>0.5) {
					pic2.setColor(i+0, j+0, Color.WHITE);
					pic2.setColor(i+1, j+0, Color.BLACK);
					pic2.setColor(i+0, j+1, Color.WHITE);
					pic2.setColor(i+1, j+1, Color.BLACK);
					
					pic3.setColor(i+0, j+0, Color.BLACK);
					pic3.setColor(i+1, j+0, Color.WHITE);
					pic3.setColor(i+0, j+1, Color.BLACK);
					pic3.setColor(i+1, j+1, Color.WHITE);
				} else {
					pic2.setColor(i+0, j+0, Color.BLACK);
					pic2.setColor(i+1, j+0, Color.WHITE);
					pic2.setColor(i+0, j+1, Color.BLACK);
					pic2.setColor(i+1, j+1, Color.WHITE);
					
					pic3.setColor(i+0, j+0, Color.WHITE);
					pic3.setColor(i+1, j+0, Color.BLACK);
					pic3.setColor(i+0, j+1, Color.WHITE);
					pic3.setColor(i+1, j+1, Color.BLACK);
				}
				
			}
				
			
			}
		}
		
		
		
		pic2.save("1.png");
		pic3.save("2.png");

		Picture overmapped = new Picture(pic2.widthX(),pic2.heightY());

		for (int i = 0; i < overmapped.widthX(); i++) {
			for (int j = 0; j < overmapped.heightY(); j++) {
				int skin = pic2.getColor(i,j).getRed()+pic3.getColor(i,j).getRed();

				if (skin>255) {
					skin = 255;
				}
				overmapped.setColor(i, j, new Color(skin, skin, skin));

			}
		}

		PictureViewer show = new PictureViewer(overmapped.getPicture());
		show.show();
	}

}
