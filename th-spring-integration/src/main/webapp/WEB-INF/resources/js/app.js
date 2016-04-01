$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace("/th/?pageSize=" + this.value);
	});

	$('.pageLink').click(function(evt) {
		var selectedPageSize = $('#pageSizeSelect').val();
		this.href = this.href.replace("?page=", '?pageSize=' + selectedPageSize + '&page=');

	});
}

function ajaxReq(url){
	$("#resultsBlock").load(url);
}