package com.wuxz.application.tool.transmitdata;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class Server {

	public static void main(String[] args) throws IOException {
		System.out.println("args[0]=[" + args[0] + "]    args[1]=[" + args[1]
				+ "]");
		ServerSocket ss = new ServerSocket(10001);
		Socket s = ss.accept();
		InputStream is = s.getInputStream();
		File f = null;
		if (args.length > 0) {
			f = new File(args[0]);
		}
		if (!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(f);
		byte[] b = new byte[Integer.valueOf(args[1])];
		int length = 0;
		while ((length = is.read(b)) != -1) {
			System.out.println(length);
			fos.write(b, 0, length);
		}
		PrintStream ps = new PrintStream(s.getOutputStream());
		ps.write("文件已经传输完成！".getBytes(Charset.forName("GBK")));
		ps.close();
		s.close();
		ss.close();
	}

}
