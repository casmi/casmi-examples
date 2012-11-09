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


/**
 * Example of MySQL.
 * 
 * @author K. Nishimura
 * 
 */
public class MySQLExample {

    // NOTE: Change the following information for your environment.
    static final String HOST     = "localhost";
    static final String DATABASE = "casmi";
    static final String USER     = "test";
    static final String PASSWORD = "test";

    public static void main(String[] args) {
        MySQL mysql = null;
        
        try {
            // Create instance
            mysql = new MySQL(HOST, DATABASE, USER, PASSWORD);
            // mysql = new MySQL(HOST, DATABASE);

            // Connect database
            mysql.connect();

            // Insert
            Liquor l1 = mysql.entity(Liquor.class);
            l1.setName("Urakasumi");
            l1.setAbv(15);
            l1.origin = "Miyagi";
            l1.save();
            
            Liquor l2 = mysql.entity(Liquor.class);
            l2.setName("Houhai");
            l2.setAbv(16);
            l2.origin = "Aomori";
            l2.save();
            
            // Select all
            Liquor[] ls = mysql.all(Liquor.class);
            for (Liquor l : ls) {
                System.out.println(l);
            }
            
            // Select with query
            Liquor[] ls2 = mysql.all(Liquor.class, new Query().where("origin='Miyagi'"));
            for (Liquor l : ls2) {
                System.out.println(l);
            }
            
            // Delete all
            mysql.truncate(Liquor.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (mysql != null)
                mysql.close();
        }
    }    
}
