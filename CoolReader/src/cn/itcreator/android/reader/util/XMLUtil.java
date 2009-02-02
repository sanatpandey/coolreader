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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import cn.itcreator.android.reader.domain.BookMark;
import cn.itcreator.android.reader.paramter.Constant;

import android.util.Log;

/**
 * For xml type file tools
 * 
 * @author SinFrancis
 * @version 1.0
 * 
 */
public class XMLUtil {

	private String mFilePath;// xml file path
	private File mFile;
	private Document mDocument;// DOM 

	private String flagd = "";
	/**
	 * 
	 * @param filePath
	 *             xml file path
	 */
	public XMLUtil(String filePath) {
		this.mFilePath = filePath;
		mFile = new File(mFilePath);
		if (!mFile.exists()) {
			try {
				mFile.createNewFile();
				mDocument = DocumentHelper.createDocument();
				// create new xml document
				} catch (IOException e) {
				mDocument = DocumentHelper.createDocument();
			}
		} else {
			try {
				mDocument = new SAXReader().read(mFile);
			} catch (DocumentException e) {
				mDocument = DocumentHelper.createDocument();
			}
		}
		System.gc();
	}

	
	/**
	 * save the list to a xml file
	 * @param list the list u wanna save
	 * @return
	 */
	public boolean saveToFile(List<BookMark> list){
		boolean result = true;
		Element root =null;
		root = mDocument.getRootElement();
		if(null==root){
			root = mDocument.addElement("bookmark");
		}
		for (BookMark bookMark : list) {
			Element mark = root.addElement("mark");
			mark.addAttribute("markName", bookMark.getMarkName());
			mark.addAttribute("currentOffset", ""+bookMark.getCurrentOffset());
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
        /** Give the xml file encode */
        format.setEncoding(Constant.UTF8);
		try {
			XMLWriter writer = new XMLWriter(new FileOutputStream(mFilePath),format );
			writer.write(mDocument);
			writer.close();
		} catch (IOException e) {
			result=false;
		}
		return result;
	}
	
	
	/**
	 * the file parse to a list 
	 * @return
	 */
	public List<BookMark> fileToList(){
		List<BookMark> list = new ArrayList<BookMark>();
		List<Element> el = null;
		Element elt = mDocument.getRootElement();
		if(null!=elt)
		  el=elt.elements("mark");
		if(el!=null){
			Iterator<Element> l = el.iterator();
				while (l.hasNext()) {
					Element Element = (Element) l.next();
					int offset = 0;
					try{
						offset=	Integer.parseInt(Element.attributeValue("currentOffset"));
					}catch (Exception e) {
						offset=0;
					}
					BookMark b = new BookMark(offset,Element.attributeValue("markName"),Constant.BOOK_ID_IN_DATABASE);
					list.add(b);
				}
		}
		System.gc();
		return list;
	}
	

}
