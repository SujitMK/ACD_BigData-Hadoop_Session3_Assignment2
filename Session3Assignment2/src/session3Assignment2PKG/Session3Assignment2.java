package session3Assignment2PKG;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;

public class Session3Assignment2 {

	public static void main(String[] args) throws Exception{
		
		if (args.length != 2 )
		
		{ 
			  System.err.println("usage : TV_SetMapper <input path> <output path>") ;
			  System.exit(-1);
		}
		  
		
		Configuration conf =new Configuration(); 
		  @SuppressWarnings("deprecation")
		  
		Job job = new Job(conf, "");
		job.setJarByClass(Session3Assignment2.class);
		  
		FileInputFormat.setInputPaths(job, args[0]);
		Path outputPath = new Path(args[1]);
		  
		FileOutputFormat.setOutputPath(job, outputPath);
		outputPath.getFileSystem(conf).delete(outputPath, true);
		  
		job.setMapperClass(TVSetMapper.class);
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(NullWritable.class);
		job.setNumReduceTasks(0);
		  
		  //execute the job
		 System.exit(job.waitForCompletion(true)? 0 : 1);
		  
		  
		  
	}

}
