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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * object operation util
 * 
 * @author Wang Baoxi
 * @version 1.0
 */
public class ObjectUtil {
	
	/**object output stream*/
	private ObjectOutputStream mObjectOutputStream = null;
	
	/**object input stream*/
	private ObjectInputStream mObjectInputStream = null;
	
	/**the file path*/
	private String filePath;

	/**
	 * 
	 * @param filePath
	 *            file path  when read a object or save object file
	 */
	public ObjectUtil(String filePath) {
		this.filePath = filePath;

	}

	/**
	 * save object to file
	 * 
	 * @param o
	 *            a object u wanna save
	 * @return if save successful ,return true ,otherwise false
	 */
	public boolean saveToFile(Object o) {

		boolean flag = true;
		try {
			mObjectOutputStream = new ObjectOutputStream(new FileOutputStream(
					filePath));
			mObjectOutputStream.writeObject(o);
			mObjectOutputStream.flush();
			mObjectOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	/**
	 * read a file to java object
	 * @return the java object
	 */
	public Object fileToObject() {
		Object ob = null;
		try {
			mObjectInputStream = new ObjectInputStream(new FileInputStream(
					filePath));
			ob = mObjectInputStream.readObject();
			mObjectInputStream.close();
		} catch (IOException e) {

			ob = null;
		} catch (ClassNotFoundException e) {
			ob = null;
		}

		return ob;
	}

	
}
