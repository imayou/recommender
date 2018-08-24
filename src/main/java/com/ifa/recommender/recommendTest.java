package com.ifa.recommender;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.ifa.recommender.recommender.recommend;
import com.ifa.recommender.util.FileUtil;
import com.ifa.recommender.util.StringUtil;

/**
 * Created by legotime
 */
public class recommendTest {
	public static void main(String[] args) {
		// int[] a = {1,2,3,4};
		recommend rec = new recommend();
		String[] ps2 = {"0334", "033201", "036001", "036002", "036015", "036014", "036003", "036016", "036004", "036017", "036024", "036005", "036018", "036006", "036007",
				"036022", "036019", "036013", "036023", "036012", "036025", "036038", "036008", "036033", "036011", "036020", "036034", "036009", "036010", "036021",
				"036000", "036026", "036037", "036027" };
		
		List<String> lp = FileUtil.readLine("C:\\Users\\AYOU\\Desktop\\p.txt");
		String[] ps = new String[lp.size()];
		for (int i = 0; i < lp.size(); i++) {
			ps[i] = lp.get(i);
		}
		
		//String[] ps = { "0310", "0330", "0331", "0332", "0334", "0340", "0360", "0361", "0362", "0364" };
		String s = "01 02 03 04 14 15 16 17 24";
		/*String[] products = new String[1000];
		for (int ii = 0; ii < 1000; ii++) {
			int l = new Random().nextInt(16) + 10;
			// rand.nextInt(max - min + 1) + min;
			
			String[] pod = new String[l];
			for (int i = 0; i < l; i++) {
				int index = new Random().nextInt(ps.length);
				pod[i] = ps[index];
			}
			StringBuilder astr = new StringBuilder();
			pod = StringUtil.ifRepeat(pod);

			for (String string : pod) {
				astr.append(string + " ");
			}
			//System.err.println(astr.toString());
			products[ii] = astr.toString().substring(0, astr.length() - 1);
		}*/

		rec.fit(ps);
		double[] doubles = rec.recommendFun(s);
		List<String> list = new ArrayList<>(rec.getProduct());
		
		//System.out.println(Arrays.toString(doubles));
		//System.out.println(list);
		
		Map<Double, String> result = new HashMap<>();
		for (int i = 0; i < doubles.length; i++) {
			double k = doubles[i];
			if (k == 0) {
				k = Double.parseDouble(list.get(i));
			}
			result.put(k, list.get(i));
		}
		//return lhs.getName().compareTo(rhs.getName());
		//Stream.of(result).parallel().sort((a,b)->{return b.;});
		//result
		//Stream.of(result).filter((k)->{return k != null;}).collect((k)->Collectors.toMap(keyMapper, valueMapper));
		//result.entrySet().stream().sorted().collect((e)->Collectors.toMap(, v));
		//System.out.println(result);
		//result.entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue().reversed()).forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		/*System.out.println(result);
		result.forEach((k,v)->{
			System.err.println(k+"--"+v);
		});*/
		
		double[] d = StringUtil.bubbleSort(doubles);
		for (int i = 0; i < d.length; i++) {
			double k = d[i];
			if (k == 0) {
				k = Double.parseDouble(list.get(i));
			}
			System.out.println(d[i]+"--"+result.get(d[i]));
		}
	}
}