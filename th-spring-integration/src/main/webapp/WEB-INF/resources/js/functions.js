var path = window.location.href.split("/")[3];

function retrieveGuests() {
	var url = '/'+path+'/guests';
	
	if ($('#searchSurname').val() != '') {
		url = url + '/' + $('#searchSurname').val();
	}
	
	$("#resultsBlock").load(url);
}