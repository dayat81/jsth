function retrieveGuests() {
	var url = '/th/guests';
	
	if ($('#searchSurname').val() != '') {
		url = url + '/' + $('#searchSurname').val();
	}
	
	$("#resultsBlock").load(url);
}