		var vue = new Vue({
		el : '#content',
		data : {
			constiutionQuestion : {},
			constiutionList:[]
		},
		methods : {
			getConstiutionList:function(){
				$.get(transUrl("/constitution/queryAll"), function (r) {
					if(check(r)){
					vue.$data.constiutionList=r.list;
					}
			    });
			},
			addForm : function() {
				vue.constiutionQuestion = {};
				this.getConstiutionList();
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/constiutionquestion/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.$data.constiutionQuestion=r.constiutionQuestion;
						openForm("修改信息");
						vue.getConstiutionList();
						for(var i=0;i<vue.constiutionList.length;i++){
							if(vue.$data.constiutionList[i].id==vue.$data.constiutionQuestion.constiutionId){
								vue.$data.constiutionList[i].selected="selected";
								return false;
							}
						}
						}
				    });
					if(vue.constiutionQuestion==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/constiutionquestion/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.constiutionQuestion= r.constiutionQuestion;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/constiutionquestion/delete");
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
				var url = vue.constiutionQuestion.id == null ? transUrl("/constiutionquestion/save") : transUrl("/constiutionquestion/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.constiutionQuestion),
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
					fileName : 'constiutionQuestion'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/constiutionquestion/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				question : {
					required : true
				}			},
			messages : {
				question : {
					required : "请填写问题"
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
			title : '问题',
			field : 'question',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'70%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
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
		}];
	};
