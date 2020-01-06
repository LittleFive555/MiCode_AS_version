/*
 * Copyright (c) 2010-2011, The MiCode Open Source Community (www.micode.net)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.micode.notes.data;

import android.net.Uri;
public class Notes {
    public static final String AUTHORITY = "micode_notes";
    public static final String TAG = "Notes";
    public static final int TYPE_NOTE     = 0;
    public static final int TYPE_FOLDER   = 1;
    public static final int TYPE_SYSTEM   = 2;

    /**
     * Following IDs are system folders' identifiers      系统文件夹的分类标识
     * {@link Notes#ID_ROOT_FOLDER } is default folder          默认文件夹
     * {@link Notes#ID_TEMPARAY_FOLDER } is for notes belonging no folder       不属于任何文件夹
     * {@link Notes#ID_CALL_RECORD_FOLDER} is to store call records         用来存储通话记录的文件夹？
     */
    public static final int ID_ROOT_FOLDER = 0;
    public static final int ID_TEMPARAY_FOLDER = -1;
    public static final int ID_CALL_RECORD_FOLDER = -2;
    public static final int ID_TRASH_FOLER = -3;

    public static final String INTENT_EXTRA_ALERT_DATE = "net.micode.notes.alert_date";
    public static final String INTENT_EXTRA_BACKGROUND_ID = "net.micode.notes.background_color_id";
    public static final String INTENT_EXTRA_WIDGET_ID = "net.micode.notes.widget_id";
    public static final String INTENT_EXTRA_WIDGET_TYPE = "net.micode.notes.widget_type";
    public static final String INTENT_EXTRA_FOLDER_ID = "net.micode.notes.folder_id";
    public static final String INTENT_EXTRA_CALL_DATE = "net.micode.notes.call_date";

    public static final int TYPE_WIDGET_INVALIDE      = -1;
    public static final int TYPE_WIDGET_2X            = 0;
    public static final int TYPE_WIDGET_4X            = 1;

    public static class DataConstants {
        public static final String NOTE = TextNote.CONTENT_ITEM_TYPE;
        public static final String CALL_NOTE = CallNote.CONTENT_ITEM_TYPE;
    }

    /**
     * Uri to query all notes and folders<br>
     * 查询所有标签和文件夹的统一资源标识符（uri）
     */
    public static final Uri CONTENT_NOTE_URI = Uri.parse("content://" + AUTHORITY + "/note");

    /**
     * Uri to query data<br>
     * 查询数据的统一资源标识符
     */
    public static final Uri CONTENT_DATA_URI = Uri.parse("content://" + AUTHORITY + "/data");

    public interface NoteColumns {
        /**
         * The unique ID for a row<br>
         * 行的唯一标识ID
         * <P> Type: INTEGER (long) </P>
         */
        public static final String ID = "_id";

        /**
         * The parent's id for note or folder<br>
         * 便签或文件夹的父ID
         * <P> Type: INTEGER (long) </P>
         */
        public static final String PARENT_ID = "parent_id";

        /**
         * Created data for note or folder<br>
         * 便签或文件夹的创建日期
         * <P> Type: INTEGER (long) </P>
         */
        public static final String CREATED_DATE = "created_date";

        /**
         * Latest modified date<br>
         * 最近一次改动时的日期
         * <P> Type: INTEGER (long) </P>
         */
        public static final String MODIFIED_DATE = "modified_date";


        /**
         * Alert date<br>
         * 提醒日期
         * <P> Type: INTEGER (long) </P>
         */
        public static final String ALERTED_DATE = "alert_date";

        /**
         * Folder's name or text content of note<br>
         * 文件夹的名字或便签的文本内容
         * <P> Type: TEXT </P>
         */
        public static final String SNIPPET = "snippet";

        /**
         * Note's widget id<br>
         * 便签的桌面小部件的id
         * <P> Type: INTEGER (long) </P>
         */
        public static final String WIDGET_ID = "widget_id";

        /**
         * Note's widget type<br>
         * 便签的桌面小部件的类型
         * <P> Type: INTEGER (long) </P>
         */
        public static final String WIDGET_TYPE = "widget_type";

        /**
         * Note's background color's id<br>
         * 便签的背景色的id
         * <P> Type: INTEGER (long) </P>
         */
        public static final String BG_COLOR_ID = "bg_color_id";

        /**
         * For text note, it doesn't has attachment, for multi-media
         * note, it has at least one attachment<br>
         * 对于文本便签，没有附件；对于多媒体便签，至少有一个附件
         * <P> Type: INTEGER </P>
         */
        public static final String HAS_ATTACHMENT = "has_attachment";

        /**
         * Folder's count of notes<br>
         * 文件夹里的便签数
         * <P> Type: INTEGER (long) </P>
         */
        public static final String NOTES_COUNT = "notes_count";

        /**
         * The file type: folder or note<br>
         * 文件类型：文件夹或便签
         * <P> Type: INTEGER </P>
         */
        public static final String TYPE = "type";

        /**
         * The last sync id<br>
         * 最后一次同步的id
         * <P> Type: INTEGER (long) </P>
         */
        public static final String SYNC_ID = "sync_id";

        /**
         * Sign to indicate local modified or not<br>
         * 是否进行了本地修改的标志
         * <P> Type: INTEGER </P>
         */
        public static final String LOCAL_MODIFIED = "local_modified";

        /**
         * Original parent id before moving into temporary folder<br>
         * 在移动到临时文件夹之前的原本的父id
         * <P> Type : INTEGER </P>
         */
        public static final String ORIGIN_PARENT_ID = "origin_parent_id";

        /**
         * The gtask id<br>
         * gtask的id
         * <P> Type : TEXT </P>
         */
        public static final String GTASK_ID = "gtask_id";

        /**
         * The version code<br>
         * <P> Type : INTEGER (long) </P>
         */
        public static final String VERSION = "version";
    }

    public interface DataColumns {
        /**
         * The unique ID for a row<br>
         * 行的唯一ID
         * <P> Type: INTEGER (long) </P>
         */
        public static final String ID = "_id";

        /**
         * The MIME type of the item represented by this row.<br>
         * 这一行所表示的项的MIME类型
         * <P> Type: Text </P>
         */
        public static final String MIME_TYPE = "mime_type";

        /**
         * The reference id to note that this data belongs to<br>
         * 此条数据属于的便签的引用id
         * <P> Type: INTEGER (long) </P>
         */
        public static final String NOTE_ID = "note_id";

        /**
         * Created date for note or folder<br>
         * 便签或文件夹的创建日期
         * <P> Type: INTEGER (long) </P>
         */
        public static final String CREATED_DATE = "created_date";

        /**
         * Latest modified date<br>
         * 最近一次修改的日期
         * <P> Type: INTEGER (long) </P>
         */
        public static final String MODIFIED_DATE = "modified_date";

        /**
         * Data's content<br>
         * 数据的content
         * <P> Type: TEXT </P>
         */
        public static final String CONTENT = "content";


        /**
         * Generic data column, the meaning is {@link #MIME_TYPE} specific, used for
         * integer data type<br>
         * 一般数据项，意思是MIME_TYPE指定的类型，用于整数型数据
         * <P> Type: INTEGER </P>
         */
        public static final String DATA1 = "data1";

        /**
         * Generic data column, the meaning is {@link #MIME_TYPE} specific, used for
         * integer data type<br>
         * 一般数据项，意思是MIME_TYPE指定的类型，用于整数型数据
         * <P> Type: INTEGER </P>
         */
        public static final String DATA2 = "data2";

        /**
         * Generic data column, the meaning is {@link #MIME_TYPE} specific, used for
         * TEXT data type<br>
         * 一般数据项，意思是MIME_TYPE指定的类型，用于TEXT文本数据
         * <P> Type: TEXT </P>
         */
        public static final String DATA3 = "data3";

        /**
         * Generic data column, the meaning is {@link #MIME_TYPE} specific, used for
         * TEXT data type<br>
         * 一般数据项，意思是MIME_TYPE指定的类型，用于TEXT文本数据
         * <P> Type: TEXT </P>
         */
        public static final String DATA4 = "data4";

        /**
         * Generic data column, the meaning is {@link #MIME_TYPE} specific, used for
         * TEXT data type<br>
         * 一般数据项，意思是MIME_TYPE指定的类型，用于TEXT文本数据
         * <P> Type: TEXT </P>
         */
        public static final String DATA5 = "data5";
    }

    public static final class TextNote implements DataColumns {
        /**
         * Mode to indicate the text in check list mode or not<br>
         * 标识文本是否在check list模式
         * <P>
         *     Type: Integer 1:check list mode 0: normal mode<br>
         *     类型：整数  1：check list模式  0：普通模式
         * </P>
         */
        public static final String MODE = DATA1;

        public static final int MODE_CHECK_LIST = 1;

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/text_note";

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/text_note";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/text_note");
    }

    public static final class CallNote implements DataColumns {
        /**
         * Call date for this record<br>
         * 这次记录的通话时间
         * <P> Type: INTEGER (long) </P>
         */
        public static final String CALL_DATE = DATA1;

        /**
         * Phone number for this record<br>
         * 这次记录的手机号码
         * <P> Type: TEXT </P>
         */
        public static final String PHONE_NUMBER = DATA3;
        /**
         * CONTENT-TYPE与html文件中的content-type属性相对应
         */
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/call_note";

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/call_note";

        public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/call_note");
    }
}
