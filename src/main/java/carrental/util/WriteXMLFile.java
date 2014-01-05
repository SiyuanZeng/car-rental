package carrental.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import carrental.model.Task;

public class WriteXMLFile {
	public void createXml(List<Task> tasklist) {

		try {

			/*
			 * private String name; private Category category; private Date
			 * deadline; private int time; private String description; private
			 * List<Task> subtasks;
			 */

			Element table = new Element("table");
			Document doc = new Document(table);
			doc.setRootElement(table);

			// <metadata>
			// <column name='firstname' label='FIRSTNAME' datatype='string'
			// editable='true'></column>
			Element metadata = new Element("metadata");
			Element Column1 = new Element("column");
			Column1.setAttribute(new Attribute("name", "Name"));
			Column1.setAttribute(new Attribute("label", "Name"));
			Column1.setAttribute(new Attribute("datatype", "string"));
			Column1.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column1);

			Element Column2 = new Element("column");
			Column2.setAttribute(new Attribute("name", "Category"));
			Column2.setAttribute(new Attribute("label", "Category"));
			Column2.setAttribute(new Attribute("datatype", "string"));
			Column2.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column2);

			Element Column3 = new Element("column");
			Column3.setAttribute(new Attribute("name", "Deadline"));
			Column3.setAttribute(new Attribute("label", "Deadline"));
			Column3.setAttribute(new Attribute("datatype", "date"));
			Column3.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column3);

			Element Column4 = new Element("column");
			Column4.setAttribute(new Attribute("name", "StartTime"));
			Column4.setAttribute(new Attribute("label", "Start Time"));
			Column4.setAttribute(new Attribute("datatype", "time"));
			Column4.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column4);

			Element Column5 = new Element("column");
			Column5.setAttribute(new Attribute("name", "Time"));
			Column5.setAttribute(new Attribute("label", "Time"));
			Column5.setAttribute(new Attribute("datatype", "integer"));
			Column5.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column5);

			Element Column6 = new Element("column");
			Column6.setAttribute(new Attribute("name", "HappyTime"));
			Column6.setAttribute(new Attribute("label", "Happy Time"));
			Column6.setAttribute(new Attribute("datatype", "time"));
			Column6.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column6);

			Element Column7 = new Element("column");
			Column7.setAttribute(new Attribute("name", "EndTime"));
			Column7.setAttribute(new Attribute("label", "End Time"));
			Column7.setAttribute(new Attribute("datatype", "time"));
			Column7.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column7);


			Element Column8 = new Element("column");
			Column8.setAttribute(new Attribute("name", "Description"));
			Column8.setAttribute(new Attribute("label", "Description"));
			Column8.setAttribute(new Attribute("datatype", "string"));
			Column8.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(Column8);

			Element Column9 = new Element("column");
			Column9.setAttribute(new Attribute("name", "Action"));
			Column9.setAttribute(new Attribute("label", "Action"));
			Column9.setAttribute(new Attribute("datatype", "html"));
			Column9.setAttribute(new Attribute("editable", "false"));
			metadata.addContent(Column9);

			doc.getRootElement().addContent(metadata);

			Element data = new Element("data");
			for (Task task : tasklist) {

				Element row = new Element("row");
				row.setAttribute(new Attribute("id", Integer.toString(task.getId())));

				Element rowColumn1 = new Element("column");
				rowColumn1.setAttribute(new Attribute("name", "Name"));
				rowColumn1.addContent(task.getName());
				row.addContent(rowColumn1);

				Element rowColumn2 = new Element("column");
				rowColumn2.setAttribute(new Attribute("name", "Category"));
				rowColumn2.addContent(task.getCategory().getName());
				row.addContent(rowColumn2);

				Element rowColumn3 = new Element("column");
				rowColumn3.setAttribute(new Attribute("name", "Deadline"));
				rowColumn3.addContent( DateAndTimeConversionUtil.getInstance().dateToString(task
						.getDeadline()));
				row.addContent(rowColumn3);

				Element rowColumn4 = new Element("column");
				rowColumn4.setAttribute(new Attribute("name", "StartTime"));
				rowColumn4.addContent(DateAndTimeConversionUtil.getInstance().timeTwelveHourToString(task.getStartTime()));
				row.addContent(rowColumn4);

				Element rowColumn5 = new Element("column");
				rowColumn5.setAttribute(new Attribute("name", "Time"));
				rowColumn5.addContent(Integer.toString(task.getTime()));
				row.addContent(rowColumn5);

				Element rowColumn6 = new Element("column");
				rowColumn6.setAttribute(new Attribute("name", "HappyTime"));
				rowColumn6.addContent(DateAndTimeConversionUtil.getInstance().timeTwelveHourToString(task.getHappyTime()));
				row.addContent(rowColumn6);

				Element rowColumn7 = new Element("column");
				rowColumn7.setAttribute(new Attribute("name", "EndTime"));
				rowColumn7.addContent(DateAndTimeConversionUtil.getInstance().timeTwelveHourToString(task.getEndTime()));
				row.addContent(rowColumn7);

				Element rowColumn8 = new Element("column");
				rowColumn8.setAttribute(new Attribute("name", "Description"));
				rowColumn8.addContent(task.getDescription());
				row.addContent(rowColumn8);

				Element rowColumn9 = new Element("column");
				rowColumn9.setAttribute(new Attribute("name", "Action"));
				// rowColumn6.addContent();
				row.addContent(rowColumn9);

				data.addContent(row);

			}
			doc.getRootElement().addContent(data);

			// new XMLOutputter().output(doc, System.out);
			XMLOutputter xmlOutput = new XMLOutputter();

			// display nice nice
			xmlOutput.setFormat(Format.getPrettyFormat());
			xmlOutput
					.output(doc,
							new FileWriter(
									"C:\\Users\\SiyuanZeng\\WebProject\\car-rental\\src\\main\\webapp\\resources\\mytheme\\datasource\\taskGrid.xml"));

			System.out.println("File Saved!");
		} catch (IOException io) {
			System.out.println(io.getMessage());
		}
	}
}