package carrental.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import carrental.dao.TaskDao;
import carrental.dao.jdbc.impl.TaskDaoImpl;
import carrental.exceptions.DaoException;
import carrental.model.Task;
import carrental.model.TaskReviewStatus;

public class WriteXMLFile {

/*    { name: "Name", datatype: "string", editable: true },
    { name: "10 minutes", datatype: "string", editable: true },
    { name: "s1", datatype: "boolean", editable: true },
    { name: "24 hours", datatype: "string", editable: true },
    { name: "s2", datatype: "boolean", editable: true },
    { name: "1 week", datatype: "string", editable: true },
    { name: "s3", datatype: "boolean", editable: true },
    { name: "1 month", datatype: "string", editable: true },
    { name: "s4", datatype: "boolean", editable: true },
    { name: "2 month", datatype: "string", editable: true },
    { name: "s5", datatype: "boolean", editable: true },*/


	DateAndTimeConversionUtil ConversionUtil = DateAndTimeConversionUtil.getInstance();

	public void createReviewTaskXml(List<Task> tasklist){
		try {
			Element table = new Element("table");
			Document doc = new Document(table);
			doc.setRootElement(table);

			Element metadata = new Element("metadata");

			addMetaColumn(metadata,"Name","Name","string","true");
			addMetaColumn(metadata,"10 minutes","10 minutes","string","true");
			addMetaColumn(metadata,"S1","S1","boolean","true");
			addMetaColumn(metadata,"24 hours","24 hours","string","true");
			addMetaColumn(metadata,"S2","S2","boolean","true");
			addMetaColumn(metadata,"1 week","1 week","string","true");
			addMetaColumn(metadata,"S3","S3","boolean","true");
			addMetaColumn(metadata,"1 month","1 month","string","true");
			addMetaColumn(metadata,"S4","S4","boolean","true");
			addMetaColumn(metadata,"2 month","2 month","string","true");
			addMetaColumn(metadata,"S5","S5","boolean","true");

			doc.getRootElement().addContent(metadata);
			Element data = new Element("data");
			TaskDao dao = new TaskDaoImpl();

			for (Task task : tasklist) {
				TaskReviewStatus trs=null;
				try {
					trs = dao.getTaskReviewStatus(task);
				} catch (DaoException e) {
					e.printStackTrace();
				}

				Element row = new Element("row");
				row.setAttribute(new Attribute("id", Integer.toString(task.getId())));

				addDataColumn(row, "Name", task.getName());
				addDataColumn(row, "10 minutes", (ConversionUtil.timeTwelveHourToString(task.getEndTime().plusMinutes(10))));
				addReviewStatusColumn(row, "S1", trs.getTenMinutes());
				addDataColumn(row, "24 hours", (ConversionUtil.dateToString(ConversionUtil.datePlusDays(task.getDeadline(),1)))+", \n"+ConversionUtil.timeTwelveHourToString(task.getEndTime()));
				addReviewStatusColumn(row, "S2", trs.getTwenntyFourHours());
				addDataColumn(row, "1 week",(ConversionUtil.dateToString(ConversionUtil.datePlusDays(task.getDeadline(),7)))+", \n"+ConversionUtil.timeTwelveHourToString(task.getEndTime()));
				addReviewStatusColumn(row, "S3", trs.getOneWeek());
				addDataColumn(row, "1 month",(ConversionUtil.dateToString(ConversionUtil.datePlusMonth(task.getDeadline(),1))+", \n"+ConversionUtil.timeTwelveHourToString(task.getEndTime())));
				addReviewStatusColumn(row, "S4", trs.getOneMonth());
				addDataColumn(row, "2 month",(ConversionUtil.dateToString(ConversionUtil.datePlusMonth(task.getDeadline(),2))+", \n"+ConversionUtil.timeTwelveHourToString(task.getEndTime())));
				addReviewStatusColumn(row, "S5", trs.getTwoMonth());

				data.addContent(row);
			}
			doc.getRootElement().addContent(data);

			// new XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput .output(doc, new FileWriter( "C:\\Users\\SiyuanZeng\\WebProject\\car-rental\\src\\main\\webapp\\resources\\mytheme\\datasource\\reviewTaskGrid.xml"));

			System.out.println("Review File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}

	}




	public void createAddTaskXml(List<Task> tasklist) {

		try {
			Element table = new Element("table");
			Document doc = new Document(table);
			doc.setRootElement(table);

			Element metadata = new Element("metadata");
			addMetaColumn(metadata,"Name","Name","string","true");
			addMetaColumn(metadata,"Category","Category","string","true");
			addMetaColumn(metadata,"Deadline","Deadline","date","true");
			addMetaColumn(metadata,"StartTime","Start Time","time","true");
			addMetaColumn(metadata,"Time","Time","integer","true");
			addMetaColumn(metadata,"HappyTime","Happy Time","time","true");
			addMetaColumn(metadata,"EndTime","End Time","time","true");
			addMetaColumn(metadata,"Description","Description","string","true");
			addMetaColumn(metadata,"Action","Action","html","false");

			doc.getRootElement().addContent(metadata);

			Element data = new Element("data");
			for (Task task : tasklist) {

				Element row = new Element("row");
				row.setAttribute(new Attribute("id", Integer.toString(task.getId())));

				addDataColumn(row, "Name", task.getName());
				addDataColumn(row, "Category", task.getCategory().getName());
				addDataColumn(row, "Deadline", ConversionUtil.dateToString(task.getDeadline()));
				addDataColumn(row, "StartTime", ConversionUtil.timeTwelveHourToString(task.getStartTime()));
				addDataColumn(row, "Time", Integer.toString(task.getTime()));
				addDataColumn(row, "HappyTime",ConversionUtil.timeTwelveHourToString(task.getHappyTime()));
				addDataColumn(row, "EndTime",ConversionUtil.timeTwelveHourToString(task.getEndTime()));
				addDataColumn(row, "Description",task.getDescription());
				addDataColumn(row, "Action","");

				data.addContent(row);

			}
			doc.getRootElement().addContent(data);

			XMLOutputter xmlOutput = new XMLOutputter();

			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput .output(doc, new FileWriter( "C:\\Users\\SiyuanZeng\\WebProject\\car-rental\\src\\main\\webapp\\resources\\mytheme\\datasource\\taskGrid.xml"));

			System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}



	private void addReviewStatusColumn(Element row, String columnName, int status) {
		Element rowColumn3 = new Element("column");
		rowColumn3.setAttribute(new Attribute("name", columnName));
		if (status==1) { rowColumn3.addContent(""); }
		else if (status==2) { rowColumn3.addContent("1"); }
		row.addContent(rowColumn3);
	}

	private void addDataColumn(Element row, String columnName, String content) {
		Element rowColumn1 = new Element("column");
		rowColumn1.setAttribute(new Attribute("name", columnName));
		rowColumn1.addContent(content);
		row.addContent(rowColumn1);
	}

	private void addMetaColumn(Element metadata,String attr,String lable, String datatype, String editable) {
		Element Column1 = new Element("column");
		Column1.setAttribute(new Attribute("name", attr));
		Column1.setAttribute(new Attribute("label", lable));
		Column1.setAttribute(new Attribute("datatype", datatype));
		Column1.setAttribute(new Attribute("editable", editable));
		metadata.addContent(Column1);
	}


}