
function alai_imagelist()
{try{
	var item=[]
	count=0
	this.path=""
	this.type="gif"
	this.err=""
	iml=this
	this.copywrite="Copywrite by Alai(Àµ¹úÐÀ) (c)2003£¬All right reserved!"
	this.add=function(src,key)
	{
		var img=new Image()
		if(src==null || src=="")return
		if(src.indexOf("/")==-1)src=iml.path+src
		if(!(/\.gif$|\.jpg$|\.png$|\.bmp$/i).test(src))src+="."+iml.type
		if(key==null || key=="")key=src.replace(/(.*\/){0,}([^\.]+).*/ig,"$2")
		item[count]=img;img.index=count;item[key]=img;count++;
		img.onerror=function()
		{
			alert("alai_imagelist cause run time error:\nImage file "+img.src+" not found!")
			item[img.index]=null;item[key]=null;count--;
		}
		img.src=src
		return img
	}
	this.item=item
	this.count=function(){return count;}
}
catch(e){
	iml.err="alai_imagelist cause run time error!\nError number:"+e.number+".\nError description:"+e.description;
	iml.err+="\n    -- \nYou can send the case and error description message to A@lai.com.cn for support.Please visit http://www.9499.net to get the last release!"
	alert(iml.err);
	return iml;
}
}