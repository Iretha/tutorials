function clickButton(id) {
	// alert(id);
	var btn = document.getElementById(id);
	if (btn) {
		btn.click();
	} else {
		alert('Btn ' + id + ' not found!');
	}
}

$('html').bind('keypress', function(e) {
	if (e.keyCode == 13 && e.target.tagName != 'TEXTAREA') {
		return false;
	}
});

function findElementValue(id) {
	if (document.getElementById(id)) {
		return document.getElementById(id).value;
	}
	return '';
}