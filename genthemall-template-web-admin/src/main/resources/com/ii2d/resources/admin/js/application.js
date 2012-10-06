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
			$div.loadAdminPage({pageName: pageName});
			
			if(pageName != 'index') {
				$MAIN_TABS.tabs('select', ui.index);
				var $pageDiv = $(DIV).addClass('page').appendTo($panel);
				$pageDiv.loadPaginate({pageName: pageName});
			}
		}
	});
	$MAIN_TABS.bind('afterAddTab', function(event, tab, table){
		
	});
	$MAIN_TABS.tabs('add', '#index', 'Home');
	$MAIN_TABS.on('click', "span.ui-icon-close", function() {
		var index = $("li", tabsWrapper).index($( this ).parent());
		$MAIN_TABS.tabs("remove", index);
	});

	$LEFT_SIDE.bind('afterMenuLoaded', function(event, menu){
		$(this).find('.sub-menu .item a').click(function(){
			var item = $(this);
			$MAIN_TABS.tabs('add', item.attr('href'), item.text());
		});
	});
	//初始化菜单
	$LEFT_SIDE.loadMenu();
	//初始化弹出菜单
//	$TOPBAR.find('.popmenu').hover(function() {
//		$(this).addClass("hover");
//	}, function() {
//		$(this).removeClass("hover");
//	});
	
	
});


/**
 * 初始化tab panel的可以编辑属性
 * @param $tabPanel 目标tabPanel
 */
function initTableEditor(ui) {
	var $tabPanel = $(ui.panel);
	var isChanged = false;
	$tabPanel.find('td span').each(function(i, el){
		smallTextLength($(el));
	});
	$tabPanel.find('.editable').click(function(){
		$(this).find('span').hide();
		$(this).find('input').show().focus();
	});
	$tabPanel.find('.editable input').blur(function(){
		var $in = $(this);
		$in.hide();
		$in.parent().find('span').show();
		//如果未修改过，则操作完毕
		if(!isChanged) return;
		var $idInput = $in.parent().parent().find('.id-holder input');
		var data = {};
		data[$in.attr('name')] = $in.val();
		$.ajax({
			url: contextPath + 'admin/' + ui.tab.hash.substring(1) + '/' + $idInput.val(),
			type: 'POST',
			data: data
		}).done(function(data){
			log(data);
			isChanged = false;
		});
	}).change(function(){
		$(this).parent().find('span').text($(this).val());
		isChanged = true;
	});
}

function initPage(ui) {
	var $tabPanel = $(ui.panel);
	var $page = $tabPanel.find('.page');
	var count = $page.find('input[name=count]').val();
	var page = $page.find('input[name=page]').val();
	if(count == undefined || page == undefined)
		return;
	$page.paginate({
		count: count,
		start: page,
		display: 10,
		border: true,
		border_color: '#BEF8B8',
		text_color: '#68BA64',
		background_color: '#E3F2E1',	
		border_hover_color: '#68BA64',
		text_hover_color: 'black',
		background_hover_color: '#CAE6C6', 
		rotate: false,
		images: false,
		mouse: 'press',
		onChange: function(p){
			console.log(p);
		}
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