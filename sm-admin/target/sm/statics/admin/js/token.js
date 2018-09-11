		var vue = new Vue({
		el : '#content',
		data : {
			tableId : 'table',
			token : {},
			modalId : 'form-modal',
			modalTitle : ""
		},
		methods : {
			addForm : function() {
				vue.token = {};
				vue.modalTitle = "新增";
				$('#' + vue.modalId).modal('show');
			},
			editForm : function() {
				var userId=getSelectedRow();
				if (userId != '') {
					var url=transUrl("/token/info/");
					$.get(url+ userId, function (r) {
						vue.token=r.token;
						vue.modalTitle="修改信息";
						$('#' + vue.modalId).modal('show');
				    });
					if(vue.token==null){alert("网络错误")}
				}
				
			},
			deleteData : function() {
				var userId = getSelectedRows();
				if (userId != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/token/delete");
						$.ajax({
							type : "POST",
							url : url,
							contentType : "application/json",
							data : JSON.stringify(userId),
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
				var url = vue.token.userId == null ? transUrl("/token/save") : transUrl("/token/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.token),
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
					fileName : 'token'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/token/list");
		var table = new BSTable(vue.$data.tableId, url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				token : {
					required : true
				},
				expireTime : {
					required : true
				},
				updateTime : {
					required : true
				}			},
			messages : {
				token : {
					required : "请填写token"
				},
				expireTime : {
					required : "请填写过期时间"
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
			field : 'userId',
			align : 'left',
			visible : false,
			valign : 'middle'
		},{
			title : 'token',
			field : 'token',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle'
		},{
			title : '过期时间',
			field : 'expireTime',
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
