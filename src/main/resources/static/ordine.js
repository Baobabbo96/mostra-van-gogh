/**
 * funzione che mostra l'importo di un ordine in modo dinamico.
 */

let importo = 0;
const check = document.querySelectorAll('.check');
check.forEach(c => {
	c.addEventListener('change',() => {
		const prezzo = parseFloat(c.getAttribute('price'));
		if (c.checked) {
			importo += prezzo;
		} else {
			importo -= prezzo;
		}
		document.getElementById("importo").innerHTML = 'IMPORTO: ' + importo + '€';
	})
})