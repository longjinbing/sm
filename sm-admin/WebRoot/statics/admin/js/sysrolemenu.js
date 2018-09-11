		var vue = new Vue({
		el : '#content',
		data : {
			tableId : 'table',
			sysRoleMenu : {},
			modalId : 'form-modal',
			modalTitle : ""
		},
		methods : {
			addForm : function() {
				vue.sysRoleMenu = {};
				vue.modalTitle = "新增";
				$('#' + vue.modalId).modal('show');
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysrolemenu/info/");
					$.get(url+ id, function (r) {
						vue.sysRoleMenu=r.sysRoleMenu;
						vue.modalTitle="修改信息";
						$('#' + vue.modalId).modal('show');
				    });
					if(vue.sysRoleMenu==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysrolemenu/delete");
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
				var url = vue.sysRoleMenu.id == null ? transUrl("/sysrolemenu/save") : transUrl("/sysrolemenu/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysRoleMenu),
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
					fileName : 'sysRoleMenu'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/sysrolemenu/list");
		var table = new BSTable(vue.$data.tableId, url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				roleId : {
					required : true
				},
				menuId : {
					required : true
				},
				createId : {
					required : true
				},
				createTime : {
					required : true
				}			},
			messages : {
				roleId : {
					required : "请填写角色ID"
				},
				menuId : {
					required : "请填写菜单ID"
				},
				createId : {
					required : "请填写创建者ID"
				},
				createTime : {
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
			title : '角色ID',
			field : 'roleId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '菜单ID',
			field : 'menuId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '创建者ID',
			field : 'createId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '创建时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		} ];
	};
