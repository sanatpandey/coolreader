/**
 * Copyright (C) 2009 Android OS Community Inc (http://androidos.cc/bbs).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.itcreator.android.reader.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Date Util
 * 
 * @author Wang XinFeng
 * @version  1.0
 * 
 */
public class DateUtil {
	
	public static String dateToString(Date d){
		Calendar calendar = Calendar.getInstance();
	//	calendar.setTime(d);
		StringBuilder sb= new StringBuilder();
		sb.append(calendar.get(Calendar.YEAR));
		sb.append("-");
		sb.append(calendar.get(Calendar.MONTH)+1);
		sb.append("-");
		sb.append(calendar.get(Calendar.DATE));
		sb.append(" ");
		sb.append(calendar.get(Calendar.HOUR_OF_DAY));
		sb.append(":");
		sb.append(calendar.get(Calendar.MINUTE));
		sb.append(":");
		sb.append(calendar.get(Calendar.SECOND));
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(dateToString(new Date(System.currentTimeMillis())));
	}
	
}
