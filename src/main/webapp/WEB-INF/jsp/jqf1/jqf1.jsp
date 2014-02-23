<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
	  "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt-br" lang="pt-br">
<head>
	<title>JQF1 - Jquery FormOne - Form Style Plugin</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<meta name="description" content="JQF1 - Jquery FormOne - Form Style Plugin" />
	<meta name="keywords" content="jqf1, jqury, form, formon, style, styling, estlizacao, estilo, formulario, css, javacript" />
	<meta name="resource-type" content="document" />
	<meta name="robots" content="ALL" />
	<meta name="distribution" content="Global" />
	<meta name="rating" content="General" />
	<meta name="author" content="Thiago Azurem - azurem@gmail.com" />
	<meta name="language" content="pt-br" />
	<link rel="stylesheet" href="<c:url value="/resources/jqf1/css/jqf1.css" />" type="text/css" media="screen">
	<link rel="stylesheet" href="<c:url value="/resources/jqf1/trash/tabs/tabs.css" />" type="text/css" media="screen">
	<link rel="stylesheet" href="<c:url value="/resources/jqf1/trash/jwysiwyg/jquery.wysiwyg.css" />" type="text/css" media="screen">
	<script src="<c:url value="/resources/jqf1/js/jquery.js" />" ></script>
	<script src="<c:url value="/resources/jqf1/trash/tabs/ui.core.js" />" ></script>
	<script src="<c:url value="/resources/jqf1/trash/tabs/ui.tabs.js" />" ></script>
	<script src="<c:url value="/resources/jqf1/js/jqf1.english.js" />" ></script>
	<script src="<c:url value="/resources/jqf1/trash/jwysiwyg/jquery.wysiwyg.js" />" ></script>
</head>
<body>

<form:form id="vocabularyForm" method="POST" name="vocabularyForm" commandName="vocabularyForm">
	<form:errors path="*" cssClass="errorblock" element="div" />
	<div id="divHeader" style="clear:both;">
	  <h1 style="font:bold 16px arial;padding:10px;width:400px;margin:10px 0px;">Add a word</h1>
	</div>

	<div id="rotate" style="float:left;width:600px;margin:15px 0px;border-bottom:1px solid silver;">
	            <ul>
	                <li><a href="#tabz0"><span>Verb</span></a></li>
	                <li><a href="#tabz1"><span>Noun</span></a></li>
	                <li><a href="#tabz2"><span>File</span></a></li>
	                <li><a href="#tabz3"><span>Radio/Checkbox</span></a></li>
	                <li><a href="#tabz4"><span>Select</span></a></li>
	                <li><a href="#tabz5"><span>Textarea</span></a></li>
	                <li><a href="#tabz6"><span>Buttons</span></a></li>
	                <li><a href="#tabz7"><span>Manipulation</span></a></li>
	            </ul>
	            <div class="tabz" id="tabz0">

	<div style="padding:10px;">
	    <ul class="ul">
	      <li><label for="name">Word:</label></li>
		  <td><form:input path="name" ></form:input></td>
		  <td><form:errors path="name" cssClass="error" /></td>
	    </ul>

	    <ul class="ul">
	      <li><label for="pronouciation">Pronouciation:</label></li>
	      <td><form:input path="pronouciation" ></form:input></td>
		  <td><form:errors path="pronouciation" cssClass="error" /></td>
	    </ul>

	    <ul class="ul">
	      <li><label for="etymology">Etymology:</label></li>
	      <li><form:textarea path="etymology" rows="3" cols="40" style="width:400px"/></li>
		  <li><td><form:errors path="etymology" cssClass="error" /></td></li>
	    </ul>

	    <ul class="ul">
	      <li><form:checkboxes element="li" path="vocabularyCategory.categoriesList" items="${categoriesList}"></form:checkboxes></li>
	      	  <form:errors path="categoriesList" cssClass="error" />
	    </ul>

	    <ul class="ul">
	    	<table>
	    		<tr>
	    			<th><label for="subject">Subject</label></th>
	    			<th><label for="adverb">Adverb</label></th>
	    			<th><label for="verb">Verb</label></th>
	    			<th><label for="adjective">Adjective</label></th>
	    			<th><label for="noun">Noun</label></th>
	    		</tr>
	    		<tr>
	     			<td><form:input path="variedFormSubject" size="10"></form:input></td>
	     			<td><form:input path="variedFormAdverb" size="10"></form:input></td>
	     			<td><form:input path="variedFormVerb" size="10"></form:input></td>
	     			<td><form:input path="variedFormAdjective" size="10"></form:input></td>
	     			<td><form:input path="variedFormNoun" size="10"></form:input></td>
	      			<td><form:errors path="variedFormSubject" cssClass="error" /></td>
	      			<td><form:errors path="variedFormAdverb" cssClass="error" /></td>
	      			<td><form:errors path="variedFormVerb" cssClass="error" /></td>
	      			<td><form:errors path="variedFormAdjective" cssClass="error" /></td>
	      			<td><form:errors path="variedFormNoun" cssClass="error" /></td>
	     		</tr>
	     	</table>
	    </ul>

	    <ul class="ul">
	      <li><label for="synonym">Synonym:</label></li>
	      <li><form:textarea path="synonym" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="synonym" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="antonym">Antonym:</label></li>
	      <li><form:textarea path="antonym" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="antonym" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="note">Note:</label></li>
	      <li><form:textarea path="note" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="note" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="example">Example:</label></li>
	      <li><form:textarea path="example" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="example" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="personalExperience">Personal Experience:</label></li>
	      <li><form:textarea path="personalExperience" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="personalExperience" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="writing">Writing:</label></li>
	      <li><form:textarea path="writing" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="writing" cssClass="error" />
	    </ul>

	    <ul class="ul">
	      <li><label for="memoryTag">Memory Tag:</label></li>
	      <li><form:textarea path="memoryTag" rows="3" cols="40" style="width:400px"></form:textarea></li>
	      <form:errors path="memoryTag" cssClass="error" />
	    </ul>


	    <ul class="ul">
	      <li>
	      		<button type="submit" id="submitButton" style="width:200px;">Save</button>
	      </li>

	      <li>
	      		<input id="cancelButton" type="button" value="Cancel" onclick="javascript:window.location='welcome'" />
	      </li>
	    </ul>
	</div>
	            </div>
	            <div class="tabz" id="tabz1">

	<div class="divExample" style="padding:10px;">
	    <h2><b>Input type=text examples</b></h2>
	    <ul class="ul">
	      <li><label for="inptext1">Input text 1:</label></li>
	      <li><input type="text" id="inptext1" size="12" name="inptext1" maxlength="10" /></li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inptext1"&gt;Input text 1:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="text" id="inptext1" size="12" name="inptext1" maxlength="10" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="inptext2">Input text 2:</label></li>
	      <li><input type="text" id="inptext2" size="2" name="inptext2" maxlength="100" style="width:300px" /></li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inptext2"&gt;Input text 2:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="text" id="inptext2" size="2" name="inptext2" maxlength="100" style="width:300px" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	</div>

	            </div>
	            <div class="tabz" id="tabz2">

	<div class="divExample" style="padding:10px;">
	    <h2><b>Input type=file example</b></h2>
	    <ul class="ul"><li><b>OBS: Input file enhancements coming soon || Melhoras no input file em breve</b></li></ul>
	    <ul class="ul">
	      <li><label for="inpfile">Input file:</label></li>
	      <li><input type="file" id="inpfile"  name="inpfile" style="width:300px;" /></li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inpfile"&gt;Input file:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="file" id="inpfile"  name="inpfile" style="width:300px;" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	</div>

	            </div>

	            <div class="tabz" id="tabz3">

	<div class="divExample" style="padding:10px;">
	    <h2><b>Input type=radio and type=checkbox examples</b></h2>
		<div id="divRadioExample">
	    <ul class="ul">
	      <li><label for="inpradio1">Input radio 1:</label></li>
	      <li><input type="radio" id="inpradio1" name="inpradio" value="rad01" /></li>
	    </ul>
	    <ul class="ul">
	      <li><label for="inpradio2">Input radio 2:</label></li>
	      <li><input type="radio" id="inpradio2" name="inpradio" value="rad02" checked /></li>
	    </ul>
	    <ul class="ul">
	      <li><label for="inpck1">Input check 1:</label></li>
	      <li><input type="checkbox" id="inpck1" name="inpck" value="ck01" /></li>
	    </ul>
	    <ul class="ul">
	      <li><label for="inpck2">Input check 2:</label></li>
	      <li><input type="checkbox" id="inpck2" name="inpck" value="ck02" /></li>
	    </ul>
	    </div>
	<pre>
	&lt;div id="divRadioExample"&gt;
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inpradio1"&gt;Input radio 1:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="radio" id="inpradio1"  name="inpradio" value="rad01" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inpradio2"&gt;Input radio 2:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="radio" id="inpradio2"  name="inpradio" value="rad02" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inpcheck1"&gt;Input check 1:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="radio" id="inpcheck1"  name="inpcheck" value="check01" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="inpcheck2"&gt;Input check 2:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="checkbox" id="inpcheck2"  name="inpcheck" value="check02" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;/div&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('#divRadioExample').jqf1();
	});
	&lt;/script&gt;
	</pre>
	</div>

	            </div>
	            <div class="tabz" id="tabz4">

	<div class="divExample" style="padding:10px;">
	    <h2><b>Select commands</b></h2>
	    <ul class="ul">
	      <li><b>Attribute: search="ok":</b> Select with filter inside || Select com filtro dentro</li>
	    </ul>
	    <ul class="ul">
	      <li><b>Attribute: openheight="?":</b> Opened options list height || Altura da lista de options aberta</li>
	    </ul>
	    <ul class="ul">
	      <li><b>Attribute: size="1":</b> Special select multiple || Select multiple especial</li>
	    </ul>
	    <h2><b>Select examples</b></h2>
	    <ul class="ul">
	      <li><label for="selectSearch">Select Search:</label></li>
	      <li>
	        <select name="selectSearch" id="selectSearch" search="ok" openheight="150">
	          <option value="00">Primeiro</option>
	          <option value="01">Joao 1</option>
	          <option value="02">Pedro 2</option>
	          <option value="03">Thiago Silva 3</option>
	          <option value="04">Thiago Azurem 4</option>
	          <option value="05">Renata 5</option>
	          <option value="06">Jose 6</option>
	          <option value="07">Fernanda 7</option>
	          <option value="08">Isabel 8</option>
	          <option value="09">Galvao 9</option>
	          <option value="10">Toronto 10</option>
	          <option value="11">Ademar 11</option>
	          <option value="12">Olimpio 12</option>
	          <option value="13">Tiel 13</option>
	          <option value="14">Raimundo 14</option>
	          <option value="15">David 15</option>
	          <option value="16">Joaldo 16</option>
	          <option value="17">Alberto 17</option>
	          <option value="18">Caua 18</option>
	          <option value="19">Giulia 19</option>
	          <option value="20">Julia 20</option>
	          <option value="21">Thiego 21</option>
	          <option value="22">Reginaldo 22</option>
	          <option value="23">Gildo 23</option>
	          <option value="24">Antonio 24</option>
	          <option value="25">Jackson 25</option>
	          <option value="26">Humberto 26</option>
	        </select>
	      </li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="selSearch"&gt;SelectSearch:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;
	&lt;select name="selSearch" id="selSearch" search="ok" style="width:200px;" openheight="150"&gt;
	...A lot of options :P...
	&lt;select&gt;
	&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="selectGroup">Multiple with optgroup:</label></li>
	      <li>
	        <select name="selectGroup" id="selectGroup" multiple="multiple" style="width:200px;">
	          <optgroup label="Optgroup1">
	            <option value="01">Option 1</option>
	            <option value="02">Option 2</option>
	          </optgroup>
	          <optgroup label="Optgroup2">
	            <option value="03">Option 3</option>
	            <option value="04">Option 4</option>
	          </optgroup>
	        </select>
	      </li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="selectx"&gt;&gt;Multiple with optgroup:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;
	&lt;select name="selectx" id="selectx" multiple="multiple" style="width:200px;"&gt;
	&lt;optgroup label="Optgroup1"&gt;
	&lt;option value="01"&gt;Option 1&lt;/option&gt;
	&lt;option value="02"&gt;Option 2&lt;/option&gt;
	&lt;/optgroup&gt;
	&lt;optgroup label="Optgroup2"&gt;
	&lt;option value="03"&gt;Option 3&lt;/option&gt;
	&lt;option value="04"&gt;Option 4&lt;/option&gt;
	&lt;/optgroup&gt;
	&lt;/select&gt;
	&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="selectSize">Multiple size=1:</label></li>
	      <li>
	        <select name="selectSize" id="selectSize" multiple="multiple" size="1" style="width:150px;" openheight="100">
	          <option value="01" selected>Option 1</option>
	          <option value="02">Option 2</option>
	          <option value="03">Option 3</option>
	        </select>
	      </li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="select3"&gt;Multiple size=1:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;
	&lt;select name="select3" id="select3" multiple="multiple" size="1" style="width:150px;" openheight="100"&gt;
	&lt;option value="01" selected&gt;Option 1&lt;/option&gt;
	&lt;option value="02"&gt;Option 2&lt;/option&gt;
	&lt;option value="03"&gt;Option 3&lt;/option&gt;
	&lt;/select&gt;
	&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>

	</div>

	            </div>
	            <div class="tabz" id="tabz5">
	<div class="divExample" style="padding:10px;">
	    <h2><b>Textarea example</b></h2>
	    <ul class="ul">
	      <li><label for="textarea">Textarea:</label></li>
	      <li><textarea id="textarea" rows="10" cols="40" name="textarea"></textarea></li>
	    </ul>
	</div>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="textarea"&gt;Textarea:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;textarea id="textarea" rows="10" cols="40" name="textarea"&gt;&lt;/textare&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>

	            </div>
	            <div class="tabz" id="tabz6">
	    <ul class="ul">
	      <li><label for="submit">Input submit:</label></li>
	      <li><input type="submit" id="submit" value="Input Submit" /></li>
	    </ul>
	    <ul class="ul">
	      <li><label for="button">Button:</label></li>
	      <li><button type="button" id="button" style="width:200px;">Button</button></li>
	    </ul>
	<pre>
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="submit"&gt;Input submit:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;input type="submit" id="submit" value="Input Submit" /&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;ul class="ul"&gt;
	&lt;li&gt;&lt;label for="button"&gt;Button:&lt;/label&gt;&lt;/li&gt;
	&lt;li&gt;&lt;button type="button" id="button" style="width:200px;"&gt;Button&lt;/button&gt;&lt;/li&gt;
	&lt;/ul&gt;
	&lt;script type="text/javascript"&gt;
	$(document).ready(function(){
	  $('.ul').jqf1();
	});
	&lt;/script&gt;
	</pre>
	            </div>
	            <div class="tabz" id="tabz7">

	<div class="divExample" style="padding:10px;">
	    <p><b>JQF1 NOT WORKS IN HIDDEN ELEMENTS</b> (display:none/visibility:hidden)<br />Turns element visible to use the .jqf1() function.</p>
	    <p><b>N&Atilde;O FUNCIONA EM ELEMENTOS ESCONDIDOS</b> (display:none/visibility:hidden)<br />Torne o elemento vis&iacute;vel para poder usar a fun&ccedil;&atilde;o .jqf1()</p>
	    <p><b><b>IE6:</b> "openheight" attribute for select elements needed.<br />&Eacute; necess&aacute;rio usar o atributo "openheight"</p>
	    <h2 style="margin-top:20px;"><b>Unobtrusive integration || Integra&ccedil;&atilde;o n&atilde;o-obstrutiva</b></h2>
	    <ul class="ul"><li><b>Use jqf1=ok attribute to ignore a element || Use o atributo jqf1=ok p/ ignorar um elemento</b></li></ul>
	    <ul class="ul">
	      <li><label for="wysiwyg" style="width:524px;">Textarea with wysiwyg plugin:</label></li>
	      <li><textarea name="wysiwyg" id="wysiwyg" jqf1="ok" rows="5" cols="62"></textarea></li>
	    </ul>
	<pre style="height:auto">
	&lt;textarea name="wysiwyg" id="wysiwyg" jqf1="ok" rows="5" cols="62"&gt;&lt;/textarea&gt;
	</pre>
	    <h2 style="margin-top:20px;"><b>Manipulation: Add/Del/Update element || Adicionar/Apagar/Atualizar elemento</b></h2>
	    <ul class="ul">
	      <li><label>Example 1:</label></li>
	      <li id="example1"><a href="javascript:void(0);">Adding type=text using JS || Adicionando type=text via JS</a></li>
	    </ul>
	<pre>
	&lt;script type="text/javascript"&gt;
	$('#example1').bind("click", function(){
	  $(this).html('&lt;input type=text id=inpex1 size=5 name=inpex1 /&gt;');
	  $('#inpex1').jqf1();
	  $('#example1').unbind('click');
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="inpex2">Example 2:</label></li>
	      <li><input type="checkbox" id="inpex2" name="inpcheck" value="ex02" /></li>
	      <li id="example2" style="padding-left:10px;"><a href="javascript:void(0);">Selecting radio/check using JS || Selecionando radio/check via JS</a></li>
	    </ul>
	<pre>
	&lt;script type="text/javascript"&gt;
	$('#example2').bind("click", function(){
	$('#inpex2').attr('checked',true);
	$('#inpex2').jqf1();
	$('#example2').remove();
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="selEx3">Example 3:</label></li>
	      <li>
	        <select name="selEx3" id="selEx3" multiple="multiple" style="width:200px;height:100px;">
	          <optgroup label="Optgroup1">
	            <option value="01">Option 1</option>
	            <option value="02">Option 2</option>
	          </optgroup>
	          <optgroup label="Optgroup2">
	            <option value="03">Option 3</option>
	            <option value="04">Option 4</option>
	          </optgroup>
	        </select>
	      </li>
	      <li id="example3" style="padding-left:10px;"><a href="javascript:void(0);">Update select using JS<br />Atualizar select via JS</a></li>
	    </ul>
	<pre>
	&lt;script type="text/javascript"&gt;
	$('#example3').bind("click", function(){
	$('#selEx3').html('&lt;option&gt;1&lt;/option&gt; &lt;option&gt;2&lt;/option&gt;');
	$('#selEx3').jqf1();
	$('#example3').remove();
	});
	&lt;/script&gt;
	</pre>
	    <ul class="ul">
	      <li><label for="selEx4">Example 4:</label></li>
	      <li id="example4" style="padding-left:10px;"><a href="javascript:void(0);">Adding select using JS || Adicionando select via JS</a></li>
	    </ul>
	<pre>
	&lt;script type="text/javascript"&gt;
	$('#example4').bind("click", function(){
	$('#example4').html('
	  &lt;select name="selex4" id="selex4" style="width:100px;"&gt;
	  &lt;option value="01"&gt;1&lt;/option&gt;
	  &lt;option value="02"&gt;2&lt;/option&gt;
	  &lt;option value="03" selected&gt;3 checked&lt;/option&gt;
	  &lt;/select&gt;
	');
	$('#example4').unbind('click');
	$('#selex4').jqf1();
	});
	&lt;/script&gt;
	</div>

	            </div>


	</div>


	<div style="display:none">
	<p><a href="javascript:void(0);" onClick="$('#divBasicUsage').toggle();"><b>Click to see the How To / Clique para ver como usar</b></a></p>
	<p><a href="jqf1.zip"><b>Download JQF1 1.0.1</b></a></p>
	</div>
	<div id="divBasicUsage" style="display:none;font:12px arial;padding:20px;border:1px solid gray;background-color:#f1f1f1">
	  <p><b>HowTo / Como usar</b></p>
	  <p>Using at containner element, like a Form, to style form elements inside.
	  <br />Usando em um elemento container, como um formulario por exemplo, para estilizar os seus elementos de formulario internos ao mesmo.</p>
	  <p style="padding-left:20px;">$('.formExample').jqf1();
	  <br />&lt;form id="" action="" class=".formExample"&gt;</p>
	  <p>OBS: NOT APPLY FOR HIDDEN (display:none) ELEMENTS - Hidden elements needs to apply the .jqf() in his containner after onload.</p>
	  <p>OBS: NAO SE APLICA A ELEMENTOS ESCONDIDOS (display:none) - Elementos escondidos precisam aplicar .jqf1() em seu containner depois de carregados.</p>
	  <p>Building or Updating a form element;
	  <br />Construindo ou Atualizando um elemento de formulario;</p>

	  <p style="padding-left:20px;">$('#select1').jqf1();
	  <br />&lt;select id="select1" name=""&gt;</p>

	  <p>Special select attributes:
	  <br />Atributos especiais nos selects:</p>

	  <p style="padding-left:20px;">Multiple select with size=1 attribute:  Select with slide toggle and input chekcs for each option.
	  <br />Select Multiple com atributo size=1: Select com slide e input checks para cada option.</p>
	  <p style="padding-left:40px;">&lt;select id="" name="" multiple="multiple" size="1"&gt;</p>

	  <p style="padding-left:20px;">Search=ok: Puts a input text field inside working like "options filter".
	  <br />Search=ok: Coloca um campo input de texto como "filtro de options".</p>
	  <p style="padding-left:40px;">&lt;select id="" name="" search="ok"&gt;</p>

	  <p style="padding-left:20px;">Openheight=?: Altura da lista aberta de options.
	  <br />Openheight=?: Opened options list height.</p>
	  <p style="padding-left:40px;">&lt;select id="" name="" openheight="150"&gt;</p>

	  <p>"Required Fields" Addon coming soon in the next version.</p>
	  <p>Addon de "Campos Obrigatorios" em breve na proxima versao.</p>
	</div>


	<script type="text/javascript">
	    $(document).ready(function(){
	      $('body').jqf1();
	      $('#example1').bind("click", function(){
	        $(this).html('<input type=text id=inpex1 size=5 name=inpex1 />');
			$('#example1').jqf1();
	        $('#example1').unbind('click');
	      });
	      $('#example2').bind("click", function(){
	        $('#inpex2').attr('checked',true);
	        $('#inpex2').jqf1();
	        $('#example2').remove();
	      });
	      $('#example3').bind("click", function(){
	        $('#selEx3').html('<option>1</option> <option>2</option>');
	        $('#selEx3').jqf1();
	        $('#example3').remove();
	      });
	      $('#example4').bind("click", function(){
	        $(this).html('<select name="selex4" id="selex4" style="width:100px;"><option value="01">1</option><option value="02">2</option><option value="03" selected>3 checked</option></select>');
	        $('#example4').unbind('click');
	        $('#selex4').jqf1();
	      });


	      $('#rotate > ul').tabs({ fx: { opacity: 'toggle' } }).tabs('rotate', 2000);


	  $('#wysiwyg').wysiwyg({
	    controls: {
	      strikeThrough : { visible : true },
	      underline     : { visible : true },

	      separator00 : { visible : true },

	      justifyLeft   : { visible : true },
	      justifyCenter : { visible : true },
	      justifyRight  : { visible : true },
	      justifyFull   : { visible : true },

	      separator01 : { visible : true },

	      indent  : { visible : true },
	      outdent : { visible : true },

	      separator02 : { visible : true },

	      subscript   : { visible : true },
	      superscript : { visible : true },

	      separator03 : { visible : true },

	      undo : { visible : true },
	      redo : { visible : true },

	      separator04 : { visible : true },

	      insertOrderedList    : { visible : true },
	      insertUnorderedList  : { visible : true },
	      insertHorizontalRule : { visible : true },

	      h4mozilla : { visible : true && $.browser.mozilla, className : 'h4', command : 'heading', arguments : ['h4'], tags : ['h4'], tooltip : "Header 4" },
	      h5mozilla : { visible : true && $.browser.mozilla, className : 'h5', command : 'heading', arguments : ['h5'], tags : ['h5'], tooltip : "Header 5" },
	      h6mozilla : { visible : true && $.browser.mozilla, className : 'h6', command : 'heading', arguments : ['h6'], tags : ['h6'], tooltip : "Header 6" },

	      h4 : { visible : true && !( $.browser.mozilla ), className : 'h4', command : 'formatBlock', arguments : ['<H4>'], tags : ['h4'], tooltip : "Header 4" },
	      h5 : { visible : true && !( $.browser.mozilla ), className : 'h5', command : 'formatBlock', arguments : ['<H5>'], tags : ['h5'], tooltip : "Header 5" },
	      h6 : { visible : true && !( $.browser.mozilla ), className : 'h6', command : 'formatBlock', arguments : ['<H6>'], tags : ['h6'], tooltip : "Header 6" },

	      separator07 : { visible : true },

	      cut   : { visible : true },
	      copy  : { visible : true },
	      paste : { visible : true }
	    }
	  });


		});
	</script>
	<script type="text/javascript">
	  var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
	  document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
	</script>
	<script type="text/javascript">
	  try {
	  var pageTracker = _gat._getTracker("UA-11821299-1");
	  pageTracker._trackPageview();
	  } catch(err) {}
	</script>

</form:form>

</body>
</html>
