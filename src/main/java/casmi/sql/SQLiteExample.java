/*
 *   casmi examples
 *   http://casmi.github.com/
 *   Copyright (C) 2011, Xcoo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package casmi.sql;

import casmi.sql.SQLite;
import casmi.util.FileUtil;
import casmi.util.SystemUtil;

/**
 * Example of SQLite.
 * 
 * @author T. Takeuchi
 */
public class SQLiteExample {

    static final String DATABASE_PATH = SystemUtil.JAVA_TMP_PATH + "casmi_example.sqlite3";

    public static void main(String[] args) {
        SQLite sqlite = null;
        
        try {
            // create a new database file if it is not exist. 
            if (!FileUtil.exist(DATABASE_PATH)) {
                SQLite.createDatabase(DATABASE_PATH);
            }

            // create instance
            sqlite = new SQLite(DATABASE_PATH);

            // connect database
            sqlite.connect();

            // insert
            Liquor l1 = sqlite.entity(Liquor.class);
            l1.setName("Urakasumi");
            l1.setAbv(15);
            l1.origin = "Miyagi";
            l1.save();
            
            Liquor l2 = sqlite.entity(Liquor.class);
            l2.setName("Houhai");
            l2.setAbv(16);
            l2.origin = "Aomori";
            l2.save();
            
            // select all
            Liquor[] ls = sqlite.all(Liquor.class);
            for (Liquor l : ls) {
                System.out.println(l);
            }
            
            // delete all
            sqlite.truncate(Liquor.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlite != null)
                sqlite.close();
        }
    }
}
