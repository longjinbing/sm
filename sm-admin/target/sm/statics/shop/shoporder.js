		var vue = new Vue({
		el : '#content',
		data : {
			shopOrder : {}
		},
		methods : {
			addForm : function() {
				vue.shopOrder = {};
				openForm("新增");
			},
			editForm : function() {
				var id=getSelectedRow();
				if (id != '') {
					var url=transUrl("/shoporder/info/");
					$.get(url+ id, function (r) {
						if(check(r)){
						vue.shopOrder=r.shopOrder;
						openForm("修改信息");
						}
				    });
					if(vue.shopOrder==null){alert("网络错误")}
				}
				
			},
			details:function(){
				var id = getSelectedRow();
				if (id != '') {
					var url = transUrl("/shoporder/details/")+id;
					$.get(url, function(r) {
						if (check(r)) {
							vue.shopOrder= r.shopOrder;
							openForm("查看详情",550,"detailswrap");
						}
					});
				}
			},
			deleteData : function() {
				var id = getSelectedRows();
				if (id != '') {
					confirm('确定要删除选中的记录？', function() {
						var url=transUrl("/shoporder/delete");
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
				var url = vue.shopOrder.id == null ? transUrl("/shoporder/save") : transUrl("/shoporder/update");
				$.ajax({
					type : "POST",
					url : url,
					contentType : "application/json",
					data : JSON.stringify(vue.shopOrder),
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
					fileName : 'shopOrder'
				})
			}
		}
	});
	$(function() {
		var url=transUrl("/shoporder/list");
		var table = new BSTable("datatable", url,
				initColumn());
		table.init();
		$("#modal-form").validate({
			rules : {			
				orderSn : {
					required : true
				},
				userId : {
					required : true
				},
				status : {
					required : true
				},
				payStatus : {
					required : true
				},
				country : {
					required : true
				},
				province : {
					required : true
				},
				city : {
					required : true
				},
				district : {
					required : true
				},
				address : {
					required : true
				},
				phone : {
					required : true
				},
				postscript : {
					required : true
				},
				shippingFee : {
					required : true
				},
				actualPrice : {
					required : true
				},
				orderPrice : {
					required : true
				},
				goodsPrice : {
					required : true
				},
				payTime : {
					required : true
				},
				freightPrice : {
					required : true
				},
				parentId : {
					required : true
				}			},
			messages : {
				orderSn : {
					required : "请填写订单号"
				},
				userId : {
					required : "请填写用户id"
				},
				status : {
					required : "请填写状态"
				},
				payStatus : {
					required : "请填写支付状态"
				},
				country : {
					required : "请填写国家"
				},
				province : {
					required : "请填写省份"
				},
				city : {
					required : "请填写城市"
				},
				district : {
					required : "请填写区"
				},
				address : {
					required : "请填写详细地址"
				},
				phone : {
					required : "请填写手机号"
				},
				postscript : {
					required : "请填写邮编"
				},
				shippingFee : {
					required : "请填写邮费"
				},
				actualPrice : {
					required : "请填写实际需要支付的金额"
				},
				orderPrice : {
					required : "请填写订单总价"
				},
				goodsPrice : {
					required : "请填写商品总价"
				},
				payTime : {
					required : "请填写支付时间"
				},
				freightPrice : {
					required : "请填写配送费用"
				},
				parentId : {
					required : "请填写总订单Id"
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
			title : '订单号',
			field : 'orderSn',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '用户id',
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
			title : '状态',
			field : 'status',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '支付状态',
			field : 'payStatus',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '国家',
			field : 'country',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '省份',
			field : 'province',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '城市',
			field : 'city',
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
			field : 'district',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '详细地址',
			field : 'address',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '手机号',
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
			field : 'postscript',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
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
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '实际需要支付的金额',
			field : 'actualPrice',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '订单总价',
			field : 'orderPrice',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '商品总价',
			field : 'goodsPrice',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '下单时间',
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
		},			{
			title : '支付时间',
			field : 'payTime',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '配送费用',
			field : 'freightPrice',
			align : 'left',
			visible : true,
			sortable:true,
			valign : 'middle',
			width:'15%',
			formatter:function(value,row,index){
				return overflowHidden(value,25);
			}
		},			{
			title : '总订单Id',
			field : 'parentId',
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
