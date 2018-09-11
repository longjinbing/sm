	
var vue = new Vue({
		el : '#main',
		data : {
			cmsArticle : {},
			catogryList:[]
		},
		methods : {
			addForm : function() {
				vue.cmsArticle = {};
				this.getCatogry();
				UE.getEditor('editor');
				openWindow({"content":transUrl("/article/add"),"title":"新增文章"});
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					openWindow({"content":transUrl("/article/update/"+id),"title":"编辑文章"});
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/cmscatogry/info/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.cmsCatogry = r.cmsCatogry;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			issueBatch : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要发布选中的记录？', function() {
						var url=transUrl("/cmsarticle/issue");
						$.ajax({
							type : "POST",
							url : url,
							contentType : "application/json",
							data : JSON.stringify(id),
							success : function(r) {
								if(check(r)){
									vue.reload();
									tips("发布成功");
								}
							},
							error : function() {
								alert("网络错误，请稍后重试");
							}
						});
					});
				}
			},
			pauseIssue : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要暂存选中的记录？', function() {
						var url=transUrl("/cmsarticle/pause");
						$.ajax({
							type : "POST",
							url : url,
							contentType : "application/json",
							data : JSON.stringify(id),
							success : function(r) {
								if(check(r)){
									vue.reload();
									tips("暂存成功");
								}
							},
							error : function() {
								alert("网络错误，请稍后重试");
							}
						});
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/cmsarticle/delete");
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
				var url = vue.cmsArticle.id == null ? transUrl("/cmsarticle/save") : transUrl("/cmsarticle/update");
				vue.cmsArticle.content=UE.getEditor('editor').getContent();
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.cmsArticle),
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
					fileName : 'cmsArticle'
				})
			},
			getCatogry:function(){
				var url=transUrl("/cmscatogry/queryAll");
				$.get(url, function (r) {
					if(check(r)){
					vue.catogryList=r.list;
					}
			    });
			},
		}
	});
	$(function() {
		var url=transUrl("/cmsarticle/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				title : {
					required : true
				},
				url : {
					required : true
				},
				content : {
					required : true
				},
				viewcount : {
					required : true
				},
				commentcount : {
					required : true
				},
				orderNum : {
					required : true
				},
				status : {
					required : true
				},
				createTime : {
					required : true
				},
				createId : {
					required : true
				},
				updateTime : {
					required : true
				},
				catogryId : {
					required : true
				}			},
			messages : {
				title : {
					required : "请填写文章标题"
				},
				url : {
					required : "请填写图片url"
				},
				content : {
					required : "请填写文件内容"
				},
				viewcount : {
					required : "请填写浏览数"
				},
				commentcount : {
					required : "请填写评论数"
				},
				orderNum : {
					required : "请填写排序"
				},
				status : {
					required : "请填写状态"
				},
				createTime : {
					required : "请填写创建时间"
				},
				createId : {
					required : "请填写创建者"
				},
				updateTime : {
					required : "请填写更新时间"
				},
				catogryId : {
					required : "请填写类别Id"
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
		}}, 	{
			title : '主键',
			field : 'id',
			align : 'left',
			visible : false,
			valign : 'middle'
		},{
			title : '文章标题',
			field : 'title',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'20%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},{
			title : '图片url',
			field : 'url',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" url="'+value+'" onclick="viewPicture(this)">查看</<button>';
			}
		},{
			title : '文件内容',
			field : 'content',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" onclick="mobileView(this)">预览</button><div class="mobilewrap">'+value+'</div>';
			}
		},{
			title : '浏览数',
			field : 'viewcount',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},{
			title : '评论数',
			field : 'commentcount',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
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
			width:'5%',
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
			width:'10%',
			formatter:function(value,row,index){
				if(value==1){
					return '<span class="text-success">已发布</span>';
				}else if(value==2){
					return '<span class="text-default">暂存</span>';
				};
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
			title : '创建者',
			field : 'createId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'8%',
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
		}];
	};
