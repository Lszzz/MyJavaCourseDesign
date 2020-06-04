package vehicleleasing.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lszzz
 * @create 2020/6/4
 */
public class Test {
	public static void main(String []args)
	{
		String info="2BG3C ±¦Âí7Ïµ5×ù 400 0";
		String regex="([0-9A-Za-z]{5})\\s(.*)\\s([\\d]{0,})\\s([0,1]{1})";
		Pattern p=Pattern.compile(regex);
		Matcher matcher=p.matcher(info);
		if(matcher.find())
		{
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println(matcher.group(3));
			System.out.println(matcher.group(4));
		}

	}
}
