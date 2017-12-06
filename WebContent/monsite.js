function open_devis(){
   
    var name = document.getElementById("name").value;
    var subname = document.getElementById("subname").value;
    var personnes = document.getElementById("personnes").value;

   	window.open('devis.html','Devis');
   	document.getElementById('montant').innerHTML = name;


    
    }
