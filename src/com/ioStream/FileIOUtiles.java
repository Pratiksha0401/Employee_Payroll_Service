package com.ioStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileIOUtiles {
	
	//check isExist
	public void isExist(String path) {
		File file = new File(path);
		if(file.exists())
		System.out.println("File Exist");
		else 
		System.out.println("File does not Exist");
	}
	
	//create folder
	public void createFolder(String path) {
		File myFolder = new File(path);
		if(!myFolder.exists()) {
			myFolder.mkdirs();
			System.out.println(path+" Folder created !");
		}
		else
			System.out.println(path+ " Folder already exist !");
	}
	
	//delete folder
	public void deleteFolder(String dir) throws IOException {
		File myFolder = new File(dir);
		String pathDir=myFolder.getAbsolutePath();
		System.out.println(pathDir);
		Path path= Paths.get(pathDir);
		try {
            Files.delete(path);
            System.out.println(path+" Folder Deleted successfully !");
        } catch (IOException e) {
            System.out.println(path + " Folder does not exits !");
            e.printStackTrace();
        }
	}
	
	//create file
	public void createFile(String path) {
		File myFile = new File(path);
		try {
            myFile.createNewFile();
            System.out.println(path+" File created successfully !");
        } catch (IOException e) {
            System.out.println(path + " Unable to create this file");
            e.printStackTrace();
        }
	}
	
	//delete file
	public void deleteFile(String path) {
		File myFile = new File(path);
		if(myFile.delete()){
            System.out.println( myFile.getName()+" File Deleted ! ");
        }
        else{
            System.out.println("Some problem occurred while deleting the file or file may not exist");
        }
	}
	
	//write to file
	public void writeTOFile(String path) {
		try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write("This is our first file from this java course");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	//read from file
	public void readFromFile(String path) {
	File myFile = new File(path);
    try {
        Scanner sc = new Scanner(myFile);
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
	}
}