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

/**
 * Example of SQLite.
 * 
 * @author T. Takeuchi
 * 
 */
public class SQLiteExample {

	public static final void main(String[] args) {
		SQLite sqlite = new SQLite("casmi.sqlite3");

		try {
			sqlite.connect();

			sqlite.execute("SELECT * FROM example");
			while (sqlite.next()) {
				int id = sqlite.getInt(1);
				String text = sqlite.getString("text");
				java.util.Date date = sqlite.getDate(3);
				float value = sqlite.getFloat("float");

				System.out.println(id + " | " + text + " | " + date + " | "
						+ value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlite.close();
		}
	}
}
