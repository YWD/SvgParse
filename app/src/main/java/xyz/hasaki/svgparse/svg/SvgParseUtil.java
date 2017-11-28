package xyz.hasaki.svgparse.svg;

import android.content.Context;
import android.graphics.Path;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created on 2017/9/4.
 *
 * @author zpf
 * @version 1.0.0
 */

public class SvgParseUtil {

    private static final String TAG = "SvgParseUtil";

    private static ConstrainedSvgPathParser pathParser ;
    private static SAXParser saxParser;
    private static final SvgXmlHandler handler;

    static {

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            saxParser = factory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        handler = new SvgXmlHandler();

        pathParser = new ConstrainedSvgPathParser.Builder()
                .build();

    }


    public static Path parseSvgPathFromXml(Context context, String fileName, float[] size){
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            pathParser.setSize(size);
            saxParser.parse(inputStream,handler);
            List<String> pathData =  handler.getPathData();
            Path path =new Path();
            for(int i = 0; i < pathData.size();i++){
                path.addPath(parseSvgPath(pathData.get(i)));
            }
            return path;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null ;
    }

    private static Path parseSvgPath(String path){
        try {
            Path realPath = pathParser.parsePath(path);
            return realPath ;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null ;
    }
}
