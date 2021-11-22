import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {

    /* assume that we are getting a Node that contains a text element as a child. */

    public static String getContent(Node n) {
        StringBuilder sb = new StringBuilder();
        Node child = n.getFirstChild();
        sb.append(child.getNodeValue());
        return sb.toString();
    }


    public static void main(String[] args) {
        String filename = "sample.xml";
        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            Element root = doc.getDocumentElement();
            System.out.println(root);
            NodeList CDs = root.getElementsByTagName("CD");
            Node currentNode, subNode;

            CD currentCD;

            for (int i = 0; i < CDs.getLength(); i++) {
                currentNode = CDs.item(i);
                /* each of these is a CD node. */
                NodeList children = currentNode.getChildNodes();
                currentCD = new CD();
                for (int j = 0; j < children.getLength(); j++) {
                    subNode = children.item(j);
                    if (subNode.getNodeType() == Node.ELEMENT_NODE) {
                        if (subNode.getNodeName().equals("TITLE")) {
                            currentCD.setTitle(getContent(subNode));
                            System.out.println(currentCD.getTitle());
                        }

                    }
                }
            }
            

        } catch (Exception e) {
            System.out.println("Parsing error:" + e);
        }
    }

}
