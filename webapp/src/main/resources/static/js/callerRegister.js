window.onload = async () =>{
    formRegister();
}

const formRegister = async () =>{
    let registerForm = document.querySelector('#frmRegister');

    registerForm.addEventListener('submit',e=>{
        e.preventDefault();
        const formData = new FormData(e.currentTarget); 
        console.log(formData);
        //debugger
        data = {
            names:     formData.get('txtNames'),
            lastNames: formData.get('txtLastNames'),
            docType:   formData.get('cmbDocType'),
            docNumber: formData.get('txtDocNum'),
            bornDate:  formData.get('txtBornDate'),
            bornCity:  formData.get('txtCity'),
            phone:     formData.get('txtPhone'),
            username:  formData.get('txtUsername2'),
            password:  formData.get('txtPassword2')
        }

        register(data);
    });
}


const register = async (data) =>{
    console.log(data);

    await fetch("/user/register",
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
        return data.json()})
    .then(res=>{
        console.log(res);

        let messageContainer = document.querySelector('#message');
        let message = "";
        if(res){
            message = "Registro agregado con éxito";
        }
        else{
            message = "Falla al agregar registro";
        }
        messageContainer.innerHTML = `<span>${message}</span>`;
        //window.location.href = res.route;
    })
    .catch(err=>{
        console.log("Error al cargar: "+err)
    })
}
