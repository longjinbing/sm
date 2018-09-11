		var vue = new Vue({
		el : '#main',
		data : {
			constiutionQuestion : {},
			questionList:[],
			w:400,
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
			},
			init:function(){
				var w=$(window).width();
				var that=this
				$('.question').each(function(){
					$(this).width(w);
				});
			}
		},
		created:function(){
			this.getQuestion();
			this.init();
		}
	});
$(function(){
			var answer=$("div.answer-container").eq(0);
			var question=$("div.question-container").eq(0);
					var w=$(window).width();
					$("body").on("click",".list-group-item",function(){
						$(this).addClass("select");
						$(this).siblings().removeClass("select");
						var input=$(this).parent().next("input[type=hidden]");
						input.val($(this).attr("value")).change();
						/*input.attr("name","question"+input.attr("id"))*/
						var index=parseInt($(this).parent().parent().prev().children(".question-no").html());
						answer.find("li").eq(index-1).addClass("complete");
						if(index<vue.$data.questionList.length){
						question.animate({marginLeft:-w*index+"px"},500);
						}else{
							if($(".complete").length<vue.$data.questionList.length){
								$(".answer-item").each(function(){
									if(!$(this).hasClass("complete")){
										var index=parseInt($(this).children("small").html());
										question.animate({marginLeft:-w*(index-1)+"px"},500);
										return false;
									}
								});
							}else{
								var result=[];
								var formData=$("#questionform").serialize();
								var url=transUrl("/api/constitution/saveresult");
								 $.ajax({
									  type: "POST",
									  url: url,
									  processData:true,
									  data:formData,
									  success: function(data){
									   $("#result").html("保存成功");
									  }
									 });
								console.log(result);
							}
						}
					}).on("click",".answer-item",function(){
						var index=parseInt($(this).children("small").html());
						question.animate({marginLeft:-w*(index-1)+"px"},500);
					});
					
					setTimeout(function(){
						$(".list-group").each(function(){
						$(this).children().eq(0).click();
					})
					},2000)
			
		})