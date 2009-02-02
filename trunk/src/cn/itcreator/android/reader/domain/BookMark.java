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
package cn.itcreator.android.reader.domain;

import java.io.Serializable;


/**
 * This class for book mark 
 * @author SinFrancis
 * @version 1.0
 *
 */
public class BookMark implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7887363738929016732L;
	/**the offset in file*/
	private int currentOffset=0;
	/**book mark name*/
	private String markName="";
	/**Êé¼®µÄID*/
	private int bookId = 0;
	
	private int bookMarkId = 0;
	
	private String saveTime = "0000-00-00 00:00:00";
	
	public BookMark() {
	}
	public BookMark(int offset,String markName,int bookId){
		this.currentOffset=offset;
		this.markName = markName;
		this.bookId = bookId;
	}
	
	public int getCurrentOffset() {
		return currentOffset;
	}
	public void setCurrentOffset(int currentOffset) {
		this.currentOffset = currentOffset;
	}
	public String getMarkName() {
		return markName;
	}
	public void setMarkName(String markName) {
		this.markName = markName;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getBookMarkId() {
		return bookMarkId;
	}
	public void setBookMarkId(int bookMarkId) {
		this.bookMarkId = bookMarkId;
	}
	
	public String getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}
	@Override
	public String toString() {
		return markName + "   "+saveTime;
	}
	
}
