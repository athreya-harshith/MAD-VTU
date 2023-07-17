package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView xml,json;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xml = findViewById(R.id.xml);
        json = findViewById(R.id.json);


    }
    public void xmlParser(View v)
    {
        try {
            InputStream is = getAssets().open("city.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);

            Element element = doc.getDocumentElement();
            element.normalize();

            NodeList nlist = doc.getElementsByTagName("place");
            xml.setText("XML DATA \n");
            for(int i=0;i<nlist.getLength();i++)
            {
                Node node = nlist.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element ele = (Element) node;
                    xml.setText(xml.getText()+"\nCity Name "+getValue("name",ele)+"\n");
                    xml.setText(xml.getText()+"\nLattitude "+getValue("lat",ele)+"\n");
                    xml.setText(xml.getText()+"\nLogitude "+getValue("long",ele)+"\n");
                    xml.setText(xml.getText()+"\nTemperature"+getValue("temp",ele)+"\n");
                    xml.setText(xml.getText()+"\nHumid "+getValue("humid",ele)+"\n");
                }
            }

        }
        catch(Exception e)
        {

        }
    }
    public void jsonParser(View v)
    {
        try {
            InputStream is = getAssets().open("city.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String JSON = new String(buffer,"UTF-8");
            JSONArray jsonArr = new JSONArray(JSON);
            json.setText("JSON DATA\n");
            for(int i=0;i<jsonArr.length();i++)
            {
                JSONObject obj = jsonArr.getJSONObject(i);
                json.setText(json.getText()+"\nCITY NAME : "+obj.getString("name")+"\n");
                json.setText(json.getText()+"\nLattitude : "+obj.getString("lat")+"\n");
                json.setText(json.getText()+"\nLongitude :"+obj.getString("long")+"\n");
                json.setText(json.getText()+"\nTemperature :"+obj.getString("temp")+"\n");
                json.setText(json.getText()+"\nHumidity :"+obj.getString("humid")+"\n");
            }
        }
        catch (Exception e)
        {

        }


    }

    private static String getValue(String tag, Element ele)
    {
        NodeList nlist = ele.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nlist.item(0);
        return  node.getNodeValue();
    }
}