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
package casmi.parser;

import java.io.IOException;

/**
 * CSV parser example.
 * 
 * @author T. Takeuchi
 * 
 * @see casmi.parser.CSV
 */
public class CSVExample {

    static final String CSV_FILE = CSVExample.class.getResource("example.csv").getPath();
    
    public static void main(String[] args) {
        CSV csv = new CSV(CSV_FILE);
        try {
            String[] line;
            while ((line = csv.readLine()) != null) {
                for (String str : line) {
                    System.out.print(str + ", ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            csv.close();
        }
    }
}
