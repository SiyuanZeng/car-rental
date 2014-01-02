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
			Element firstColumn = new Element("column");
			firstColumn.setAttribute(new Attribute("name", "Name"));
			firstColumn.setAttribute(new Attribute("label", "NAME"));
			firstColumn.setAttribute(new Attribute("datatype", "string"));
			firstColumn.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(firstColumn);

			Element secColumn = new Element("column");
			secColumn.setAttribute(new Attribute("name", "Category"));
			secColumn.setAttribute(new Attribute("label", "CATEGORY"));
			secColumn.setAttribute(new Attribute("datatype", "string"));
			secColumn.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(secColumn);

			Element thrColumn = new Element("column");
			thrColumn.setAttribute(new Attribute("name", "Deadline"));
			thrColumn.setAttribute(new Attribute("label", "DEADLINE"));
			thrColumn.setAttribute(new Attribute("datatype", "date"));
			thrColumn.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(thrColumn);

			Element fourthColumn = new Element("column");
			fourthColumn.setAttribute(new Attribute("name", "Time"));
			fourthColumn.setAttribute(new Attribute("label", "TIME"));
			fourthColumn.setAttribute(new Attribute("datatype", "integer"));
			fourthColumn.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(fourthColumn);

			Element fifthColumn = new Element("column");
			fifthColumn.setAttribute(new Attribute("name", "Description"));
			fifthColumn.setAttribute(new Attribute("label", "DESCRIPTION"));
			fifthColumn.setAttribute(new Attribute("datatype", "string"));
			fifthColumn.setAttribute(new Attribute("editable", "true"));
			metadata.addContent(fifthColumn);

			Element sixthColumn = new Element("column");
			sixthColumn.setAttribute(new Attribute("name", "Action"));
			sixthColumn.setAttribute(new Attribute("label", " "));
			sixthColumn.setAttribute(new Attribute("datatype", "html"));
			sixthColumn.setAttribute(new Attribute("editable", "false"));
			metadata.addContent(sixthColumn);

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
				rowColumn3.addContent(new DateConversion().dateToString(task
						.getDeadline()));
				row.addContent(rowColumn3);

				Element rowColumn4 = new Element("column");
				rowColumn4.setAttribute(new Attribute("name", "Time"));
				rowColumn4.addContent(Integer.toString(task.getTime()));
				row.addContent(rowColumn4);

				Element rowColumn5 = new Element("column");
				rowColumn5.setAttribute(new Attribute("name", "Description"));
				rowColumn5.addContent(task.getDescription());
				row.addContent(rowColumn5);

				Element rowColumn6 = new Element("column");
				rowColumn6.setAttribute(new Attribute("name", "Action"));
				// rowColumn6.addContent();
				row.addContent(rowColumn6);

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