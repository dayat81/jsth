/*$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		//window.location.replace("/th/ajax/?pageSize=" + this.value);
		ajaxReq("/th/ajax/?pageSize=" + this.value);
	});

	$('.pageLink').click(function(evt) {
		var selectedPageSize = $('#pageSizeSelect').val();
		this.href = this.href.replace("?page=", '?pageSize=' + selectedPageSize + '&page=');

	});
} */

function ajaxReq(url){
	var selectedPageSize = $('#pageSizeSelect').val();
	$("#resultsBlock").load(url+"&pageSize="+selectedPageSize);
}

function retrieveGuests() {
	var url = '/th/guest/ajax';
	
	if ($('#searchSurname').val() != '') {
		url = url + '/' + $('#searchSurname').val();
	}
	
	$("#resultsBlock").load(url);
}