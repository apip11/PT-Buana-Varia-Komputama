import { React, useState, useEffect } from 'react'
import { useNavigate } from 'react-router-dom';

import './Dashboard.css';

export const Dashboard = () => {

    const [uemail, setuemail] = useState(localStorage.getItem("uemail"));
    let upass = localStorage.getItem("upass");
    let uname = localStorage.getItem("uname");
    let umobile = localStorage.getItem("umobile");
    let urole = localStorage.getItem("urole");

    const navigate = useNavigate();

    useEffect(() => {
        if (uemail === null || uemail === '') {
            console.log(uemail);
            navigate('/login');
        }
    })
    
    const logout = () => {
        localStorage.removeItem("uemail")
        localStorage.removeItem("upass")
        localStorage.removeItem("uname")
        localStorage.removeItem("umobile")
        localStorage.removeItem("urole")

        window.location.reload()
    }

    return (
        <div className='container'>
            
            <h1 className='my-5'>User Login :</h1>
            <div className='float-right'>
                <button className='btn btn-danger' onClick={() => logout()}>LOGOUT</button>
            </div>

            <div className='card p-3 m-3'>

                <h2>Nama : {uname}</h2>
                <h2>Nomor Telepon : {umobile}</h2>
                <h2>Email : {uemail}</h2>
                <h2>Pass : {upass}</h2>
                <h2>Role : {urole}</h2>

            </div>
        </div >

    )
}
