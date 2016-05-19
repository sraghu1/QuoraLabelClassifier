package classifier.core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import textutils.PorterStemmer;
import textutils.StopwordAnalyzer;
public class QuoraLabelClassifyMain {

	private int numTraining;
	private int numTesting;
	private PorterStemmer stemmer;
	private StopwordAnalyzer analyzer;
	public QuoraLabelClassifyMain() {
		// TODO Auto-generated constructor stub
	stemmer=new PorterStemmer();
	analyzer=new StopwordAnalyzer();
	}
	
	
	public static void main(String args[])
	{
		//Read the input file
		QuoraLabelClassifyMain qlcm=new QuoraLabelClassifyMain();
		qlcm.classify(args[0]);
		
	}
	
	public void classify(String pathToInput)
	{
		//read the training Data
		try{
			BufferedReader reader=new BufferedReader(new FileReader(pathToInput));
			readTraining(reader);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void readTraining(BufferedReader reader) throws IOException
	{
		String line=reader.readLine();
		String parts[]=line.split(" ");
		numTraining=Integer.parseInt(parts[0]);
		numTesting=Integer.parseInt(parts[1]);
		
		for(int i=0;i<numTraining;i++)
		{
			String trainingQuestion=reader.readLine();
			trainingQuestion=analyzer.removeStopWords(trainingQuestion);
			String[] words=trainingQuestion.split(" ");
			StringBuilder sb=new StringBuilder();
			for(String w:words)
			{
				sb.append(stemmer.stem(w)+" ");
			}
			trainingQuestion=sb.toString().trim();
			String classString=reader.readLine();
			
		}
		
		
	}
	
	public void readTest(){
		
	}

}
