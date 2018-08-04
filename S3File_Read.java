package com.amazonaws.samples;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.GetObjectRequest;
import java.io.*;

public class S3File_Read {

	//buckname= S3 Bucket Name
	private static String buckname ="logbucktes1";
	
	//key= Path of the S3 file
	private static String key = "Doc/TestDoc";
		public static void main(String arg[]) throws IOException
		{
			AmazonS3 aS3 =new AmazonS3Client(new ProfileCredentialsProvider());
			try
			{
				S3Object s3Obj = aS3.getObject(new GetObjectRequest(buckname, key));
				displayTextInputStream(s3Obj.getObjectContent());
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	    private static void displayTextInputStream(InputStream input)
	    throws IOException {
	    	// Read one text line at a time and display.
	        BufferedReader reader = new BufferedReader(new 
	        		InputStreamReader(input));
	        while (true) {
	            String line = reader.readLine();
	            if (line == null) break;

	            System.out.println("    " + line);
	        }
	        System.out.println();
	    }
}