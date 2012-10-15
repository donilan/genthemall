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
var LOG = {
		debug: function(msg) {
			console.log(msg);
		},
		info: function(msg) {
			console.log(msg);
		},
		error: function(msg) {
			console.log(msg);
		}
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
	less.watch();
})();

$(function() {
	LOG.info('Context path is: ' + contextPath);
	/** 全局TAB */
	window.$TOPBAR = $('#topbar-menu');
	window.$LEFT_SIDE = $('#left-side');
	window.$RIGHT_SIDE = $('#right-side');
//	window.$MAIN_TABS = $(DIV).append(UL).appendTo($RIGHT_SIDE);
	window.$MAIN_TABS = $('#main-tabs')
	
	//初始化tab
	$MAIN_TABS.tabs({
		tabTemplate: "<li><a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>",
		add: function(event, ui ) {
			var $panel = $(ui.panel);
			var action = getAction(ui);
			var $wrapper = $(DIV).addClass('content-wrapper').appendTo($panel);
			var $searchBar = $(DIV).addClass('search-bar').appendTo($wrapper);
			var $tablePage = $(DIV).addClass('table-wrapper').appendTo($wrapper);
			var $paginate = $(DIV).addClass('paginate').appendTo($wrapper);
			
			$tablePage.bind('afterPageLoaded', function(){
				initTableEditor(ui);
				var $buttons = $(this).find('.button').button();
				initEditBtn($(this).find('.button-edit'));
				initDeleteBtn($(this).find('.button-delete'));
			});
			$searchBar.bind('afterPageLoaded', function(){
				var $buttons = $(this).find('.button').button();
				initCreateBtn($(this).find('.button-create'));
				initSearchBtn($(this).find('.button-search'));
				initAdvancedSearchBtn($(this).find('.button-advanced-search'));
			});
			
			LOG.info('Loading tab for action: ' + action);
			if(action != 'index') {
				
				$searchBar.loadAdminPage({action: action, page: 'searchBar'});
				
				//初始页面
				$tablePage.loadAdminPage({action: action, page: 'advancedSearch', data: {rows: cookie('rows')}});
				$MAIN_TABS.tabs('select', ui.index);
				
				$paginate.loadPaginate({action: action, page: 'count', data: {rows: cookie('rows')}});
				$paginate.bind('pageChange', function(event2, p){
					//分页处理
					$tablePage.loadAdminPage({action: action, page: 'advancedSearch', data: {page: p, rows: cookie('rows')}});
				});
			}else {
				$tablePage.loadAdminPage({action: action, page: 'page', data: {rows: cookie('rows')}});
			}
			
		}
	});
	//tab关闭事件
	$MAIN_TABS.on('click', "span.ui-icon-close", function() {
		var index = $("li", $MAIN_TABS).index($( this ).parent());
		$MAIN_TABS.tabs("remove", index);
	});
	
	//增加一个首页tab
//	$MAIN_TABS.tabs('add', '#index', 'Home');
	

	//菜单事件,增加tab
	$LEFT_SIDE.bind('afterMenuLoaded', function(event, menu){
		$(this).find('.sub-menu .item a').click(function(){
			var item = $(this);
			var tabName = item.attr('href').substring(1);
			var selectTab = null;
			$MAIN_TABS.find('.ui-tabs-nav li>a').each(function(){
				if($(this).attr('href') == tabName)
					selectTab = $(this).parent();
			});
			if(selectTab != null) {
				var index = $("li", $MAIN_TABS).index(selectTab);
				$MAIN_TABS.tabs('select', index);
				return;
			}
			$MAIN_TABS.tabs('add', '#tab-'+tabName, item.text());
		});
	});
	//读取菜单
	LOG.info('Loading menu...');
	$LEFT_SIDE.loadMenu();
	$LEFT_SIDE.bind('afterMenuLoaded', function(){
		$(this).find('.menu-wrapper>.menu').menu({
			
		});
	});
	
});

function getAction(ui) {
	return ui.tab.hash.substring('#tab-'.length);
}

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
		var data = {};
		data[$input.attr('name')] = $input.val();
		$.adminAjax({
			action: getAction(ui),
			page: 'update',
			method: 'POST',
			id: $idInput.val(),
			data: data
		});
	});
}

function initEditBtn($editBtns) {
	$editBtns.click(function(){
		var $btn = $(this);
		var options = $(this).data();
		options.done = function(html){
			$(DIV).addClass('dialog').html(html).attr('title', '编辑').dialog({
				modal: true,
				height: '400',
				buttons: {
					'保存': function() {
						var updateOptions = {
							data: $(this).find('form').serialize(),
							action: options.action,
							method: 'POST',
							id: options.id,
							page: 'update'
						};
						$.adminAjax(updateOptions);
						$(this).dialog('close');
					}
				},
				close: function() {
					$(this).remove();
				}
			});
		};
		$.adminAjax(options);
	});
};

function initDeleteBtn($deleteBtns) {
	$deleteBtns.click(function(){
		var $that = $(this);
		
		$(DIV).addClass('dialog').attr('title', '请选择一个操作').html('<h1>请确定是否需要删除?</h1>').dialog({
			modal: true,
			buttons: {
				'确定删除': function() {
					var options = $that.data();
					options.method = 'DELETE';
					options.done = function(msg) {
						$that.parents('tr:first').hide(1000);
					};
					$.adminAjax(options);
					$(this).dialog('close');
				},
				'取消': function() {
					$(this).dialog('close');
				}
			},
			close: function() {
				$(this).remove();
			}
		});
		
	});
};

function initCreateBtn($createBtn) {
	$createBtn.click(function(){
		var $btn = $(this);
		var options = $btn.data();
		options.done = function(html){
			$(DIV).addClass('dialog').html(html).attr('title', '添加').dialog({
				modal: true,
				height: '400',
				buttons: {
					'保存': function() {
						var saveOptions = {
							data: $(this).find('form').serialize(),
							action: options.action,
							method: 'POST',
							page: 'save'
						};
						$.adminAjax(saveOptions);
						$(this).dialog('close');
					}
				},
				close: function() {
					$(this).remove();
				}
			});
		};
		$.adminAjax(options);
	});
}

function initSearchBtn($btn) {
	var $input = $btn.parent().find('input[type=text]');
	if($input.size() < 1) {
		LOG.error('Cannot find search input form.');
		return;
	}
	$btn.click(function(){
		var $wrapper = $(this).parents('.content-wrapper:first');
		if($wrapper.size() > 1) {
			LOG.error('Found more than 1 wrapper.');
			return;
		}
		var $btn = $(this);
		var options = $btn.data();
		options.data = $input.serializeJSON();
		options.data.rows = cookie('rows');
		var $tableWrapper = $wrapper.find('.table-wrapper');
		var $pageWrapper = $wrapper.find('.paginate');
		$tableWrapper.loadAdminPage(options);
		$pageWrapper.empty();
		$pageWrapper.loadPaginate({action: options.action, page: 'count4search', data: options.data});
		$pageWrapper.unbind('pageChange');
		$pageWrapper.bind('pageChange', function(event2, p){
			//分页处理
			//TODO 未完成
			options.data.page = p;
			$tableWrapper.loadAdminPage(options);
		});
		
	});
}
function initAdvancedSearchBtn($btn) {
	
}
