package lettercraze.controller.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ResetDataController implements ActionListener{

	public ResetDataController (){}
	
	public void actionPerformed(ActionEvent act) {
		File source = new File("default_levels_original");
		File destination = new File("default_levels");
		
		try {
		    FileUtils.copyDirectory(source, destination);
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
}
