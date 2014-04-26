package com.wuxz.application.tool.changefilename;

import java.io.File;

public class ChangeFileName {
	private static final String PREFIX = "IMG_";
	
	public static void main(String[] args) {
		String dirName = "F:\\Canon\\";
		int index = 100000;
		File dir = new File(dirName);
		File[] files = dir.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			if(file.isFile()) {
				String newFileName = getNewFileName(file, index);
				System.out.println(newFileName);
				file.renameTo(new File(newFileName));
				index++;
			}
		}
	}

	private static String getNewFileName(File oldFile, int index) {
		String oldFileName = oldFile.getName();
		return new StringBuilder("F:\\Canon").append("\\").append(PREFIX).append(index).append(oldFileName.substring(oldFileName.indexOf("."), oldFileName.length())).toString();
	}
}
