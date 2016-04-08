package com.yong.job.five;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yong.job.R;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

public class XMLActivity extends Activity implements View.OnClickListener {

    private Button pull;
    private Button sax;

    String XML_DATA = "<apps>\n" +
            "\t<app>\n" +
            "\t\t<id>1</id>\n" +
            "\t\t<name>Google Maps</name>\n" +
            "\t\t<version>1.0</version>\n" +
            "\t</app>\n" +
            "\t<app>\n" +
            "\t\t<id>2</id>\n" +
            "\t\t<name>Google Chrome</name>\n" +
            "\t\t<version>3.0</version>\n" +
            "\t</app>\n" +
            "\t<app>\n" +
            "\t\t<id>3</id>\n" +
            "\t\t<name>Google Play</name>\n" +
            "\t\t<version>1.0</version>\n" +
            "\t</app>\n" +
            "</apps>";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_xml_activity);
        pull = (Button) findViewById(R.id.pull);
        sax = (Button) findViewById(R.id.sax);
        pull.setOnClickListener(this);
        sax.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pull:
                try {
                    XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
                    parser.setInput(new StringReader(XML_DATA));
                    int eventType = parser.getEventType();
                    String id = "";
                    String name = "";
                    String version = "";
                    while (eventType != XmlPullParser.END_DOCUMENT) {
                        String nodeName = parser.getName();
                        switch (eventType) {
                            case XmlPullParser.START_TAG:
                                if (nodeName.equals("id")) {
                                    id = parser.nextText();
                                } else if (nodeName.equals("name")) {
                                    name = parser.nextText();
                                } else if (nodeName.equals("version")) {
                                    version = parser.nextText();
                                }
                                break;
                            case XmlPullParser.END_TAG:
                                if (nodeName.equals("app")) {
                                    Log.e("id", id);
                                    Log.e("name", name);
                                    Log.e("version", version);
                                }
                                break;
                        }

                        eventType = parser.next();
                    }
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.sax:
                try {
                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    XMLReader reader = factory.newSAXParser().getXMLReader();
                    ContentHandler handler = new ContentHandler();
                    reader.setContentHandler(handler);
                    reader.parse(new InputSource(new StringReader(XML_DATA)));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}