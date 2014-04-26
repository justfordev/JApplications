package com.wuxz.application.tool.transmitdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		File f = new File(args[0]);
		Socket s = new Socket("192.168.1.110", 10000);
		OutputStream os = s.getOutputStream();
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[Integer.valueOf(args[1])];
		int length = 0;
		while((length = fis.read(b)) != -1) {
			System.out.println(length);
			os.write(b, 0, length);
		}
		s.shutdownOutput();
		while(!s.isClosed()) {
			Thread.sleep(1000);
		}
		fis.close();
	}

}
