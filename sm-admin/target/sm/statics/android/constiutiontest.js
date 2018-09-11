		var vue = new Vue({
		el : '#main',
		data : {
			title : $("title").html(),
			constiutionQuestion : {},
			questionList:[],
			result:[]
		},
		methods : {
			getQuestion:function(){
				var url=transUrl("/constiutionquestion/queryAll");
				$.get(url, function (r) {
					if(check(r)){
					vue.questionList=r.list;
					}
			    });
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
			}
		},
		created:function(){
			this.getQuestion();
			var url=transUrl("/sysrolemenu/menulist/2");
			$.ajax({
				  url: url,
				  data: '',
				  success: function(r){
					  if(check(r)){
					  }
				  },
				  error:function(r){
					  var data=r.responseText;
					  data=eval('('+data+')');
					  check(data);
				  }
				});
		}
	});
$(function(){
			var answer=$("div.answer-container").eq(0);
			var question=$("div.question-container").eq(0);
					$("body").on("click",".list-group-item",function(){
						$(this).addClass("select");
						$(this).siblings().removeClass("select");
						var input=$(this).parent().next("input[type=hidden]");
						input.val($(this).attr("value")).change();
						var index=parseInt($(this).parent().parent().prev().children(".question-no").html());
						answer.find("li").eq(index-1).addClass("complete");
						if(index<vue.$data.questionList.length){
							question.children("form").children().eq(index).addClass("currentquestion").siblings().removeClass("currentquestion");
						/*question.animate({marginLeft:-w*index+"px"},500);*/
						}else{
							if($(".complete").length<vue.$data.questionList.length){
								$(".answer-item").each(function(){
									if(!$(this).hasClass("complete")){
										var index=parseInt($(this).children("small").html());
										question.children("form").children().eq(index-1).addClass("currentquestion").siblings().removeClass("currentquestion");
										/*question.animate({marginLeft:-w*(index-1)+"px"},500);*/
										return false;
									}
								});
							}else{
								var index = layer.load(1, {
									  shade: [0.5,'black'] //0.1透明度的白色背景
									});
								var formData=$("#questionform").serialize();
								var url=transUrl("/api/constitution/saveresult");
								$.ajax({
									type : "Get",
									url : url,
									contentType : "application/json",
									data : formData,
									success : function(r) {
										layer.close(index);
										if(check(r)){
											if(r.code==-1){
												window.top.location.href=transUrl("/android/failure.html");
											}else{
												window.top.location.href=transUrl("/android/success.html");
											}
										}
									},
									error : function() {
										alert("网络错误，请稍后重试");
									}
								});
							}
						}
					}).on("click",".answer-item",function(){
						var index=parseInt($(this).children("small").html());
						question.children("form").children().eq(index-1).addClass("currentquestion").siblings().removeClass("currentquestion");
					});
			
		})