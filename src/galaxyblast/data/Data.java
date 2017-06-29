package galaxyblast.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import galaxyblast.GalaxyAbduction;

public class Data {
	
	public Data(){
		
	}
	
	public void loadFile(String filePath){
		File inputFile;
		BufferedReader inputReader;
		
		try {
			inputFile = new File(filePath);
			inputReader = new BufferedReader(new FileReader(inputFile));
			int id = inputReader.readLine().length();
			GalaxyAbduction.textures = id;
			inputReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(String filePath){
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			if(filePath == "assets/game.txt"){
				System.out.println("Created Game Data");
				if(GalaxyAbduction.textures == 1){
					outputWriter.write("i");
				}else if(GalaxyAbduction.textures == 2){
					outputWriter.write("ii");
				}
				else if(GalaxyAbduction.textures == 3){
					outputWriter.write("iii");
				}
			}
			if(filePath == "assets/playerdata.txt"){
				System.out.println("Created Player Data");
			}
			//outputWriter.write(GalaxyAbduction.score);
			outputWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void writeDataFile(String filePath, String data){
		File outputFile;
		BufferedWriter outputWriter;
		
		try {
			outputFile = new File(filePath);
			
			outputWriter = new BufferedWriter(new FileWriter(outputFile));
			if(filePath == "assets/data.vmj"){
				System.out.println("Created Game Data");
				outputWriter.write(data);
			}
			//outputWriter.write(GalaxyAbduction.score);
			outputWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
