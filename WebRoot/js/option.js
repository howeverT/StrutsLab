//根据id删除信息
function deleteUser(planeId){
	if(confirm("你确定删除该订票信息吗?")){
		location.href="deleteAction?id="+planeId;
	}
}

//修改，现根据id查询用户详细信息，以供修改
function updateDetails(planeId){
	//调用queryActionById
	location.href="queryAction?id="+planeId;
}

