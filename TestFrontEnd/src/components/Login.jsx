import { React, useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom';

import '../assets/css/style.css'
import logo from '../assets/img/logo.png'

export const Login = () => {

    const [uemail, setuemail] = useState('')
    const [upass, setupass] = useState('')

    const navigate = useNavigate()

    const login = () => {
        let email = localStorage.getItem("uemail")
        let pass = localStorage.getItem("upass")

        if (uemail === email && upass === pass) {
            alert(uemail + " : " + upass + " | Login Successful!")
            navigate("/")
        } else {
            alert("Anda Tidak Memiliki Akun, Silahkan Membuat Akun!")
        }
    }
  
    return (
        <div className="container">

            <section className="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
                <div className="container">
                    <div className="row justify-content-center">
                        <div className="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

                            <div className="d-flex justify-content-center py-4">
                                <Link href="index.html" className="logo d-flex align-items-center w-auto">
                                    <img src={logo} alt="" />
                                    <span className="d-none d-lg-block">Login</span>
                                </Link>
                            </div>
                            {/* <!-- End Logo --> */}

                            <div className="card mb-3">

                                <div className="card-body">

                                    <div className="pt-4 pb-2">
                                        <h5 className="card-title text-center pb-0 fs-4">Login to Your Account</h5>
                                        <p className="text-center small">Enter your Email & password to login</p>
                                    </div>

                                    {/* <form className="row g-3 needs-validation" noValidate> */}
                                    <form className="row g-3 needs-validation" onSubmit={login}>

                                        <div className="col-12">
                                            <label htmlFor="yourEmail" className="form-label">Email</label>
                                            <div className="input-group has-validation">
                                                <input type="text" name="email" value={uemail} onChange={(e) => { setuemail(e.target.value) }} className="form-control" id="yourEmail" required />
                                                <div className="invalid-feedback">Please enter your Email.</div>
                                            </div>
                                        </div>

                                        <div className="col-12">
                                            <label htmlFor="yourPassword" className="form-label">Password</label>
                                            <input type="password" name="password" value={upass} onChange={(e) => { setupass(e.target.value) }} className="form-control" id="yourPassword" required />
                                            <div className="invalid-feedback">Please enter your password!</div>
                                        </div>

                                        <div className="col-12">
                                            <div className="form-check">
                                                <input className="form-check-input" type="checkbox" name="remember" value="true" id="rememberMe" />
                                                <label className="form-check-label" htmlFor="rememberMe">Remember me</label>
                                            </div>
                                        </div>
                                        <div className="col-12">
                                            <button className="btn btn-primary w-100" type="submit">Login</button>
                                        </div>
                                        <div className="col-12">
                                            <p className="small mb-0">Don't have account? <Link to='/register'>Create an account</Link></p>
                                        </div>
                                    </form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </section>

        </div>
    )
}
