package dtree;

import java.io.File;
import java.io.IOException;

import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// Load the arff file and define the last feature as the class
		ArffLoader al = new ArffLoader();
		al.setFile(new File("sample1.arff"));
		Instances train = al.getDataSet();
		train.setClassIndex(train.numAttributes()-1);
		
		// launch the training
		Classifier cls = new Classifier();
		Tree dtree = cls.train(train);
		
		// print out the resulting tree
		System.out.println(dtree);
	}
}
