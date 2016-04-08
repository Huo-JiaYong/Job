package com.yong.job.five;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by jyong on 2016/4/5.
 */
public class ContentHandler extends DefaultHandler {

    private StringBuilder id;
    private StringBuilder name;
    private StringBuilder version;

    private String nodeName;

    @Override
    public void startDocument() throws SAXException {
        id = new StringBuilder();
        name = new StringBuilder();
        version = new StringBuilder();
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        nodeName = localName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (nodeName.equals("id")) {
            id.append(ch, start, length);
        } else if (nodeName.equals("name")) {
            name.append(ch, start, length);
        } else if (nodeName.equals("version")) {
            version.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equals("app")) {
            Log.e("id", id.toString().trim());
            Log.e("name", name.toString().trim());
            Log.e("version", version.toString().trim());
            id.setLength(0);
            name.setLength(0);
            version.setLength(0);
        }
    }
}
