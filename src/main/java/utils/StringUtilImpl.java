package main.java.utils;

public class StringUtilImpl implements StringUtil {

	@Override
	public boolean isNullOrBlank(String target) {
		return target == null || target.trim().length() == 0;
	}

}
