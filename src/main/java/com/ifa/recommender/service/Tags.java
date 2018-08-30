package com.ifa.recommender.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class Tags {
	// static String[] vtype = { "309001-359002", "309002-359002", "309004-359002",
	// "309005-359001", "309005-359002", "309008-359002", "309009-359002",
	// "309012-359001",
	// "309014-359002", "309015-359001", "309016-359001", "309017-359001",
	// "309035-359002", "309036-359001", "309041-359001", "309041-359002" };
	// static String[] vtype2 = { "1", "2", "3" };
	// String[] age = {};
	// String[] year = { "0", "1", "2-3", "" };
	// static String[] address = { "11", "12", "13", "14", "15", "21", "22", "23",
	// "31", "32", "33", "34", "35", "36", "37", "41", "42", "43", "44", "45", "46",
	// "50","51", "52", "53", "54", "61", "62", "63", "64", "71", "81", "82" };

	static String[] vtype = { "家庭自用车", "机关、事业单位用车", "企业非营业车", "营业特种车", "非营业特种车", "摩托车", "拖拉机", "城市公交营业客车", "非营业货车", "营业货车", "出租、租赁", "公路营运", "非营业挂车", "营业挂车", "营业特种车挂车",
			"非营业特种车挂车" };
	static String[] vtype2 = { "个人	"};//, "机关", "企业" 
	static String[] ages = { "18-25岁", "26-35岁", "36-45岁", "46-50岁", "51-59岁", "60-90岁" };
	static String[] year = { "新车", "1年", "2-3年", "4-8年", "9-15年", "15年以上" };
	static String[] address = { "北京", "天津", "河北", "山西", "内蒙古", "辽宁", "吉林", "黑龙江", "上海", "江苏", "浙江", "安徽", "福建", "江西", "山东", "河南", "湖北", "湖南", "广东", "广西", "海南", "重庆",
			"四川", "贵州", "云南", "西藏", "陕西", "甘肃", "青海", "宁夏", "新疆", "台湾", "香港", "澳门" };
	
	static String[] products = { "yw", "jc", "cf", "zj", "zr"};//意外，家财，车服，重疾，责任


	public static void main(String[] args) {
		Set<String> tags = new TreeSet<>();
		Map<String, String> yw = new HashMap<>();
		Map<String, String> jc = new HashMap<>();
		Map<String, String> cf = new HashMap<>();
		Map<String, String> zj = new HashMap<>();
		Map<String, String> zr = new HashMap<>();
		for (int v2 = 0; v2 < vtype2.length; v2++) {// 车主性质
			for (int yeari = 0; yeari < year.length; yeari++) {// 车龄
				for (int age = 0; age < ages.length; age++) {// 年龄
					//for (int ad = 0; ad < address.length; ad++) {// 地区
						for (int vp = 0; vp < vtype.length; vp++) {
							/*String strvtype2 = vtype2[v2];
							String stryear= year[yeari];
							String strage=ages[age];
							String strvtype = vtype[vp];*/
							String tag = vtype2[v2] + " " + year[yeari] + " " + ages[age] + " "+ vtype[vp];// + address[ad] + " " 
							System.out.println(tag);
							if(!tag.contains("挂车")) {
								cf.put("cf", tag);
							}
							tags.add(tag);
						}
					//}
				}
			}
		}
		System.out.println(tags.size());
	}
}
