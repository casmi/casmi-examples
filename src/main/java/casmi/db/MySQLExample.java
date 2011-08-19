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
  
package casmi.db;

import casmi.sql.MySQL;

/**
 * Example of MySQL.
 * 
 * @author K. Nishimura
 * 
 */
public class MySQLExample {

    static final String HOST = "localhost";
    static final String DATABASE = "casmi";
    static final String USER = "hoge";
    static final String PASSWORD = "hoge";
    

    public static final void main(String[] args) {
        MySQL mysql = new MySQL(HOST, DATABASE, USER, PASSWORD);

        try {
            mysql.connect();

            //mysql.execute("CREATE TABLE example (id integer, text text, date datetime, value double)");
            mysql.execute("INSERT INTO example VALUES (0, 'Test 1', '2011-07-15', 0.1)");
            mysql.execute("INSERT INTO example VALUES (1, 'Test 2', '2011-07-15 13:24', 0.2)");
            mysql.execute("INSERT INTO example VALUES (2, 'Test 3', '2011-07-15 13:25:36', 0.3)");

            //mysql.execute("CREATE TABLE example2 (id integer, value double)");
            
            mysql.execute("SELECT * FROM example");

            while (mysql.next()) {
                int id = mysql.getInt(1);
                String text = mysql.getString("text");
                java.util.Date date = mysql.getDate(3);
                float value = mysql.getFloat("value");
                System.out.println(id + " | " + text + " | " + date + " | " + value);
            }
        
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mysql.close();
        }
    }
    
}
