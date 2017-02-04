function anyFunction(string) {
	return string;
}

function arrayOrListFunction(arrayOrList) {// Accept an array like int[] and list.
	var string = "";
	for (var i = 0; i < arrayOrList.length; i++) {
		string += arrayOrList[i] + "\n";
	}
	return string;
}

function mapFunction(map) {// Accept a map.
	var string = "";
	for (var key in map) {
		string += key + " : " + map[key] + "\n";
	}
	return string;
}