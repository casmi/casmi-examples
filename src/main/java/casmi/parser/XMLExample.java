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

import casmi.exception.ParserException;


/**
 * XML parser example.
 * 
 * @see casmi.parser.XML
 * 
 * @author T. Takeuchi
 */
public class XMLExample{

    static final String XML_FILE = XMLExample.class.getResource("example.xml").getPath();
    
    public void simpleRead() throws ParserException, IOException {
        XML xml = new XML();
        xml.parseFile(new File(XML_FILE));
        System.out.println(xml);
    }
    
    public void read() throws ParserException, IOException {
        XML xml = new XML();
        xml.parseFile(new File(XML_FILE));
        recursivePrint(xml, 0);
    }

    private void recursivePrint(XMLElement element, int indent) {
        String indentStr = "";
        for (int i = 0; i < indent; i++) {
            indentStr += "  ";
        }

        // print start tag and attributes.
        System.out.print(indentStr);
        System.out.print("<");
        System.out.print(element.getName());

        for (String attributeName : element.getAttributeNames()) {
            String value = element.getAttribute(attributeName);
            System.out.print(" " + attributeName + "=\"" + value + "\"");
        }

        System.out.println(">");

        // print content.
        if (element.hasContent()) {
            System.out.print(indentStr + "  ");
            System.out.println(element.getContent());
        }

        // if this element does not have children, return method.
        if (!element.hasChildren()) {
            // print end tag.
            System.out.print(indentStr);
            System.out.println("</" + element.getName() + ">");
            return;
        }

        // execute this method recursively.
        for (XMLElement child : element.getChildren()) {
            recursivePrint(child, indent + 1);
        }

        // print end tag.
        System.out.print(indentStr);
        System.out.println("</" + element.getName() + ">");
    }

    
    public static void main(String[] args) {
        XMLExample xmlExample = new XMLExample();
        
        System.out.println("### Simple read example ###\n");
        try {
            xmlExample.simpleRead();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println();
        System.out.println("### Read example ###\n");
        
        try {
            xmlExample.read();
        } catch (ParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
