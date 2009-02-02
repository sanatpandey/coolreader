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

/**
 * <p>Title: Cool Reader</p>
 *
 * <p>Description: Cool Reader</p>
 *
 * <p>Copyright: Copyright (c) 2008</p>
 *
 * <p>Company: www.51gphone.cn</p>
 *
 * @author Wang Baoxi
 * @version 1.0
 */

public class TxtLine {
	
	/**当前行最后一个字符在文件中的偏移量*/
    public int offset = 0;
    
    /**当前行的长度*/
    public int lineLength = 0;
    
    /**the data length before this line and contain current line*/
    public int beforeLineLength=0;
    public TxtLine() {
        this(0, 0,0);
    }

    public TxtLine(int offset, int lenght,int beforeLineLength) {
        this.offset = offset;
        this.lineLength = lenght;
        this.beforeLineLength=beforeLineLength;
    }

}
