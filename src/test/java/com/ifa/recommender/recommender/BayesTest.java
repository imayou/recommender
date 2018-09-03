package com.ifa.recommender.recommender;

import java.util.Arrays;

import de.daslaboratorium.machinelearning.classifier.Classification;
import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

public class BayesTest {
	public static void main(String[] args) {
		Classifier<String, String> bayes = new BayesClassifier<String, String>();

		// Two examples to learn from.
		String[] positiveText = "I love sunny days".split("\\s");
		String[] positiveText1 = "I kill hello days".split("\\s");
		String[] positiveText2 = "I hate suny days".split("\\s");
		String[] negativeText = "I hate rain".split("\\s");

		// Learn by classifying examples.
		// New categories can be added on the fly, when they are first used.a
		// A classification consists of a category and a list of features 
		// that resulted in the classification in that category.
		bayes.learn("positive", Arrays.asList(positiveText));
		bayes.learn("positive", Arrays.asList(positiveText1));
		bayes.learn("positive", Arrays.asList(positiveText2));
		bayes.learn("negative", Arrays.asList(negativeText));
		bayes.learn("negative", Arrays.asList(positiveText1));
		bayes.learn("negative", Arrays.asList(positiveText2));

		// Here are two unknown sentences to classify.
		String[] unknownText1 = "today is a sunny day".split("\\s");
		String[] unknownText2 = "there will be rain".split("\\s");

		Classification<String, String> classify1 = bayes.classify(Arrays.asList(unknownText1));
		Classification<String, String> classify2 = bayes.classify(Arrays.asList(unknownText2));
		
		System.err.println(classify1.getProbability());
		System.err.println(classify2.getProbability());
		System.out.println(classify1.getCategory()); // will output "positive"
		System.out.println(classify2.getCategory());// will output "negative"

		// Get more detailed classification result.
		((BayesClassifier<String, String>) bayes).classifyDetailed(Arrays.asList(unknownText1));

		// Change the memory capacity. New learned classifications (using
		// the learn method) are stored in a queue with the size given
		// here and used to classify unknown sentences.
		bayes.setMemoryCapacity(500);
	}
}
