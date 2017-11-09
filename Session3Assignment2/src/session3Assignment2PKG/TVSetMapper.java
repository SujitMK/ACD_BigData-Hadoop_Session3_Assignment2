package session3Assignment2PKG;

import org.apache.hadoop.io.*;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Mapper;

public class TVSetMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

   private final static NullWritable OutVal = NullWritable.get();
   private Text records = new Text();


   public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
	
 
  
	String tokens[] = value.toString().split("\\|");
	
	if(tokens[0].equals("NA") || tokens[1].equals("NA"))
	{
		System.out.println("Invalid Record " + tokens[0] + " and " + tokens[1]);
	
	}
	
	else
	{
		records.set(value);
		
		context.write(records, OutVal);
       		
	}
	
		 
  }

}