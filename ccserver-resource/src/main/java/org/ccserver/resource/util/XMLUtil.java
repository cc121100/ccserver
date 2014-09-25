package org.ccserver.resource.util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLUtil {
	
	private static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
	private static DocumentBuilder getDocumentBuilder(){
		try {
			return dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void load(String xmlFile){
		DocumentBuilder db = XMLUtil.getDocumentBuilder();
		try {
			Document doc = db.parse(new File(xmlFile));
			Element ccserverNode = (Element) doc.getElementsByTagName("CCServer").item(0);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
