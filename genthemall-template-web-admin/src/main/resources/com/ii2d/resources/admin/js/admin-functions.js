var DEFAULT_ROWS = 15;
var Admin = {
	loadPage: function($el, pageName, page, rows) {
		if(rows == undefined)
			rows = DEFAULT_ROWS;
		var data = {
				page: page,
				rows: rows
		};
		$.ajax({
			url: contextPath + 'admin/' + pageName + '/page',
			data: data,
			type: 'GET'
		}).done(function(html){
			$el.html('');
			$el.append(html);
			$el.trigger('pageLoaded');
		});
	}
};