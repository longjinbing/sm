		var vue = new Vue({
		el : '#content',
		data : {
			shopAddress : {}
		},
		methods : {
			addForm : function() {
				vue.shopAddress = {};
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/shopaddress/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.shopAddress=r.shopAddress;
						openForm("修改信息");
						}
				    });
					if(vue.shopAddress==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/shopaddress/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.shopAddress= r.shopAddress;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/shopaddress/delete");
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
				var url = vue.shopAddress.id == null ? transUrl("/shopaddress/save") : transUrl("/shopaddress/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.shopAddress),
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
					fileName : 'shopAddress'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/shopaddress/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				userId : {
					required : true
				},
				phone : {
					required : true
				},
				postalCode : {
					required : true
				},
				nationalCode : {
					required : true
				},
				provinceName : {
					required : true
				},
				cityName : {
					required : true
				},
				countyName : {
					required : true
				},
				detailInfo : {
					required : true
				},
				isDefault : {
					required : true
				}			},
			messages : {
				userId : {
					required : "请填写会员ID"
				},
				phone : {
					required : "请填写手机"
				},
				postalCode : {
					required : "请填写邮编"
				},
				nationalCode : {
					required : "请填写收货地址国家码"
				},
				provinceName : {
					required : "请填写省"
				},
				cityName : {
					required : "请填写市"
				},
				countyName : {
					required : "请填写区"
				},
				detailInfo : {
					required : "请填写详细收货地址信息"
				},
				isDefault : {
					required : "请填写是否是默认地址"
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
			title : '会员ID',
			field : 'userId',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '手机',
			field : 'phone',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '邮编',
			field : 'postalCode',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '收货地址国家码',
			field : 'nationalCode',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '省',
			field : 'provinceName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '市',
			field : 'cityName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '区',
			field : 'countyName',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '详细收货地址信息',
			field : 'detailInfo',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '是否是默认地址',
			field : 'isDefault',
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
