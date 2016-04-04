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
var path = window.location.href.split("/")[3];

function ajaxReq(url){
	url='/'+path+url;
	var selectedPageSize = $('#pageSizeSelect').val();
	$("#resultsBlock").load(url+"&pageSize="+selectedPageSize);
}

function retrieveGuests() {
	var url = '/'+path+'/guest/ajax';
	
	if ($('#searchSurname').val() != '') {
		url = url + '/' + $('#searchSurname').val();
	}
	
	$("#resultsBlock").load(url);
}