		var vue = new Vue({
		el : '#content',
		data : {
			shopCategory : {},
			parentId:0
		},
		methods : {
			addForm : function() {
				vue.shopCategory = {};
				vue.shopCategory.parentId=vue.parentId;
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/shopcategory/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.shopCategory=r.shopCategory;
						openForm("修改信息");
						}
				    });
					if(vue.shopCategory==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/shopcategory/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.shopCategory= r.shopCategory;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/shopcategory/delete");
						$.ajax({
							type : "POST",
							url : url,
							contentType : "application/json",
							data : JSON.stringify(id),
							success : function(r) {
								if(check(r)){
									vue.reload();
									tips("删除成功");
								}
							},
							error : function() {
								alert("网络错误，请稍后重试");
							}
						});
					});
				}
			},
			saveOrUpdate : function() {
				var url = vue.shopCategory.id == null ? transUrl("/shopcategory/save") : transUrl("/shopcategory/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.shopCategory),
					success : function(r) {
						if(check(r)){
							vue.reload();
							closeForm();
							tips("操作成功");
						}
					}
				});
			},
			reload : function() {
				var table=$("tr.selected").eq(0).closest("table");
				table=table.length==0?$('#datatable'):table;
				table.bootstrapTable('refresh', {query:{
					searchField : $("#searchField").val(),
					searchText : $("#searchText").val(),
					startTime : "",
					endTime : ""
				},'silent': true});
				var zTreeObj = $.fn.zTree.getZTreeObj("catogry-tree");
				zTreeObj.destroy();
				$.get(transUrl("/shopcategory/ztreelist"),function(r){
					var zNodes=r.selectlist;
					/*获取服务器数据*/
					zTreeObj = $.fn.zTree.init($("#catogry-tree"), setting, zNodes);
				})
			},
			timeQuery : function() {
				$('#datatable').bootstrapTable('refresh', {query:{
					searchField : "",
					searchText : "",
					startTime : $("#startTime").val(),
					endTime : $("#endTime").val()
				},'silent': true});
			},
			exportData : function(exportType) {
				$('#datatable').tableExport({
					type : exportType,
					escape : 'false',
					fileName : 'shopCategory'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/shopcategory/list?id=0");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				name : {
					required : true
				},
				parentId : {
					required : true
				},
				orderNum : {
					required : true
				},
				iconUrl : {
					required : true
				},
				status : {
					required : true
				}			},
			messages : {
				name : {
					required : "请填写名称"
				},
				parentId : {
					required : "请填写父Id"
				},
				orderNum : {
					required : "排序"
				},
				iconUrl : {
					required : "请填写图标"
				},
				status : {
					required : "请填写状态"
				}			},
			submitHandler : function(form) {
				vue.saveOrUpdate();
			},
			errorPlacement : function(error, element) {
				tipError(error, element);
			}
		});
	});
	var initColumn = function() {
		return [ {
			checkbox : true
		}, 	{
			title : '序号',
			field : 'id',
			align : 'left',
			visible : true,
			valign : 'middle',
			formatter : function(value, row, index) {
				return autoId("datatable", index);
		}}, 
			{
			title : '名称',
			field : 'name',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'40%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '排序',
			field : 'orderNum',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '图标',
			field : 'iconUrl',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '状态',
			field : 'status',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'30%',
			formatter:function(value,row,index){
				if(value==1){
					return '<span class="btn btn-xs btn-success">正常</span>';
				}else{
					return '<span class="btn btn-xs btn-warning">无效</span>';
				};
			}
		} ];
	};
	var setting = {
			 view: {
	         selectedMulti: false
	     },
	     data: {
	         simpleData: {
	             enable: true
	         }
	     },
	     edit: {
	         enable: false
	     },
			check:{
				enable: false,
				chkStyle: "checkbox",
				chkboxType: { "Y": "p", "N": "s" }
			},
			callback: {
				onClick: zTreeOnClick
			}
	};
	$.get(transUrl("/shopcategory/ztreelist"),function(r){
		var zNodes=r.selectlist;
		console.log(zNodes)
		/*获取服务器数据*/
		var zTreeObj = $.fn.zTree.init($("#catogry-tree"), setting, zNodes);
	})
	function zTreeOnClick(event, treeId, treeNode){
		var url=transUrl("/shopcategory/list?id=")+treeNode.id;
		$('#datatable').bootstrapTable('refresh', {'silent': true,'url':url});
		vue.$data.parentId=treeNode.id;
		event.preventDefault();
		event.stopPropagation();
	}
