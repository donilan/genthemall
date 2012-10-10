/**
 * jquery扩展
 * @author Doni
 * @since 2012-10-06
 */
(function($){
	
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
	 * 读取menu
	 */
	$.fn.loadMenu = function(options) {
		
		this.trigger('beforeMenuLoaded');
		var defaults = {
			type: 1
		};
		var options = $.extend(defaults, options);
		var that = this;
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
		var $that = $(this[0]);
		var defaults = {
			page: 'page',
			done: function(html) {
				$that.empty();
				$that.html(html);
				$that.trigger('afterPageLoaded', [html]);
			}
		};
		$.extend(options, defaults);
		$.adminAjax(options);
		return $that;
	};
	
	$.fn.loadPaginate = function(options, data) {
		var $that = $(this[0]);
		var defaults = {
				data: {rows: 12},
				done: function(count) {
					var rows = parseInt(this.data.rows);
					if(count <= rows) return;
					$that.paginate({
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
							$that.trigger('pageChange', [p]);
						}
					});
				}
		}
		var options = $.extend(defaults, options);
		$.adminAjax(options, data);
		return this;
	};
	
	$.fn.editable = function(options) {
		$(this).each(function(){
			var $that = $(this);
			var attr = $that.data();
			$that.click(function(){
				$this = $(this);
				var $input = $('<input />');
				$input.val($this.text());
				$input.attr('name', attr.name);
				switch(attr.type) {
					case 'java.lang.String':
						$input.attr({'type': 'text', 'maxLength': attr.maxLength});
						break;
					case 'java.lang.Integer':
					case 'java.lang.Long':
						$input.attr({'type': 'text', 'maxLength': 10});
						break;
				}
				$this.hide();
				$input.appendTo($this.parent()).focus();
				$that.trigger('clicked', [$input]);
				$input.change(function(){
					$that.trigger('valueChange');
				});
				$input.blur(function(){
					$that.trigger('afterChange', [$input]);
					$this.text($input.val());
					$input.remove();
					$this.show();
				});
			});
		});
		return $(this);
	};
	
	$.fn.serializeJSON=function() {
		var json = {};
		jQuery.map($(this).serializeArray(), function(n, i){
			json[n['name']] = n['value'];
		});
		return json;
	};
	
	$.format = function(text, data) {
		for(var k in data) {
			var regex = new RegExp("\\$\\{\\s*"+k+"\\s*}", 'g');
			text = text.replace(regex, data[k]);
		}
		return text;
	};
	
	$.adminAjax = function(options, data) {
		var defaults = {
			method: 'GET',
			action: 'index',
			page: '',
			id: '',
			done: function(){}
		};
		var options = $.extend(defaults, options);
		var url = $.format(contextPath + 'admin/${action}/${page}/${id}', options);
		url = url.replace(new RegExp('/+', 'g'), '/');
		$.ajax({
			url: url,
			type: options.method,
			data: options.data
		}).done(function(data){
			options.done(data);
		});
	};
})(jQuery);