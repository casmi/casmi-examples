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

import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;

import casmi.exception.ParserException;


/**
 * JSON parser example.
 * 
 * @see casmi.parser.JSON
 * 
 * @author T. Takeuchi
 */
public class JSONExample {
    
    class Sake {
        public String name;
        public int    abv;
        public String origin;

        Sake() {}

        Sake(String name, int abv, String origin) {
            this.name = name;
            this.abv = abv;
            this.origin = origin;
        }
    }
    
    static final String XML_FILE = JSONExample.class.getResource("example.xml").getPath();

    public void encode1() {
        JSON json = new JSON();

        Sake[] sake = new Sake[2];
        sake[0] = new Sake("Urakasumi", 15, "Miyagi");
        sake[1] = new Sake("Houhai", 16, "Aomori");

        String out = json.encode(sake);
        System.out.println(out);
    }

    public void encode2() throws ParserException, IOException, SAXException {
        JSON json = new JSON();
        XML xml = new XML();

        xml.parseFile(new File(XML_FILE));

        String out = json.encode(xml);
        System.out.println(out);
    }
    
    public static void main(String[] args) {
        JSONExample jsonExample = new JSONExample();
        
        System.out.println("### Encode JSON text from objects ###\n");
        
        jsonExample.encode1();
        
        System.out.println();
        System.out.println("### Encode JSON text from a XML file ###\n");
        
        try {
            jsonExample.encode2();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
