		var vue = new Vue({
		el : '#content',
		data : {
			tableId : 'table',
			sysUser : {},
			modalId : 'form-modal',
			modalTitle : ""
		},
		methods : {
			addForm : function() {
				vue.sysUser = {};
				vue.modalTitle = "新增";
				$('#' + vue.modalId).modal('show');
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/sysuser/info/");
					$.get(url+ id, function (r) {
						vue.sysUser=r.sysUser;
						vue.modalTitle="修改信息";
						$('#' + vue.modalId).modal('show');
				    });
					if(vue.sysUser==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/sysuser/delete");
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
				var url = vue.sysUser.id == null ? transUrl("/sysuser/save") : transUrl("/sysuser/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysUser),
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
					fileName : 'sysUser'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/sysuser/list");
		var table = new BSTable(vue.$data.tableId, url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				username : {
					required : true
				},
				password : {
					required : true
				},
				email : {
					required : true
				},
				mobile : {
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
				updateId : {
					required : true
				},
				updateTime : {
					required : true
				}			},
			messages : {
				username : {
					required : "请填写用户名"
				},
				password : {
					required : "请填写密码"
				},
				email : {
					required : "请填写邮箱"
				},
				mobile : {
					required : "请填写手机号"
				},
				status : {
					required : "请填写状态  0：禁用   1：正常"
				},
				createId : {
					required : "请填写创建者ID"
				},
				createTime : {
					required : "请填写创建时间"
				},
				updateId : {
					required : "请填写更新者ID"
				},
				updateTime : {
					required : "请填写更新时间"
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
			title : '用户名',
			field : 'username',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '密码',
			field : 'password',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '邮箱',
			field : 'email',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '手机号',
			field : 'mobile',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '状态  0：禁用   1：正常',
			field : 'status',
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
		},{
			title : '更新者ID',
			field : 'updateId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '更新时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		} ];
	};
