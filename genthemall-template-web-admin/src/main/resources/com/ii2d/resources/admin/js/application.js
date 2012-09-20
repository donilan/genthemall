var DIV = '<div/>';
var UL = '<ul/>';
var LI = '<li/>';
var A = '<a href="###" />';
var SPAN = '<span/>';

$(function() {
	initTopbarMenu($('#topbar-menu'), getMenus());
	
	$('#topbar-menu .popmenu').hover(function() {
		$(this).addClass("hover");
	}, function() {
		$(this).removeClass("hover");
	});
	
	
});

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
						$(A).addClass('menu-item').attr('href', '###'+subMenu.menuKey)
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
				if(m.id = sub.parentId) {
					m.subMenus[m.subMenus.length] = sub;
				}
			}
			if(m.parentId == 0) {
				menus[menus.length] = m;
			}
		}
		console.log(menus);
	});
	return menus;
}