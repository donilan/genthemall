var DIV = '<div/>';
var UL = '<ul/>';
var LI = '<li/>';
var A = '<a href="###" />';
var SPAN = '<span/>';
var DEBUG = true;
var SMALL_TEXT_LENGTH = 12;
if(typeof console === 'undefined') {
	window.console = new Object();
	if(DEBUG)
		console.log = alert;
	else
		console.log = function(msg){};
}

/**
 * Cookie存取处理方法
 * @author Doni
 * @since 2012-10-07
 */
function cookie(key, val) {
	var k = 'admin-' + key;
	if(val == undefined || val == null) {
		return $.cookie(k);
	}
	return $.cookie(k, val);
}
/**
 * Init method
 * @author Doni
 * @since 2012-10-07
 */
(function(){
	if(cookie('rows') == null) {
		console.log(cookie('rows', 12));
	}
})();

$(function() {
	/** 全局TAB */
	window.$TOPBAR = $('#topbar-menu');
	window.$LEFT_SIDE = $('#left-side');
	window.$RIGHT_SIDE = $('#right-side');
	window.$MAIN_TABS = $(DIV).append($(UL)).appendTo($RIGHT_SIDE);
	
	//初始化tab
	$MAIN_TABS.tabs({
		tabTemplate: "<li><a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>",
		add: function(event, ui ) {
			var $panel = $(ui.panel);
			var pageName = ui.tab.hash.substring(1);
			var $div = $(DIV).addClass('content-wrapper').appendTo($panel);
			
			$div.bind('afterPageLoaded', function(){
				$MAIN_TABS.trigger('afterAddTab', [ui, this]);
			});
			//初始页面
			$div.loadAdminPage({pageName: pageName, rows: cookie('rows')});
			
			if(pageName != 'index') {
				$MAIN_TABS.tabs('select', ui.index);
				var $pageDiv = $(DIV).addClass('page').appendTo($panel);
				$pageDiv.loadPaginate({pageName: pageName, rows: cookie('rows')});
				$pageDiv.bind('pageChange', function(event2, p){
					//分页处理
					$div.loadAdminPage({pageName: pageName, page: p, rows: cookie('rows')});
					
				});
			}
		}
	});
	//增加tab后既处理
	$MAIN_TABS.bind('afterAddTab', function(event, tab, table){
		initTableEditor(tab);
		initTableButtons(table);
	});
	//增加一个首页tab
	$MAIN_TABS.tabs('add', '#index', 'Home');
	//tab关闭事件
	$MAIN_TABS.on('click', "span.ui-icon-close", function() {
		var index = $("li", tabsWrapper).index($( this ).parent());
		$MAIN_TABS.tabs("remove", index);
	});

	//菜单事件
	$LEFT_SIDE.bind('afterMenuLoaded', function(event, menu){
		$(this).find('.sub-menu .item a').click(function(){
			var item = $(this);
			$MAIN_TABS.tabs('add', item.attr('href'), item.text());
		});
	});
	//读取菜单
	$LEFT_SIDE.loadMenu();
	
	
});


/**
 * 初始化tab panel的可以编辑属性
 * @param $tabPanel 目标tabPanel
 */
function initTableEditor(ui) {
	var $tabPanel = $(ui.panel);
	var isChanged = false;
	
	$tabPanel.find('td .editable').editable().bind('afterChange', function(event, $input){
		var $in = $(this);
		var $idInput = $in.parent().parent().find('.id-holder input');
		var updateProp = $input.attr('name');
		var data = {};
		data['pageName'] = ui.tab.hash.substring(1);
		data[$idInput.attr('name')] = $idInput.val();
		data[$input.attr('name')] = $input.val();
		console.log($input);
		console.log(data);
	});
//	$tabPanel.find('.editable').click(function(){
//		$(this).find('span').hide();
//		$(this).find('input').show().focus();
//	});
//	$tabPanel.find('.editable input').blur(function(){
//		var $in = $(this);
//		$in.hide();
//		$in.parent().find('span').show();
//		//如果未修改过，则操作完毕
//		if(!isChanged) return;
//		var $idInput = $in.parent().parent().find('.id-holder input');
//		var data = {
//				$in.attr('name')]: $in.val(),
//				pageName: ui.tab.hash.substring(1),
//				id: $idInput.val()
//		};
//		$.ajax({
//			url: contextPath + 'admin/' + ui.tab.hash.substring(1) + '/update/' + $idInput.val(),
//			type: 'POST',
//			data: data
//		}).done(function(msg){
//			log(msg);
//			isChanged = false;
//		});
//	}).change(function(){
//		$(this).parent().find('span').text($(this).val());
//		isChanged = true;
//	});
}
function initTableButtons(table) {
	var $editBtns = $(table).find('.button-edit');
	$editBtns.click(function(){
		
	});
}

/**
 * @see #fixTextLength($el, len, suffix)
 */
function smallTextLength($el) {
	fixTextLength($el, SMALL_TEXT_LENGTH);
}
/**
 * 修正元素的文本数据长度
 * @param $el 元素jquery对象
 * @param len 长度
 * @param suffix 后缀，例如...
 */
function fixTextLength($el, len, suffix) {
	if(!suffix)
		suffix = '...';
	var text = $el.text();
	if(text.length > len) {
		$el.text(text.substring(0, len) + suffix);
	}
}

function debug(msg) {
	
}
function log(msg) {
	
}