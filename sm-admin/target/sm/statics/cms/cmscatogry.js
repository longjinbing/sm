		var vue = new Vue({
		el : '#content',
		data : {
			cmsCatogry : {},
			parentId:0
		},
		methods : {
			addForm : function() {
				vue.cmsCatogry = {};
				vue.cmsCatogry.parentId=vue.parentId;
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/cmscatogry/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.cmsCatogry=r.cmsCatogry;
						openForm("修改信息");
						}
				    });
					if(vue.cmsCatogry==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/cmscatogry/delete");
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
				var url = vue.cmsCatogry.id == null ? transUrl("/cmscatogry/save") : transUrl("/cmscatogry/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.cmsCatogry),
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
				$.get(transUrl("/cmscatogry/ztreelist"),function(r){
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
					fileName : 'cmsCatogry'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/cmscatogry/list?id=0");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				parentId : {
					required : true
				},
				name : {
					required : true
				},
				desc : {
					required : true
				},
				orderNum : {
					required : true
				},
				status : {
					required : true
				},
				createId : {
					required : true
				},
				createTime : {
					required : true
				},
				updateTime : {
					required : true
				}			},
			messages : {
				parentId : {
					required : "请填写父Id"
				},
				name : {
					required : "请填写名称"
				},
				desc : {
					required : "请填写"
				},
				orderNum : {
					required : "请填写排序"
				},
				status : {
					required : "请填写状态"
				},
				createId : {
					required : "请填写创建者"
				},
				createTime : {
					required : "请填写创建时间"
				},
				updateTime : {
					required : "请填写"
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
		}},{
			title : '名称',
			field : 'name',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},{
			title : '描述',
			field : 'desc',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},{
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
		},{
			title : '状态',
			field : 'status',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return transMenuStatus(value);
			}
		},{
			title : '创建时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},{
			title : '更新时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
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
	$.get(transUrl("/cmscatogry/ztreelist"),function(r){
		var zNodes=r.selectlist;
		console.log(zNodes)
		/*获取服务器数据*/
		var zTreeObj = $.fn.zTree.init($("#catogry-tree"), setting, zNodes);
	})
	function zTreeOnClick(event, treeId, treeNode){
		var url=transUrl("/cmscatogry/list?id=")+treeNode.id;
		$('#datatable').bootstrapTable('refresh', {'silent': true,'url':url});
		vue.$data.parentId=treeNode.id;
		event.preventDefault();
		event.stopPropagation();
	}