package xyz.hasaki.svgparse.svg;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/9/6.
 *
 * @author zpf
 * @version 1.0.0
 */

public class SvgXmlHandler extends DefaultHandler {


//    private StringBuilder pathDatas ;
    private List<String> pathDatas;

    public List<String> getPathData(){
        return pathDatas;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        pathDatas = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if("path".equalsIgnoreCase(qName)){
            for(int i = 0; i < attributes.getLength(); i++)
            {
                if("android:pathData".equalsIgnoreCase(attributes.getQName(i)))
                {
                    String value = attributes.getValue(i).trim();
                    pathDatas.add(value);
                }
            }
        }
    }

}
