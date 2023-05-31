/* Script per l'apertura della sidebar */ 
function apriMenu() {
    var sidebar = document.querySelector('.sidebar');
    sidebar.classList.toggle('sidebar-open');
  }
  
  function closeMenu() {
    var sidebar = document.querySelector('.sidebar');
    sidebar.classList.remove('sidebar-open');
  }
  window.addEventListener('click', function(event) {
    var sidebar = document.querySelector('.sidebar');
    var menuToggle = document.querySelector('.menu-toggle');
  
    if (!sidebar.contains(event.target) && !menuToggle.contains(event.target)) {
      sidebar.classList.remove('sidebar-open');
    }
  });
  
  function replaceLoginWithImage() {
    var loginBtn = document.getElementById('loginBtn');
    var profileImg = document.getElementById('profileImg');
  
    // Nascondi il bottone di login
    loginBtn.style.display = 'none';
    // Mostra l'immagine generica del profilo
    profileImg.style.display = 'inline';
  }
  
  // Verifica se è presente il parametro 'logged' nell'URL
  var urlParams = new URLSearchParams(window.location.search);
  if (urlParams.has('logged')) {
    // Se il parametro 'logged' è presente, sostituisci il bottone con l'immagine
    replaceLoginWithImage();
}


// bottone per tornare su
const btnScrollToTop = document.querySelector("#btnScrollToTop");

btnScrollToTop.addEventListener("click", function() {


 window.scrollTo( {
    top:0,
    left:0,
    behavior: "smooth"
 })


});