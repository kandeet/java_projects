/**
 * 
 */
;(function($) {
	
	$.extend({
		/**
		*参数说明
		*  title - 标题
		*  body - 内容
		*  button - 按钮样式：暂时只有确定取消(SureOrCancel),后期可扩展多种按钮样式
		*  event - 确认按钮的点击事件
		*  eventCancel -取消按钮的点击事件
		*/
		ksfDialog:function (options){
			 options = $.extend({
				 title: '', //标题
				 body: '', // 内容
				 button: '', //按钮样式：暂时只有确定取消(SureOrCancel),后期可扩展多种按钮样式
				 event:function(){
				 },
				 eventCancel:function(){
				 }
	         },options);
	         
	         var dailogHtml='<div class="modal fade" data-backdrop="static" tabindex="-1" role="dialog">'
								+'<div class="modal-dialog modal-sm" role="document">'
								        +'<div class="modal-content">'
								            +'<div class="modal-header">'
								                +'<button class="close" data-dismiss="modal">'
								                    +'<span>&times;</span>'
								                +'</button>'
								                +'<div class="modal-title">'+options.title+'</div>'
								            +'</div>'
								            +'<div class="modal-body">'
								               		+options.body
								            +'</div>'
								            +'<div class="modal-footer">'
												+'<button class="btn btn-danger" data-dismiss="modal"> 确定</button>'
								                +'<button class="btn btn-info" data-dismiss="modal"> 取消</button>'
								            +'</div>'
								         +'</div>'
								  +'</div>'
							+'</div>';
	         var $dialog=$(dailogHtml);
	         $dialog.modal();
	         $dialog.find(".modal-footer .btn-danger").on("click",options.event);
	         $dialog.find(".modal-footer .btn-info").on("click",options.eventCancel);
	         //把添加的dom元素移除
	         $dialog.find(".modal-footer button").on("click",function(){
	        	 $dialog.remove();
	        	 $("div[class='modal-backdrop fade in']").remove();
	         });
	         return this;
		}
	});
})(jQuery);