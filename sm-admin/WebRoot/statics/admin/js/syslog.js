		var vue = new Vue({
		el : '#content',
		data : {
			tableId : 'table',
			sysLog : {},
			modalId : 'form-modal',
			modalTitle : ""
		},
		methods : {
			addForm : function() {
				vue.sysLog = {};
				vue.modalTitle = "新增";
				$('#' + vue.modalId).modal('show');
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/syslog/info/");
					$.get(url+ id, function (r) {
						vue.sysLog=r.sysLog;
						vue.modalTitle="修改信息";
						$('#' + vue.modalId).modal('show');
				    });
					if(vue.sysLog==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/syslog/delete");
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
				var url = vue.sysLog.id == null ? transUrl("/syslog/save") : transUrl("/syslog/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.sysLog),
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
					fileName : 'sysLog'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/syslog/list");
		var table = new BSTable(vue.$data.tableId, url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				username : {
					required : true
				},
				operation : {
					required : true
				},
				method : {
					required : true
				},
				params : {
					required : true
				},
				ip : {
					required : true
				},
				createId : {
					required : true
				},
				createTime : {
					required : true
				}			},
			messages : {
				username : {
					required : "请填写用户名"
				},
				operation : {
					required : "请填写用户操作"
				},
				method : {
					required : "请填写请求方法"
				},
				params : {
					required : "请填写请求参数"
				},
				ip : {
					required : "请填写IP地址"
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
			title : '用户名',
			field : 'username',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '用户操作',
			field : 'operation',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '请求方法',
			field : 'method',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '请求参数',
			field : 'params',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : 'IP地址',
			field : 'ip',
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
