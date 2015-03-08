function change(count){
   if(!document.all)
      return
   if (event.srcElement.id=="foldtable") {
      var srcIndex = event.srcElement.sourceIndex
	  var prev = document.all[srcIndex-1]
	  for(i=0; i<count; i++)
	  {
      var nested = document.all[srcIndex+1+i*4]
      if (nested.style.display=="none") {
         nested.style.display = ""
		 prev.src = "../EnterpriseInformation/image/opened.bmp"
		 }
      else {
         nested.style.display="none"
		 prev.src = "../EnterpriseInformation/image/closed.bmp"
      }
	  }
   }
}

//document.onclick=change