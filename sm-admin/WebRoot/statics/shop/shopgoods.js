		var vue = new Vue({
		el : '#content',
		data : {
			shopGoods : {},
			shopCategoryList:[]
		},
		methods : {
			getCategory:function(){
				var url=transUrl("/shopcategory/queryAll");
				$.get(url, function (r) {
					if(check(r)){
					vue.shopCategoryList=r.list;
					vue.$data.shopCategoryList[0].selected="selected";
					}
			    });
			},
			addForm : function() {
				vue.shopGoods = {};
				vue.getCategory();
				var ue = UE.getEditor("editor");
				openForm("新增",1100);
				refershitem();
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/shopgoods/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.shopGoods=r.shopGoods;
						vue.getCategory();
						var ue = UE.getEditor("editor");
						setTimeout(function(){
							ue.setContent(r.shopGoods.goodsDesc);
						},500);
						$.each(vue.$data.shopCategoryList,function(index,item){
							if(r.shopGoods.categoryId==item.id){
								vue.$data.shopCategoryList[index].selected="selected";
								return false;
							}
						});
						openForm("修改信息",1100);
						refershitem();
						}
				    });
					if(vue.shopGoods==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/shopgoods/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.shopGoods= r.shopGoods;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/shopgoods/delete");
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
				var url = vue.shopGoods.id == null ? transUrl("/shopgoods/save") : transUrl("/shopgoods/update");
				vue.shopGoods.goodsDesc = UE.getEditor("editor").getContent();
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.shopGoods),
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
					fileName : 'shopGoods'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/shopgoods/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				categoryId : {
					required : true
				},
				goodsSn : {
					required : true
				},
				title : {
					required : true
				},
				goodsDesc : {
					required : true
				},
				primaryPicUrl : {
					required : true
				},
				listPicUrl : {
					required : true
				},
				sellNumber : {
					required : true
				},
				character : {
					required : true
				},
				price : {
					required : true
				},
				marketPrice : {
					required : true
				},
				shippingFee : {
					required : true
				}			},
			messages : {
				categoryId : {
					required : "请填写分类ID"
				},
				goodsSn : {
					required : "请填写商品编号"
				},
				title : {
					required : "请填写标题"
				},
				goodsDesc : {
					required : "请填写商品描述"
				},
				primaryPicUrl : {
					required : "请填写商品主图"
				},
				listPicUrl : {
					required : "请填写商品列表图"
				},
				sellNumber : {
					required : "请填写销售量"
				},
				character : {
					required : "请填写特点"
				},
				price : {
					required : "请填写价格"
				},
				marketPrice : {
					required : "请填写市场价格"
				},
				shippingFee : {
					required : "请填写邮费"
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
		}}, {
			title : '商品编号',
			field : 'goodsSn',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '标题',
			field : 'title',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,15);
			}
		},			{
			title : '商品描述',
			field : 'goodsDesc',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" onclick="mobileView(this)">预览</button><div class="mobilewrap">'+value+'</div>';
			}
		},			{
			title : '商品主图',
			field : 'primaryPicUrl',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" url="'+value+'" onclick="viewPicture(this)">查看</<button>';
			}
		},			{
			title : '商品列表图',
			field : 'listPicUrl',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return '<button class="btn btn-xs btn-success" url="'+value+'" onclick="viewPicture(this)">查看</<button>';
			}
		},			{
			title : '销售量',
			field : 'sellNumber',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'4%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '特点',
			field : 'character',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,15);
			}
		},			{
			title : '价格',
			field : 'price',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'4%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '市场价格',
			field : 'marketPrice',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'4%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '添加时间',
			field : 'createTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '修改时间',
			field : 'updateTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'12%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '邮费',
			field : 'shippingFee',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'5%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		} ];
	};
