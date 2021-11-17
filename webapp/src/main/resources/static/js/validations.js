
/*const StringValidation = async () =>{
    let logginForm = document.querySelector('#frmLogin');

    logginForm.addEventListener('submit',e=>{
        e.preventDefault();
        console.log("entro");
        const formData = new FormData(e.currentTarget); 
        console.log(formData);
        //debugger
        data = {
            username:formData.get('txtUsername'),
            password:formData.get('txtPassword')
        }

        loggin(data);
    });
}*/

window.onload = () =>{
    console.log('estoy en onload');
    textEvent();
}
//document.addEventListener("DOMContentLoaded", textEvent, false);

let textEvent = ()=>{
    let txtLastName = document.querySelector('#txtLastNames');

    txtLastName.addEventListener('keypress',letterValidation(e));
}

let letterValidation = (e) =>{ 
    let caracter = e.keycode;
    console.log("caracter: "+caracter);
    if (caracter != 30 || (caracter <=64 && caracter >90) 
        || (caracter <97 && caracter > 122) 
        || (caracter <160 && caracter > 165) )
        e.preventDefault();
}
