

package com.tuan.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * IO utility methods.
 *
 * @author BruceSun
 */
public class IoUtils {

    

    /**
     * No exception InputStream close method.
     */
    public final static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (Exception ex) {
            }
        }
    }
    /**
     * No exception BufferedReader close method.
     */
    public final static void close(BufferedReader reader){
    	if(reader != null){
    		try{
    			reader.close();
    		}catch(Exception e){
    			
    		}
    	}
    }
    /**
     * No exception OutputStream close method.
     */
    public final static void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (Exception ex) {
            }
        }
    }
    /**
     * Copy an input stream to file.
     * @param input
     * @param dest
     * @throws IOException
     */
    public static void copy(InputStream input, File dest) throws IOException{
    	try {
    		if(!dest.exists()){
    			int dex = dest.getAbsolutePath().lastIndexOf(File.separator);
    			if(dex > 0){
    				File outFilePath = new File(dest.getAbsolutePath().substring(0,dex));
    				if(!outFilePath.exists())
    							outFilePath.mkdirs();
    			}
    			dest.createNewFile();
    		}
    		FileOutputStream fos = new FileOutputStream(dest);
            byte[] buf = new byte[4096];
            try {
                int byteRead;
                while ((byteRead = input.read(buf)) != -1) {
                    fos.write(buf, 0, byteRead);
                }
            } finally {
                fos.close();
            }
        } finally {
        	close(input);
        }
    }
    /**
     * Copy an input stream to output. If closed is true, close input.
     * @param input
     * @param output
     * @param closed
     * @throws IOException
     */
    public static void copy(InputStream input, OutputStream output , boolean closed) throws IOException{
    	try {
            byte[] buf = new byte[4096];
            int byteRead;
            while ((byteRead = input.read(buf)) != -1) {
            	output.write(buf, 0, byteRead);
             }
            output.flush();
        } finally {
        	if(closed){
        		close(input);
        	}
        	
        }
    }
    
    /**
     * 
     * @param in
     * @param charset
     * @return
     * @throws IOException
     */
    public static String pipe(InputStream in,String charset) throws IOException {
        StringBuffer s = new StringBuffer();
        if(charset==null||"".equals(charset)){
        	charset="utf-8";
        }
        String rLine = null;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(in,charset));
        while ( (rLine = bReader.readLine()) != null) {
            String tmp_rLine = rLine;
            int str_len = tmp_rLine.length();
            if (str_len > 0) {
              s.append(tmp_rLine);
            }
            tmp_rLine = null;
       }
        in.close();
        return s.toString();
	}
    
  
}
