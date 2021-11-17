window.onload = async () =>{
    formEvent();
}

const formEvent = async () =>{
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
}


const loggin = async (data) =>{
    //console.log(JSON.stringify(data));
    console.log(data);

    await fetch("/user/login",
    {
        method:'POST',
        //mode:  'no-cors',
        headers: {
            'Accept': 'application/json, text/plain, */*',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(data=>{
        console.log(data);
        if(data.status != 202)
            return undefined;
        return data.json()})
    .then(res=>{
        console.log(res);
        if(res != undefined)
            window.location.href = res.route;
        else{
            console.log("Fallido");
            let messageContainer = document.querySelector('#message');
            let message = "Usuario o contraseña incorrectos";
            messageContainer.innerHTML = `<span>${message}</span>`;
        }
            
    })
    .catch(err=>{
        console.log("Error al cargar: "+err)
    })
} 
