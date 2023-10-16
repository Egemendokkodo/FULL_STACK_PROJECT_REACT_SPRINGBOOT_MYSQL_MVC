import React, { useState } from 'react'

import "./loginform.css"
import {useNavigate} from "react-router-dom"
import { EyeInvisibleOutlined, EyeOutlined } from "@ant-design/icons"
const LoginForm = () => {

    const [popupStyle, showPopup] = useState("hide")

    const popup = () => {
        showPopup("login-popup")
        setTimeout(() => showPopup("hide"), 3000)
    }
    const navigate=useNavigate()
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [visible, setVisible] = useState(false);

    const handleLogin = (e) => {
        e.preventDefault();
      
        const data = { email, password };
      
        fetch("http://localhost:8080/api/users/login", {
          method: "POST",
          headers: { "Content-Type": "application/json" },
          body: JSON.stringify(data),
        })
          .then((response) => response.json())
          .then((data) => {
            alert(data.message);
          })
          .catch((error) => {
            console.error("Hata oluştu: ", error);
            alert("Giriş sırasında bir hata oluştu.");
          });
      };


    /*function yazdir(){
        const email_value=document.getElementById("email_textfield").value
        const password_value=document.getElementById("password_textfield").value
        console.log(email_value)
        console.log(password_value)
    }*/

    return (
        <div className="page">
        <div className='cover'>
            <h1>Login</h1>
            <input id='email_textfield' type='text' placeholder='email' className='input-email' onChange={(e)=>setEmail(e.target.value)}></input>
            <input id='password_textfield' type={visible ? "text" : "password"} placeholder='password' className='input-password' onChange={(e) => setPassword(e.target.value)}></input>
            <div onClick={() => setVisible(!visible)} className="password-toggle-icon-login">
                    {
                        visible ? <EyeOutlined /> : <EyeInvisibleOutlined />
                    }
            </div>
            
            <div className='login-btn' onClick={handleLogin} type="submit">Login</div>
            
            <div className='dont-have-an-account-container'>
            <p>Don't have an account?</p>
            <div className='spacer'></div>
            <p className='sign-up-button' onClick={() => navigate("signUp")}>Sign up</p>
            </div>
            
                
            <p className='text'>or login using</p>
                

            
            <div className='alt-login'>
                <button className='circle-btn-google' type="google"></button>
                <button className="circle-btn-facebook" type="facebook"></button>
            </div>
            <div className={popupStyle}>
                <h3>Login Failed</h3>
                <p>Username or password is incorrect.</p>
            </div>


        </div></div>

    )
}
export default LoginForm
