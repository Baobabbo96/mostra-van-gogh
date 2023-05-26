const nome = document.getElementById('nome');
const cognome = document.getElementById('cognome');
const email = document.getElementById('email');
const password = document.getElementById('password');
const form = document.getElementById('form');
const errorElement = document.getElementById('error');
var pattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;


const isValidEmail = email => {
    const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

form.addEventListener('submit', e =>{
    let messages = []
    if (nome.value === '' || nome.value == null){
        messages.push('é richiesto il nome');
    }

    if (messages.length > 0){
        e.preventDefault()
        errorElement.innerText = messages.join(', ');
    }

    if(password.value.length <=6){
        messages.push('é troppo corta deve essere composta da almeno 6 caratteri');
    }
    if(password.value.length > 20){
        messages.push('é troppo lunga deve essere meno di 20 caratteri');
    }
    if(email.matches(pattern)){
        form.classList.add("valid");
        from.classList.remove("invalid");
    } else {
        form.classList.remove("valid");
        form.classList.add("invalid");
    }


})