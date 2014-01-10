/*
 * examples/full/javascript/demo.js
 *
 * This file is part of EditableGrid.
 * http://editablegrid.net
 *
 * Copyright (c) 2011 Webismymind SPRL
 * Dual licensed under the MIT or GPL Version 2 licenses.
 * http://editablegrid.net/license
 */

// create our editable grid
var editableGrid = new EditableGrid("DemoGridFull", {
	enableSort: true, // true is the default, set it to false if you don't want sorting to be enabled
	editmode: "absolute", // change this to "fixed" to test out editorzone, and to "static" to get the old-school mode
	editorzoneid: "edition", // will be used only if editmode is set to "fixed"
	pageSize: 10,
	maxBars: 10
});

// helper function to display a message
function displayMessage(text, style) {
	_$("message").innerHTML = "<p class='" + (style || "ok") + "'>" + text + "</p>";
}

// helper function to get path of a demo image
image =function(relativePath) {
	return "http://localhost:8080/car-rental/resources/images/EditableGrid/" + relativePath;
}

// this will be used to render our table headers
function InfoHeaderRenderer(message) {
	this.message = message;
	this.infoImage = new Image();
	this.infoImage.src = image("information.png");
};

InfoHeaderRenderer.prototype = new CellRenderer();
InfoHeaderRenderer.prototype.render = function(cell, value)
{
	if (value) {
		// here we don't use cell.innerHTML = "..." in order not to break the sorting header that has been created for us (cf. option enableSort: true)
		var link = document.createElement("a");
		link.href = "javascript:alert('" + this.message + "');";
		link.appendChild(this.infoImage);
		cell.appendChild(document.createTextNode("\u00a0\u00a0"));
		cell.appendChild(link);
	}
};

// this function will initialize our editable grid
EditableGrid.prototype.initializeGrid = function()
{
	with (this) {

		// register the function that will handle model changes
		modelChanged = function(rowIndex, columnIndex, oldValue, newValue, row) {


			$.ajax({
				url: "http://localhost:8080/car-rental/reviewTask.htm?updateTask=true",
				type: 'POST',
				dataType: "json",
				// the data match meta-data
				data: {
					id: editableGrid.getRowId(rowIndex),
					column: columnIndex,
					tablename : editableGrid.name,
					newvalue: editableGrid.getColumnType(columnIndex) == "boolean" ? (newValue ? 1 : 0) : newValue,
					colname: editableGrid.getColumnName(columnIndex),
					coltype: editableGrid.getColumnType(columnIndex)
				},
				success: function (response) { },
				error: function(XMLHttpRequest, textStatus, exception) {
					editableGrid.setValueAt(rowIndex, columnIndex, oldValue);
					alert(XMLHttpRequest.responseText);
				}
			});

			displayMessage("Value for '" + this.getColumnName(columnIndex) + "' in row " + this.getRowId(rowIndex) + " has changed from '" + oldValue + "' to '" + newValue + "'");
			if (this.getColumnName(columnIndex) == "continent") this.setValueAt(rowIndex, this.getColumnIndex("country"), ""); // if we changed the continent, reset the country
   	    	this.renderCharts();
		};


		//C1 add a new ajax call to delete task when click the delete button
		// *****************************************************************************************8888888888 the rowId is worong!!!!!!!!!!!!!!!!!!
		removeTask = function (deleteCell) {

			$.ajax({
				url: "http://localhost:8080/car-rental/task.htm?deleteTask=true",
				type: 'POST',
				dataType: "json",
				data: {	deleteRow: editableGrid.getRowId(deleteCell)},
				success: function (response) { },
				error: function(XMLHttpRequest, textStatus, exception) {
					alert(XMLHttpRequest.responseText);
				}
			});
	};

		// update paginator whenever the table is rendered (after a sort, filter, page change, etc.)
		tableRendered = function() { this.updatePaginator(); };

		rowSelected = function(oldRowIndex, newRowIndex) {
			if (oldRowIndex < 0) displayMessage("Selected row '" + this.getRowId(newRowIndex) + "'");
			else displayMessage("Selected row has changed from '" + this.getRowId(oldRowIndex) + "' to '" + this.getRowId(newRowIndex) + "'");
		};


		// render the grid (parameters will be ignored if we have attached to an existing HTML table)
		renderGrid("tablecontent", "testgrid", "tableid");

		// set active (stored) filter if any
		_$('filter').value = currentFilter ? currentFilter : '';

		// filter when something is typed into filter
		_$('filter').onkeyup = function() { editableGrid.filter(_$('filter').value); };

		// bind page size selector
		$("#pagesize").val(pageSize).change(function() { editableGrid.setPageSize($("#pagesize").val()); });
		$("#barcount").val(maxBars).change(function() { editableGrid.maxBars = $("#barcount").val(); editableGrid.renderCharts(); });
	}
};

EditableGrid.prototype.onloadXML = function(url)
{
	// register the function that will be called when the XML has been fully loaded
	this.tableLoaded = function() {
		displayMessage("Grid loaded from XML: " + this.getRowCount() + " row(s)");
		this.initializeGrid();
	};

	// load XML URL
	this.loadXML(url);
};

EditableGrid.prototype.onloadJSON = function(url)
{
	// register the function that will be called when the XML has been fully loaded
	this.tableLoaded = function() {
		displayMessage("Grid loaded from JSON: " + this.getRowCount() + " row(s)");
		this.initializeGrid();
	};

	// load JSON URL
	this.loadJSON(url);
};

EditableGrid.prototype.onloadHTML = function(tableId)
{
	this.load({ metadata: [
	    { name: "Name", datatype: "string", editable: true },
	    { name: "10 minutes", datatype: "string", editable: true },
	    { name: "s1", datatype: "boolean", editable: true },
	    { name: "24 hours", datatype: "string", editable: true },
	    { name: "s2", datatype: "boolean", editable: true },
	    { name: "1 week", datatype: "string", editable: true },
	    { name: "s3", datatype: "boolean", editable: true },
	    { name: "1 month", datatype: "string", editable: true },
	    { name: "s4", datatype: "boolean", editable: true },
	    { name: "2 month", datatype: "string", editable: true },
	    { name: "s5", datatype: "boolean", editable: true }
	]});

	// we attach our grid to an existing table
	this.attachToHTMLTable(_$(tableId));
	displayMessage("Grid attached to HTML table: " + this.getRowCount() + " row(s)");

	this.initializeGrid();
};


EditableGrid.prototype.duplicate = function(rowIndex)
{
	// copy values from given row
	var values = this.getRowValues(rowIndex);
	values['name'] = values['name'] + ' (copy)';

	// get id for new row (max id + 1)
	var generateRowId = 0;

	// add new row
	generateRowId= copyTask(rowIndex);

	alert("result"+generateRowId);
	this.insertAfter(rowIndex, generateRowId, values);
};

copyTask = function(rowIndex){
	var returnValue=0;
	$.ajax({
		url: "http://localhost:8080/car-rental/task.htm?copyTask=true",
		type: 'POST',
		dataType: "json",
		// the data match meta-data
		data: {	id: editableGrid.getRowId(rowIndex)},
		success: function subFunction (response) {

			$.each(response, function(key, task) {
				alert("new");
				alert(task.Task_Id);
				var newkey=parseInt(task.Task_Id);
				alert(newkey);
				returnValue=newkey;
			});

		},
		error: function(XMLHttpRequest, textStatus, exception) {
			alert(XMLHttpRequest.responseText);
		}
	});

	alert("returnvalue is faster than the ajax call, but next one finally return the correct value" + returnValue); // this is faster print;
	return returnValue;
};



// function to render the paginator control
EditableGrid.prototype.updatePaginator = function()
{
	var paginator = $("#paginator").empty();
	var nbPages = this.getPageCount();

	// get interval
	var interval = this.getSlidingPageInterval(20);
	if (interval == null) return;

	// get pages in interval (with links except for the current page)
	var pages = this.getPagesInInterval(interval, function(pageIndex, isCurrent) {
		if (isCurrent) return "" + (pageIndex + 1);
		return $("<a>").css("cursor", "pointer").html(pageIndex + 1).click(function(event) { editableGrid.setPageIndex(parseInt($(this).html()) - 1); });
	});

	// "first" link
	var link = $("<a>").html("<img src='" + image("gofirst.png") + "'/>&nbsp;");
	if (!this.canGoBack()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
	else link.css("cursor", "pointer").click(function(event) { editableGrid.firstPage(); });
	paginator.append(link);

	// "prev" link
	link = $("<a>").html("<img src='" + image("prev.png") + "'/>&nbsp;");
	if (!this.canGoBack()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
	else link.css("cursor", "pointer").click(function(event) { editableGrid.prevPage(); });
	paginator.append(link);

	for (p = 0; p < pages.length; p++) paginator.append(pages[p]).append(" | ");

	// "next" link
	link = $("<a>").html("<img src='" + image("next.png") + "'/>&nbsp;");
	if (!this.canGoForward()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
	else link.css("cursor", "pointer").click(function(event) { editableGrid.nextPage(); });
	paginator.append(link);

	// "last" link
	link = $("<a>").html("<img src='" + image("golast.png") + "'/>&nbsp;");
	if (!this.canGoForward()) link.css({ opacity : 0.4, filter: "alpha(opacity=40)" });
	else link.css("cursor", "pointer").click(function(event) { editableGrid.lastPage(); });
	paginator.append(link);
};


