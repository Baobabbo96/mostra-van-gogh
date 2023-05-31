let importo = 0;
const check = document.querySelectorAll('.quiz_checkbox');
check.forEach(c => {
	c.addEventListener('change',() => {
		const prezzo = parseFloat(c.getAttribute('price'));
		if (c.checked) {
			importo += prezzo;
		} else {
			importo -= prezzo;
		}
		document.getElementById("importo").innerHTML = 'IMPORTO: ' + importo.toFixed(2) + '€';
	})
})