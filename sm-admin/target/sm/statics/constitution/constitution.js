		var vue = new Vue({
		el : '#content',
		data : {
			constitution : {}
		},
		methods : {
			addForm : function() {
				vue.constitution = {};
				var desc = UM.getEditor('descumeditor');
				desc.addListener('blur',function(){
					vue.constitution.desc=desc.getContent();
			    });
				var character = UM.getEditor('character-umeditor');
				character.addListener('blur',function(){
					vue.constitution.character=character.getContent();
			    });
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/constitution/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.constitution=r.constitution;
						var desc = UM.getEditor('descumeditor');
						desc.addListener('blur',function(){
							vue.constitution.desc=desc.getContent();
					    });
						var character = UM.getEditor('character-umeditor');
						character.addListener('blur',function(){
							vue.constitution.character=character.getContent();
					    });
						setTimeout(function(){
							desc.setContent(vue.constitution.desc);
							character.setContent(vue.constitution.character);
						},500)
						openForm("修改信息");
						}
				    });
					if(vue.constitution==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/constitution/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.constitution= r.constitution;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/constitution/delete");
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
				var url = vue.constitution.id == null ? transUrl("/constitution/save") : transUrl("/constitution/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.constitution),
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
					fileName : 'constitution'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/constitution/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				name : {
					required : true
				},
				desc : {
					required : true
				},
				character : {
					required : true
				},
			},
			messages : {
				name : {
					required : "请填写体质名称"
				},
				desc : {
					required : "请填写体质描述"
				},
				character : {
					required : "请填写体质特征"
				},
			},
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
			title : '体质名称',
			field : 'name',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '体质描述',
			field : 'desc',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" onclick="mobileView(this)">预览</button><div class="mobilewrap">'+value+'</div>';
			}
		},			{
			title : '体质特征',
			field : 'character',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" onclick="mobileView(this)">预览</button><div class="mobilewrap">'+value+'</div>';
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
		},			{
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
		}, ];
	};
