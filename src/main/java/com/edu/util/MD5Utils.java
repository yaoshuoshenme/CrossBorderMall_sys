package com.edu.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//MD5 ������
public class MD5Utils {
	public static String md5(String password){
		//����һ��md5������
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			//����MD5 ��ֵ
			md.update(password.getBytes());
			//BigInteger ��8λ���ַ��� ת��16λ���ַ��� �õ����ַ�����ʽ�ǹ�ϣ��ֵ
			//BigInteger(����1,����2) ����1 �� 1Ϊ���� 0Ϊ0 -1Ϊ����
			return new BigInteger(1, md.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
