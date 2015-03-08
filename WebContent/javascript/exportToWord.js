
/*
Use example
<XX id="Layer1">
	<input type=button name='button_export' title='ExportToWord' onclick=AllContentToWord(Layer1) value="Export to word">
</XX>
*/
//export the content of the body label to word 
function AllContentToWord(id) {
    id.style.border = 0;
    ExcelSheet = new ActiveXObject("Word.Application");
    ExcelSheet.Application.Visible = true;
    var mydoc = ExcelSheet.Documents.Add("", 0, 1);
    myRange = mydoc.Range(0, 1);
    var sel = id.document.body.createTextRange();
    sel.select();
    id.document.execCommand("Copy");
    sel.moveEnd("character");
    myRange.Paste();
    location.reload();
    ExcelSheet.ActiveWindow.ActivePane.View.Type = 9;
}
/*	Use example
        <input type="button" onclick="javascript:AppointedContentToExcel();" value=" Export to excel">
		<input type="button" onclick="javascript:AppointedContentToWord();" value="Export to word">
		<input type="button" onclick="javascript:CellContentToExcel();" value="Export to excel">*/
//export the appionted content to Excel
function AppointedContentToExcel(id) {
    var oXL = new ActiveXObject("Excel.Application");
    var oWB = oXL.Workbooks.Add();
    var oSheet = oWB.ActiveSheet;
    var sel = document.body.createTextRange();
    sel.moveToElementText(id);
    sel.select();
    sel.execCommand("Copy");
    oSheet.Paste();
    oXL.Visible = true;
}


 //export the appionted content to Word
function AppointedContentToWord(id) {
    var oWD = new ActiveXObject("Word.Application");
    var oDC = oWD.Documents.Add("", 0, 1);
    var oRange = oDC.Range(0, 1);
    var sel = document.body.createTextRange();
    sel.moveToElementText(id);
    sel.select();
    sel.execCommand("Copy");
    oRange.Paste();
    oWD.Application.Visible = true;
  //window.close();
}
 //export the appionted content to Excel without format
function CellContentToExcel(id) {
    var oXL = new ActiveXObject("Excel.Application");
    var oWB = oXL.Workbooks.Add();
    var oSheet = oWB.ActiveSheet;
    var Lenr = id.rows.length;
    for (i = 0; i < Lenr; i++) {
        var Lenc = id.rows(i).cells.length;
        for (j = 0; j < Lenc; j++) {
            oSheet.Cells(i + 1, j + 1).value = id.rows(i).cells(j).innerText;
        }
    }
    oXL.Visible = true;
}

 //save the appionted content to Word
function SaveAppointedContentToWord(id, dir) {
    var oWD = new ActiveXObject("Word.Application");
    var oDC = oWD.Documents.Add("", 0, 1);
    var oRange = oDC.Range(0, 1);
    var sel = document.body.createTextRange();
    sel.moveToElementText(id);
    sel.select();
    sel.execCommand("Copy");
    oRange.Paste();
    oDC.SaveAs(dir);
    oDC.Close();
    oWD.Quit();
}
