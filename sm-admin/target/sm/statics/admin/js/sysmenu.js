		var vue = new Vue({
		el : '#content',
		data : {
			tableId : 'table',
			sysMenu : {},
			modalId : 'form-modal',
			modalTitle : ""
		},
		methods : {
			addForm : function() {
				vue.sysMenu = {};
				vue.modalTitle = "新增";
				$('#' + vue.modalId).modal('show');
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysmenu/info/");
					$.get(url+ id, function (r) {
						vue.sysMenu=r.sysMenu;
						vue.modalTitle="修改信息";
						$('#' + vue.modalId).modal('show');
				    });
					if(vue.sysMenu==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysmenu/delete");
						$.ajax({
							type : "POST",
							url : url,
							contentType : "application/json",
							data : JSON.stringify(id),
							success : function(r) {
								if (r.code == 0) {
									vue.reload();
								} else {
									alert(r.msg);
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
				var url = vue.sysMenu.id == null ? transUrl("/sysmenu/save") : transUrl("/sysmenu/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysMenu),
					success : function(r) {
						if (r.code === 0) {
							vue.reload();
						} else {
							alert(r.msg);
						}
						$('#' + vue.modalId).modal('hide');
					}
				});
			},
			reload : function() {
				var table=$("tr.selected").eq(0).closest("table");
				if(table.length==0){
				table=$('#' + vue.tableId);
				}
				$(table).bootstrapTable('refresh', {query:{
					searchField : $("#searchField").val(),
					searchText : $("#searchText").val(),
					startTime : "",
					endTime : ""
				},'silent': true});
			},
			timeQuery : function() {
				$('#' + vue.tableId).bootstrapTable('refresh', {query:{
					searchField : "",
					searchText : "",
					startTime : $("#startTime").val(),
					endTime : $("#endTime").val()
				},'silent': true});
			},
			exportData : function(exportType) {
				$('#' + vue.tableId).tableExport({
					type : exportType,
					escape : 'false',
					fileName : 'sysMenu'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/sysmenu/list");
		var table = new BSTable(vue.$data.tableId, url,
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
				url : {
					required : true
				},
				perms : {
					required : true
				},
				type : {
					required : true
				},
				icon : {
					required : true
				},
				orderNum : {
					required : true
				},
				status : {
					required : true
				},
				updateId : {
					required : true
				},
				updateTime : {
					required : true
				}			},
			messages : {
				parentId : {
					required : "请填写父菜单ID，一级菜单为0"
				},
				name : {
					required : "请填写菜单名称"
				},
				url : {
					required : "请填写菜单URL"
				},
				perms : {
					required : "请填写授权(多个用逗号分隔，如：user:list,user:create)"
				},
				type : {
					required : "请填写类型   0：目录   1：菜单   2：按钮"
				},
				icon : {
					required : "请填写菜单图标"
				},
				orderNum : {
					required : "请填写排序"
				},
				status : {
					required : "请填写"
				},
				updateId : {
					required : "请填写创建者ID"
				},
				updateTime : {
					required : "请填写创建时间"
				}			},
			submitHandler : function(form) {
				vue.saveOrUpdate();
			},
			errorPlacement : function(error, element) {
				error.appendTo(element.parent().next());
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
				return autoId(vue.$data.tableId, index);
		}}, 	{
			title : '主键',
			field : 'id',
			align : 'left',
			visible : false,
			valign : 'middle'
		},{
			title : '父菜单ID，一级菜单为0',
			field : 'parentId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '菜单名称',
			field : 'name',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '菜单URL',
			field : 'url',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '授权(多个用逗号分隔，如：user:list,user:create)',
			field : 'perms',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '类型   0：目录   1：菜单   2：按钮',
			field : 'type',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '菜单图标',
			field : 'icon',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '排序',
			field : 'orderNum',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '',
			field : 'status',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '创建者ID',
			field : 'updateId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '创建时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		} ];
	};
