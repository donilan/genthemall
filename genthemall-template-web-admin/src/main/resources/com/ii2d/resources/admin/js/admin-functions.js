var DEFAULT_ROWS = 15;
var URL_MENU = contextPath + 'admin/menu/list?menuType=1';
var TEMPLATE_MENU = 
	'<div>'+
	'	<div class="menu-wrapper" >'+
	'		<ul class="menu">'+
	'			{{each menus}}'+
	'			<li class="item icon-${menuKey}">'+
	'				<a href="#${menuKey}">${name}</a>'+
	'				<ul class="sub-menu">'+
	'					{{each subMenus}}'+
	'					<li class="item">'+
	'						<a href="#${menuKey}">${name}</a>'+
	'					</li>'+
	'					{{/each}}'+
	'				</ul>'+
	'			</li>'+
	'			{{/each}}'+
	'		</ul>'+
	'	</div>'+
	'</div>';

/**
 * admin web工具
 * @author Doni
 * @since 2012-10-06
 */
var Admin = {
	loadPage: function(options, callback) {
		if(options.pageName == undefined) {
			throw 'Param page cannot be null or empty.';
		}
		$.ajax({
			url: contextPath + 'admin/' + options.pageName + '/page',
			data: options,
			type: 'GET'
		}).done(function(html){
			callback(html, options);
		});
	},
	loadMenu: function(callback) {
		$.ajax({
			url: URL_MENU,
			type: 'GET',
			dataType: 'json'
		}).done(function(data){
			var menus = [];
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
			callback(menus);
		});
	},
	loadCount: function(options, callback) {
		if(options.pageName == undefined) {
			throw 'Param page cannot be null or empty.';
		}
		$.ajax({
			url: contextPath + 'admin/' + options.pageName + '/count',
			type: 'GET'
		}).done(function(data){
			callback(data);
		});
	}
};

/**
 * jquery扩展
 * @author Doni
 * @since 2012-10-06
 */
(function($){
	/**
	 * 读取menu
	 */
	$.fn.loadMenu = function(options) {
		this.trigger('beforeMenuLoaded');
		var defaults = {
			type: 1
		};
		var options = $.extend(defaults, options);
		var that = this;
		Admin.loadMenu(function(menus){
			that.each(function(i){
				$(TEMPLATE_MENU).tmpl([{menus: menus}]).appendTo(this);
				that.trigger('afterMenuLoaded', [menus]);
			});
		});
		return this;
	};
	
	$.fn.fixTextLength = function(len, suffix) {
		if(!suffix)
			suffix = '...';
		this.each(function(){
			var text = $(this).text();
			if(text.length > len) {
				$(this).text(text.substring(0, len) + suffix);
			}
		});
		return this;
		
	};
	
	$.fn.loadAdminPage = function(options) {
		this.trigger('beforePageLoaded');
		var that = this;
		Admin.loadPage(options, function(html, param){
			that.each(function(i){
				var $this = $(this);
				$this.empty();
				$this.html(html);
				$this.trigger('afterPageLoaded', [html, param]);
			});
		});
		return this;
	};
	
	$.fn.loadPaginate = function(options) {
		this.trigger('beforePaginateLoaded');
		var that = this;
		var rows = 12;
		if(options.rows != undefined && options.rows != null) {
			rows = parseInt(options.rows);
		}
		Admin.loadCount(options, function(count) {
			if(count <= rows) return;
			that.paginate({
				count: count / rows,
				start: 1,
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
					that.trigger('pageChange', [p]);
				}
			});
		});
		return this;
	};
})(jQuery);