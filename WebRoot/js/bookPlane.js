			function isRadio(){ 
				var radios = document.getElementsByName("sex"); 
				var value = 0; 
				for(var i=0;i<radios.length;i++){ 
					if(radios[i].checked == true){ 
						value = radios[i].value; 
						} 
					} 
					return value;
			}
			function isDate(dateString){
				if(dateString.trim()=="")return false;
				var r=dateString.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/); 
				if(r==null){
					//document.getElementById("alda").innerHTML="输入正确的日期,如：2008-08-08";
				return false;
				}
				var d=new Date();
				//var d=new Date(r[1],r[3]-1,r[4]);  
				//var num = (d.getFullYear()==r[1]&&(d.getMonth()+1)==r[3]&&d.getDate()==r[4]);
				if((d.getMonth()+1)<r[3]){
					var x=((d.getMonth()+1)<r[3]&&1);
				}
				else if((d.getMonth()+1)==r[3]){
					var x=((d.getMonth()+1)==r[3]&&d.getDate()<=r[4])
				}
				//alert(r[4],getDate(),r[3],getMonth());
				var num = (d.getFullYear()<=r[1]&&x);
				if(num==0){
					alert("出发日期为今日以后");
					
					return false;
					//document.getElementById("alda").innerHTML="输入正确的日期,如：2008-08-08";
				}
				return (num!=0);
			} 
			function check(){
				var na=true;
				var se=true;
				var sc=true;
				var dc=true;
				var id=true;
				var da=true;
				if(document.getElementById("na").value.length<2){
					na=false;
					document.getElementById("alna").innerHTML="*姓名为空或错误";
				}
				else{
					document.getElementById("alna").innerHTML="";
				}
				if(isRadio()==0){
					se=false;
					document.getElementById("alse").innerHTML="*请选择性别";
				}
				else{
					document.getElementById("alse").innerHTML="";
				}
				if(document.getElementById("scity").value.length<2){
					document.getElementById("alsc").innerHTML="*输入正确的城市";
					sc=false;
				}else{
					document.getElementById("alsc").innerHTML="";
				}
				if(document.getElementById("dcity").value.length<2){
					document.getElementById("aldc").innerHTML="*输入正确的城市";
					dc=false;
				}
				else{
					document.getElementById("aldc").innerHTML="";
				}
				if(document.getElementById("ident").value.length!=18){
					document.getElementById("alid").innerHTML="*输入18位身份证号";
					id=false;
				}else{
					document.getElementById("alid").innerHTML="";
				}
				if(!isDate(document.getElementById("date").value)){
					document.getElementById("alda").innerHTML="*格式：2018-08-08";
					da=false;
				}
				else{
					document.getElementById("alda").innerHTML="";
				}
				if(!na||!se||!sc||!dc||!id||!da){
					return false;
				}
				else{
					return true;
				}
			}