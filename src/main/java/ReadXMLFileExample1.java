    import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

    import org.apache.poi.ss.usermodel.Row;
    import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
    import  java.io.*;
    import java.nio.charset.Charset;
    import java.nio.file.Files;
    import java.util.Arrays;
    import java.util.Iterator;

    import  org.apache.poi.hssf.usermodel.HSSFSheet;
    import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
    import  org.apache.poi.hssf.usermodel.HSSFRow;
    public class ReadXMLFileExample1
    {

        public static void main(String argv[]) {
            String directory = "C:\\Users\\Admin\\Desktop\\ltcg";
            //declare file name to be create
            String filename = "C:\\Users\\Admin\\Desktop\\prem.xls";
            //creating an instance of HSSFWorkbook class
            HSSFWorkbook workbook = new HSSFWorkbook();
            //invoking creatSheet() method and passing the name of the sheet to be created
            HSSFSheet sheet = workbook.createSheet("January");
            //creating the 0th row using the createRow() method



            HSSFRow rowhead = sheet.createRow((short) 0);
//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method
            rowhead.createCell(0).setCellValue("ID");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Last Name");
            rowhead.createCell(3).setCellValue("Subject");
            rowhead.createCell(4).setCellValue("Marks");
            rowhead.createCell(5).setCellValue("XML Buddy File Name");
            rowhead.createCell(6).setCellValue("PDF Name");

            File dir = new File(directory);
            if (dir.exists() && dir.isDirectory()) {
                File[] files = dir.listFiles((d, name) -> name.endsWith(".xml"));
                File[] pdfFiles = dir.listFiles((d, name) -> name.endsWith(".pdf"));

                if (files != null) {
                    int noOfXMLs = 1;
                    for (File file : files) {
                        String xml = null;
                        try {
                            xml = Files.readString(file.toPath(), Charset.defaultCharset());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        parseXML(file, noOfXMLs, sheet, pdfFiles);

                        noOfXMLs++;
                    }
                }
                try {
                    FileOutputStream fileOut = new FileOutputStream(filename);
                    workbook.write(fileOut);
                    //closing the Stream
                    fileOut.close();
                    //closing the workbook
                    workbook.close();
                    //prints the message on the console
                    System.out.println("Excel file has been generated successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public static void parseXML(File file, int noOfXMLs, HSSFSheet sheet, File[] pdfFile){
            try
            {
//creating a constructor of file class and parsing an XML file

//an instance of factory that gives a document builder
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(file);
                doc.getDocumentElement().normalize();
                System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
                NodeList nodeList = doc.getElementsByTagName("student");



// nodeList is not iterable, so we are using for loop
                for (int itr = 0; itr < nodeList.getLength(); itr++)
                {
                    Node node = nodeList.item(itr);
                    System.out.println("\nNode Name :" + node.getNodeName());
                    if (node.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element eElement = (Element) node;
                        System.out.println("Student id: "+ eElement.getElementsByTagName("id").item(0).getTextContent());
                        System.out.println("First Name: "+ eElement.getElementsByTagName("firstname").item(0).getTextContent());
                        System.out.println("Last Name: "+ eElement.getElementsByTagName("lastname").item(0).getTextContent());
                        System.out.println("Subject: "+ eElement.getElementsByTagName("subject").item(0).getTextContent());
                        System.out.println("Marks: "+ eElement.getElementsByTagName("marks").item(0).getTextContent());
                        String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                        String name = eElement.getElementsByTagName("firstname").item(0).getTextContent();
                        String lastName = eElement.getElementsByTagName("lastname").item(0).getTextContent();
                        String subject = eElement.getElementsByTagName("subject").item(0).getTextContent();
                        String marks = eElement.getElementsByTagName("marks").item(0).getTextContent();
                        String xmlName = file.getName().toString();



                        writeInExcel(id,name,lastName,subject,marks, noOfXMLs, sheet, xmlName, pdfFile);
                    }
                }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        public static void writeInExcel(String id, String name, String lastName, String subject, String marks, int noOfXMLs, HSSFSheet sheet, String xmlName, File[] pdfFiles)
        {

            try
            {




//creating the 1st row
                HSSFRow row;
//inserting data in the first row


                    row = sheet.createRow((short) noOfXMLs);
                    row.createCell(0).setCellValue(id);
                    row.createCell(1).setCellValue(name);
                    row.createCell(2).setCellValue(lastName);
                    row.createCell(3).setCellValue(subject);
                    row.createCell(4).setCellValue(marks);
                    row.createCell(5).setCellValue(xmlName);
                    row.createCell(6).setCellValue(pdfFiles[noOfXMLs-1].getName());
               
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
    }

