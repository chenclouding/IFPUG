function change(){
   if(!document.all)
      return
   if (event.srcElement.id=="folder") {
      var srcIndex = event.srcElement.sourceIndex
      var nested = document.all[srcIndex+3]
      if (nested.style.display=="none") {
         nested.style.display=""
		 }
      else {
         nested.style.display="none"
      }
   }
}
document.onclick=change
