var DIV = '<div/>';
var UL = '<ul/>';
var LI = '<li/>';
var A = '<a href="###" />';
var SPAN = '<span/>';
var DEBUG = true;

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
	
	//初始化菜单
	initTopbarMenu($TOPBAR, getMenus());
	
	//初始化tab
	initTabs($MAIN_TABS);
	initTopbarClickEvent($TOPBAR, $MAIN_TABS);
	
	//初始化弹出菜单
	$TOPBAR.find('.popmenu').hover(function() {
		$(this).addClass("hover");
	}, function() {
		$(this).removeClass("hover");
	});
	
	
});

/**
 * 初始化topbar的点击事件
 * @param topbar
 * @param tabs
 */
function initTopbarClickEvent(topbar, tabs) {
	topbar.find('.sub-menu .menu-item').click(function(){
		var item = $(this);
		tabs.tabs('add', item.attr('href'), item.text());
	});
}

/**
 * 初始化tab panel的可以编辑属性
 * @param $tabPanel 目标tabPanel
 */
function initTableEditor(ui) {
	var $tabPanel = $(ui.panel);
	$tabPanel.find('.editable').click(function(){
		$(this).find('span').hide();
		$(this).find('input').show().focus();
	});
	$tabPanel.find('.editable input').blur(function(){
		var $in = $(this);
		$in.hide();
		$in.parent().find('span').show();
		var $idInput = $in.parent().parent().find('.id-holder input');
		var data = [];
		data[$in.attr('name')] = $in.val();
		$.ajax({
			url: contextPath + 'admin/' + ui.tab.hash.substring(1) + '/' + $idInput.val(),
			type: 'PUT',
			data: {'name': $in.val()}
		}).done(function(data){
			console.log(data);
		});
	}).change(function(){
		$(this).parent().find('span').text($(this).val());
	});
}

/**
 * 初始化tab
 * @param tabsWrapper tab容器
 */
function initTabs(tabsWrapper) {
	tabsWrapper.tabs({
		tabTemplate: "<li><a href='#{href}'>#{label}</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>",
		add: function( event, ui ) {
			var $panel = $(ui.panel);
			$.ajax({
				url: contextPath + 'admin/' + ui.tab.hash.substring(1),
				type: 'GET'
			}).done(function(html){
				$panel.append(html);
				//TODO 可优化为先加载数据，然后再显示
				initTableEditor(ui);
				tabsWrapper.tabs('select', ui.index);
			});
			
		}
	});
	tabsWrapper.tabs('add', '#index', 'Home');
	tabsWrapper.on('click', "span.ui-icon-close", function() {
		var index = $("li", tabsWrapper).index($( this ).parent());
		tabsWrapper.tabs("remove", index);
	});
	
}

/**
 * 初始化顶部菜单
 * @author Doni
 * @since 2012-09-21
 * @param menus 菜单
 */
function initTopbarMenu(wrapper, menus) {
	var elMenu = $(UL).addClass('menu');
	for(var i in menus) {
		var menu = menus[i];
		var menuLi = $(LI).addClass('popmenu');
		if(i == 0) menuLi.addClass('first');
		if(i == menus.length-1) menuLi.addClass('last');
		
		menuLi.append($(A).addClass('menu-item').append($(SPAN).text(menu.name)));
		if(menu.subMenus.length > 0) {
			var subMenuUL = $(UL).addClass('sub-menu');
			for(var i2 in menu.subMenus) {
				var subMenu = menu.subMenus[i2];
				subMenuUL.append($(LI).append(
						$(A).addClass('menu-item').attr('href', '#'+subMenu.menuKey)
						.append($(SPAN).text(subMenu.name))));
				
			}
			menuLi.append($(DIV).addClass('sub-menu-wrapper').append(subMenuUL));
		}
		
		elMenu.append(menuLi);
		
	}
	wrapper.append(elMenu);
}

/**
 * 获取所有菜单
 * @author Doni
 * @since 2012-09-21
 */
function getMenus() {
	var menus = [];
	$.ajax({
		url: contextPath + '/admin/menu?menuType=1&rows=999',
		type: 'GET',
		dataType: 'json',
		async: false
	}).done(function(data){
		var menuList = data['menuList'];
		for(var i in menuList) {
			var m = menuList[i];
			for(var i2 in menuList) {
				var sub = menuList[i2];
				if(!m.subMenus) {
					m.subMenus = [];
				}
				if(m.id == sub.parentId) {
					m.subMenus[m.subMenus.length] = sub;
				}
			}
			if(m.parentId == 0) {
				menus[menus.length] = m;
			}
		}
	});
	return menus;
}