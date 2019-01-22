//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.utils.threads;

import java.text.SimpleDateFormat;

public class Util {
	private static final String telco_vnp = "02";
	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
	private static String urlMnpCheck = "http://10.144.18.112/services/MNP_ONLY_MSISDN";

	public Util() {
	}

	public static void main(String[] args) {
		System.out.println(Util.standardizeMsisdn("84781200042"));
	}

	public static String standardizeMsisdn(String phoneNum) {
		if (phoneNum == null) {
			return phoneNum;
		} else {
			String result = "";
			if (phoneNum.startsWith("0")) {
				result = "84" + phoneNum.substring(1);
			} else if (phoneNum.startsWith("+84")) {
				result = phoneNum.substring(1);
			} else if (phoneNum.startsWith("84")) {
				result = phoneNum;
			} else {
				result = "84" + phoneNum;
			}

			return result;
		}
	}

}