import { React, useState, useEffect } from 'react'
import { Link, useNavigate } from 'react-router-dom';

import logo from '../assets/img/logo.png'

export const Register = () => {

  const [uname, setuname] = useState("")
  const [urole, seturole] = useState("")
  const [umobile, setumobile] = useState("")
  const [uemail, setuemail] = useState("")
  const [upass, setupass] = useState("")
  

  const navigate = useNavigate()

  useEffect(() => {
    if (localStorage.getItem('uemail') !== null && localStorage.getItem('uemail') != '') {
      navigate("/")
    }
  })

  const register = () => {
    localStorage.setItem("uname", uname);
    localStorage.setItem("urole", urole);
    localStorage.setItem("umobile", umobile);
    localStorage.setItem("uemail", uemail);
    localStorage.setItem("upass", upass);
    alert(uname + " : " + urole + " : "+ umobile + " : " + uemail + " : " + upass + " | " + " Register Successful!")
  }

  return (
    <div class="container">

      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <Link to="/register" class="logo d-flex align-items-center w-auto">
                  <img src={logo} alt="" />
                  <span class="d-none d-lg-block">Register</span>
                </Link>
              </div>

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Create an Account</h5>
                  </div>

                  <form class="row g-3 needs-validation" onSubmit={register}>
                    <div class="col-12">
                      <label for="yourName" class="form-label">Nama</label>
                      <input type="text" name="name" value={uname} onChange={(e) => { setuname(e.target.value) }} class="form-control" id="yourName" required />
                      <div class="invalid-feedback">Please, enter your name!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourRole" class="form-label"> Role </label>
                      <select name="role" value={urole} onChange={(e) =>{ seturole(e.target.value) }} class="form-control" id="yourRole" required >
                        <option value=" " disabled> </option>
                        <option value="User"> User </option>
                        <option value="Admin"> Admin </option>
                      </select>
                      <div class="invalid-feedback">Please enter your role!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourMobile" class="form-label">Nomor Telepon</label>
                      <input type="number" name="mobile" value={umobile} onChange={(e) => { setumobile(e.target.value) }} class="form-control" id="yourMobile" required />
                      <div class="invalid-feedback">Please enter a valid Mobile adddress!</div>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Email</label>
                      <div class="input-group has-validation">
                        <input type="text" name="email" value={uemail} onChange={(e) => { setuemail(e.target.value) }} class="form-control" id="yourEmail" required />
                        <div class="invalid-feedback">Please choose a Email!</div>
                      </div>
                    </div>

                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Password</label>
                      <input type="password" name="password" value={upass} onChange={(e) => { setupass(e.target.value) }} class="form-control" id="yourPassword" required />
                      <div class="invalid-feedback">Please enter your password!</div>
                    </div>

                    {/* <div class="col-12">
                      <div class="form-check">
                        <input class="form-check-input" name="terms" type="checkbox" value="" id="acceptTerms" required />
                        <label class="form-check-label" for="acceptTerms">I agree and accept the <Link to="#">terms and conditions</Link></label>
                        <div class="invalid-feedback">You must agree before submitting.</div>
                      </div>
                    </div> */}
                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Create Account</button>
                    </div>
                    <div class="col-12">
                      <p class="small mb-0">Already have an account? <Link to="/">Log in</Link></p>
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
