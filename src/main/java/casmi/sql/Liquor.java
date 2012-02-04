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

import casmi.sql.annotation.Fieldname;
import casmi.sql.annotation.Ignore;
import casmi.sql.annotation.PrimaryKey;
import casmi.sql.annotation.Tablename;

/**
 * Entity class of liquor for SQL examples.
 * 
 * @see casmi.sql.MySQLExample
 * @see casmi.sql.SQLiteExample
 * 
 * @author T. Takeuchi
 */
@Tablename("liquor_table")
public class Liquor extends Entity {

    @PrimaryKey
    private String name;
    
    @Fieldname("alcohol_by_volume")
    private int abv;
    
    public String origin;
    
    @Ignore
    public int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAbv() {
        return abv;
    }

    public void setAbv(int abv) {
        this.abv = abv;
    }
}
